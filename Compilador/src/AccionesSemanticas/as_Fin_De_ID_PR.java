package AccionesSemanticas;

import java.util.HashMap;
import java.util.Hashtable;

import Compilador.Simbolo;

public class as_Fin_De_ID_PR extends AccionSemantica {
	
	Hashtable<String,Simbolo> TablaSimbolo;
	HashMap<String,Integer> TablaToken; 
	Simbolo s;
	
	public as_Fin_De_ID_PR(Hashtable<String,Simbolo> TablaSimbolo, HashMap<String,Integer> TablaToken){
		this.TablaToken = TablaToken;
		this.TablaSimbolo = TablaSimbolo;			
	}

	@Override
	public int execute(StringBuffer buffer, char c) {
		if (TablaToken.containsKey(buffer.toString())) {    //Si esta en la tabla de palabras reservadas devuelvo la devuelvo
			return TablaToken.get(buffer.toString());
		} else 
		{
			if (buffer.length()<20) {                      //Si no chequeo el rango y me fijo si esta en la tabla de simbolos y devuelvo ID + puntero a TS
				s = new Simbolo(buffer.toString());
				if (TablaSimbolo.contains(s)) {
					return TablaToken.get("ID");
				}
				else {
					TablaSimbolo.put(s.getValor(),s);      //Si no esta en la tabla de simbolos agrego y devuelvo ID + Puntero a TS
					return TablaToken.get("ID");
				}
			}
			else {
				s = new Simbolo(buffer.substring(0,20));  //Si esta fuera de ragon, lo trunco y doy warning
				buffer.setLength(20);
				TablaSimbolo.put(s.getValor(),s);
				return -3; 
			}
		}
	}
	
	public Simbolo getSimbolo() {
		return this.s;
	}

	@Override
	public boolean acomodarLinea() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	

}
