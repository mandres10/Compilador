package AccionesSemanticas;

import java.util.HashMap;
import java.util.Hashtable;

import Compilador.Simbolo;

public class as_FinCadena extends AccionSemantica {
	
	Hashtable<String,Simbolo> TablaSimbolo;
	HashMap<String,Integer> TablaToken;  
	Simbolo s;
		
	public as_FinCadena(Hashtable<String,Simbolo> TablaSimbolo, HashMap<String,Integer> TablaToken){
		this.TablaToken = TablaToken;
		this.TablaSimbolo = TablaSimbolo;			
	}
	
	
	@Override
	public int execute(StringBuffer buffer, char c) {
		this.s = new Simbolo(buffer.toString());
		s.setTipo("Cadena");
		if(TablaSimbolo.contains(this.s) ){  			//SI ESTA EN LA TABLA
			return TablaToken.get("CADENA");
		}
		else{                                			// SI NO ESTA EN LA TABLA
			TablaSimbolo.put(s.getValor(),s);
			return TablaToken.get("CADENA");
		}
	}
	
	@Override
	public boolean acomodarLinea(){
		return false;
	}

}
