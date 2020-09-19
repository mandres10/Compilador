package Compilador;

import java.util.HashMap;
import java.util.Hashtable;

import AccionesSemanticas.AccionSemantica;
import AccionesSemanticas.as_AgregarAlBuffer;
import AccionesSemanticas.as_FinPalRes;
import AccionesSemanticas.as_FinSimbolo;
import AccionesSemanticas.as_NoAction;
import AccionesSemanticas.as_FinDouble;
import AccionesSemanticas.as_FinUint;
import AccionesSemanticas.as_Error;
import AccionesSemanticas.as_ERROR_AL;
import AccionesSemanticas.as_FinID;
import AccionesSemanticas.as_FinSimboloCompuesto;
import AccionesSemanticas.as_FinCadena;
import AccionesSemanticas.as_FinComentario;


public class MatrizDeAcciones {
	
	static HashMap<String,Integer> TablaToken; 
	static Hashtable<String,Simbolo> TablaSimbolos;
	
	static AccionSemantica as_AgregarAlBuffer = new as_AgregarAlBuffer(); 
	static AccionSemantica as_NoAction = new as_NoAction(); 
	static AccionSemantica as_FinSimbolo = new as_FinSimbolo(); 
	static AccionSemantica as_FinPalRes = new as_FinPalRes(TablaToken);
	static AccionSemantica as_ERROR_AL = new as_ERROR_AL();
	static AccionSemantica as_Error = new as_Error();
	static AccionSemantica as_FinID = new as_FinID(TablaSimbolos, TablaToken);
	static AccionSemantica as_FinDouble =  new as_FinDouble(TablaSimbolos, TablaToken);
	static AccionSemantica as_FinUint = new as_FinUint(TablaSimbolos, TablaToken);
	static AccionSemantica as_FinCadena = new as_FinCadena(TablaSimbolos, TablaToken);
	static AccionSemantica as_FinSimboloCompuesto = new as_FinSimboloCompuesto(TablaToken);
	static AccionSemantica as_FinComentario = new as_FinComentario();
	
	static AccionSemantica[][] matriz_AS = {{as_AgregarAlBuffer,	as_AgregarAlBuffer, as_AgregarAlBuffer,	as_Error,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_FinSimbolo,	as_FinSimbolo,	as_NoAction,	as_NoAction,	as_NoAction,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_NoAction,	as_AgregarAlBuffer,	as_FinSimbolo},
											{as_AgregarAlBuffer,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_FinPalRes,	as_Error,	as_FinPalRes},
											{as_FinID,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_FinID,	as_AgregarAlBuffer,	as_FinID,	as_FinID,	as_FinID,	as_FinID,	as_FinID,	as_FinID,	as_FinID,	as_FinID,	as_FinID,	as_FinID,	as_Error,	as_FinID},
											{as_Error,	as_Error,	as_AgregarAlBuffer,	as_NoAction,	as_Error,	as_Error,	as_AgregarAlBuffer,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error},
											{as_Error,	as_Error,	as_Error,	as_Error,	as_NoAction,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error},
											{as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_FinUint,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error},
											{as_FinDouble,	as_FinDouble,	as_AgregarAlBuffer,	as_FinDouble, as_FinDouble,	as_FinDouble,	as_FinDouble,	as_AgregarAlBuffer,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_Error,	as_FinDouble},
											{as_Error,	as_Error, as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error},
											{as_FinDouble,	as_FinDouble,	as_AgregarAlBuffer,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_FinDouble,	as_Error,	as_FinDouble},
											{as_Error,	as_Error,	as_AgregarAlBuffer,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error},
											{as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_NoAction,	as_AgregarAlBuffer,	as_FinCadena,	as_NoAction,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_NoAction,	as_Error,	as_AgregarAlBuffer},
											{as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_NoAction,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error},
											{as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_Error,	as_AgregarAlBuffer,	as_FinCadena,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_Error,	as_AgregarAlBuffer},
											{as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_NoAction,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error},
											{as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_FinComentario,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_AgregarAlBuffer,	as_Error,	as_AgregarAlBuffer},
											{as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimboloCompuesto,	as_FinSimbolo,	as_Error,	as_FinSimbolo},
											{as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimboloCompuesto,	as_FinSimbolo,	as_Error,	as_FinSimbolo},
											{as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_FinSimboloCompuesto,	as_Error,	as_Error,	as_Error},
											{as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,as_FinSimbolo,	as_FinSimbolo,	as_FinSimbolo,	as_FinSimboloCompuesto,	as_FinSimbolo,	as_Error,	as_FinSimbolo},
											{as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_Error,	as_FinSimboloCompuesto,	as_Error},	
			
											};
	
	public AccionSemantica getAccionSemantica(Integer i, Integer j) {
        return matriz_AS[j][i];
    }

}
