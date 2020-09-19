package AccionesSemanticas;

import java.util.HashMap;
import java.util.Hashtable;

import Compilador.Simbolo;

public class as_FinDouble extends AccionSemantica {
	
	Hashtable<String,Simbolo> TablaSimbolo;
	HashMap<String,Integer> TablaToken;  
	Simbolo s;
	
	double rangoMinPos=2.2250738585072014d-308;
	double rangoMaxPos=1.7976931348623157d+308;
	double rangoMinNeg=-1.7976931348623157d+308;
	double rangoMaxNeg=-2.2250738585072014d-308;

	
	public as_FinDouble(Hashtable<String,Simbolo> TablaSimbolo, HashMap<String,Integer> TablaToken){
		this.TablaToken = TablaToken;
		this.TablaSimbolo = TablaSimbolo;			
	}
	
	@Override
	public int execute(StringBuffer buffer, char c) {
		this.s = new Simbolo(buffer.toString());
		double Const = Double.parseDouble(buffer.toString());
		
		if ((Const>=rangoMinPos) && (Const<=rangoMinPos)) {
			if(TablaSimbolo.contains(this.s) ){  			//SI ESTA EN LA TABLA
				return TablaToken.get("DOUBLE");
			}
			else{                                			// SI NO ESTA EN LA TABLA
				TablaSimbolo.put(s.getValor(),s);
				return TablaToken.get("DOUBLE");
			}
		}else {
			if ((((Const<rangoMinPos) && (Const> 0) ) || (Const>rangoMaxPos))) {
			return -5; //double fuera de rango
			}
		}
		if ((Const>=rangoMinNeg) && (Const<=rangoMaxNeg)) {
			if(TablaSimbolo.contains(this.s) ){  			//SI ESTA EN LA TABLA
				return TablaToken.get("DOUBLE");
			}
			else{                                			// SI NO ESTA EN LA TABLA
				TablaSimbolo.put(s.getValor(),s);
				return TablaToken.get("DOUBLE");
			}
		}else {
			if ((((Const>rangoMaxNeg) && (Const<0) ) || (Const<rangoMinNeg))) {
			return -5; //double fuera de rango
			}
		}
		if (Const==0.0) {
			if(TablaSimbolo.contains(this.s) )			//SI ESTA EN LA TABLA
				return TablaToken.get("DOUBLE");
			else{                                			// SI NO ESTA EN LA TABLA
				TablaSimbolo.put(s.getValor(),s);
				return TablaToken.get("DOUBLE");
			}
		}
		return -5; //double fuera de rango
	}

	@Override
	public boolean acomodarLinea() {
		// TODO Auto-generated method stub
		return false;
	}

}
