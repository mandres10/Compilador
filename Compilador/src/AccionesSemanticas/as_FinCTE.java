package AccionesSemanticas;

import java.util.HashMap;
import java.util.Hashtable;

import Compilador.Simbolo;

public class as_FinCTE extends AccionSemantica {
	
	Hashtable<String,Simbolo> TablaSimbolo;
	HashMap<String,Integer> TablaToken;  
	Simbolo s;
	
	long maxValorUint = 65535;
	
	//ver como usar los valores DOUBLE
	
	
	public as_FinCTE(Hashtable<String,Simbolo> TablaSimbolo, HashMap<String,Integer> TablaToken){
		this.TablaToken = TablaToken;
		this.TablaSimbolo = TablaSimbolo;			
	}

	@Override
	public int execute(StringBuffer buffer, char c) {
		this.s = new Simbolo(buffer.toString());
		s.setUso("CTE");
		long Const = Long.parseLong(buffer.toString());
		if((Const>=0) && (Const<=maxValorUint)) { // si esta en el ragon de uint
			s.setTipo("uint");
			if (TablaSimbolo.contains(this.s)) {
				TablaSimbolo.get(s.getValor());
				return TablaToken.get("CTE");
			}else{                                			//si no esta en la tabla
				TablaSimbolo.put(s.getValor(),s);
				return TablaToken.get("CTE");
			}
			
		}
		return -4; //-4 warning de error
			
	}

	@Override
	public boolean acomodarLinea() {
		// TODO Auto-generated method stub
		return false;
	}

}
