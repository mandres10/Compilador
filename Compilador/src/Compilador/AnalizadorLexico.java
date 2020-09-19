package Compilador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

import AccionesSemanticas.AccionSemantica;
import AccionesSemanticas.as_AgregarAlBuffer;
import AccionesSemanticas.as_ERROR_AL;
import AccionesSemanticas.as_Error;
import AccionesSemanticas.as_FinCadena;
import AccionesSemanticas.as_FinComentario;
import AccionesSemanticas.as_FinDouble;
import AccionesSemanticas.as_FinID;
import AccionesSemanticas.as_FinPalRes;
import AccionesSemanticas.as_FinSimbolo;
import AccionesSemanticas.as_FinSimboloCompuesto;
import AccionesSemanticas.as_FinUint;
import AccionesSemanticas.as_NoAction;

public class AnalizadorLexico {
	
	static public String lexema = "";
	private static boolean acomodarLinea= false; // acomodar linea y tomar la lectura anterior
	protected static int asciiAnt = 0;
	private static int nroLinea= 1;
	static StringBuffer buffer = new StringBuffer();
	static Hashtable<String,Simbolo> TablaSimbolo = new Hashtable<String,Simbolo>();
	static int caracter = -2;
	private static HashMap<String, Integer> TablaToken = new HashMap<String,Integer>();
	
	static MatrizDeAcciones matriz_AS =  new MatrizDeAcciones();
	static MatrizDeEstados matriz_de_estados = new MatrizDeEstados();
	
	
	static DiccionarioAscii diccionario = new DiccionarioAscii();
	
	
	static AccionSemantica as_AgregarAlBuffer = new as_AgregarAlBuffer(); 
	static AccionSemantica as_NoAction = new as_NoAction(); 
	static AccionSemantica as_FinSimbolo = new as_FinSimbolo(); 
	static AccionSemantica as_FinPalRes = new as_FinPalRes(TablaToken);
	static AccionSemantica as_ERROR_AL = new as_ERROR_AL();
	static AccionSemantica as_Error = new as_Error();
	static AccionSemantica as_FinID = new as_FinID(TablaSimbolo, TablaToken);
	static AccionSemantica as_FinDouble =  new as_FinDouble(TablaSimbolo, TablaToken);
	static AccionSemantica as_FinUint = new as_FinUint(TablaSimbolo, TablaToken);
	static AccionSemantica as_FinCadena = new as_FinCadena(TablaSimbolo, TablaToken);
	static AccionSemantica as_FinSimboloCompuesto = new as_FinSimboloCompuesto(TablaToken);
	static AccionSemantica as_FinComentario = new as_FinComentario();
	
	
	FileReader fr;
	static BufferedReader br;
	
	public void cargarArchivo(String origen) throws IOException{

		fr = new FileReader(origen);
	    br = new BufferedReader(fr);
	}
	
	public Token getToken() throws IOException {
	Token t = new Token();
	
	if(asciiAnt == -1)    	//Fin del archivo, devuelve 0
	{
		t.setToken(0); 
		return t;
	}		
	
	int estadoSig = 0;
	int estado = 0;
	boolean hayToken = false;
	int ascii;
	do 
	{	if (acomodarLinea)
		{
			ascii = asciiAnt;
			acomodarLinea = false;
		}
		else {
			ascii = br.read(); 
			if(ascii == 13) {
				nroLinea++;
			}
		}
		asciiAnt = ascii;
		int columna = diccionario.asciiToColumna(ascii);
		estadoSig = matriz_de_estados.getSiguienteEstado(estado,columna);
		AccionSemantica AS = matriz_AS.getAccionSemantica(estado, columna);
		t.setToken(AS.execute(buffer, (char)ascii));
		acomodarLinea = AS.acomodarLinea();
		estado = estadoSig;
		if(t.getToken() > 0)
		{
			//if (buffer.length() > 0)
			t.setLexema(buffer.toString());
			t.setLinea(nroLinea);
			hayToken = true;
			buffer.delete(0, buffer.length());	
		}
		else if (asciiAnt == -1) {	
			t.setToken(0); 
			return t;
		}									//TRATAMIENTO DE ERRORES LÉXICOS
		else if (t.getToken() == -4){			
			System.out.println("Error: caracter inválido "+ascii+ " en la linea " + nroLinea);
		}else if (t.getToken() == -3){
			System.out.println("Warning en la linea "+nroLinea+": identificador supera la longitud máxima");
		}else if (t.getToken() == -2){
			System.out.println("Error en la linea "+nroLinea+": palabra reservada no identificada");
		}else if (t.getToken() == -6) {
			System.out.println("Error en la linea "+nroLinea+": cte uint fuera de rango");
		}else if (t.getToken() == -5) {
			System.out.println("Error en la linea"+nroLinea+": cte double fuera de rango");
		}
	}
	while (!hayToken);
	//System.out.println(t);
	return t;		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void limpiarBuffer() {
		buffer.delete(0, buffer.length());
	}
	

}
