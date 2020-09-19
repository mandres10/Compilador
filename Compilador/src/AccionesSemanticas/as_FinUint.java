package AccionesSemanticas;

import java.util.HashMap;
import java.util.Hashtable;

import Compilador.Simbolo;

public class as_FinUint extends AccionSemantica {
	
	Hashtable<String,Simbolo> TablaSimbolo;
	HashMap<String,Integer> TablaToken;  
	Simbolo s;
	
	int rangoMax=65535;
	int rangoMin=0;
	
	public as_FinUint(Hashtable<String,Simbolo> TablaSimbolo, HashMap<String,Integer> TablaToken){
		this.TablaToken = TablaToken;
		this.TablaSimbolo = TablaSimbolo;			
	}
	

	@Override
	public int execute(StringBuffer buffer, char c) {
		this.s = new Simbolo(buffer.toString());
		int Const = Integer.parseInt(buffer.toString());
		if((Const>=rangoMin) && (Const<=rangoMax)) {
			if(TablaSimbolo.contains(this.s) ){  			//SI ESTA EN LA TABLA
				return TablaToken.get("UINT");
			}
			else{                                			// SI NO ESTA EN LA TABLA
				TablaSimbolo.put(s.getValor(),s);
				return TablaToken.get("UINT");
			}
		}else 
		    return -6; //UINT fuera de rango
	}

	@Override
	public boolean acomodarLinea() {
		// TODO Auto-generated method stub
		return false;
	}

}
