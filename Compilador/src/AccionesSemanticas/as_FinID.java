package AccionesSemanticas;

import java.util.HashMap;
import java.util.Hashtable;

import Compilador.Simbolo;

public class as_FinID extends AccionSemantica {
	
	Hashtable<String,Simbolo> TablaSimbolo;
	HashMap<String,Integer> TablaToken; 
	Simbolo s;
	
	public as_FinID(Hashtable<String,Simbolo> TablaSimbolo, HashMap<String,Integer> TablaToken){
		this.TablaToken = TablaToken;
		this.TablaSimbolo = TablaSimbolo;			
	}

	@Override
	public int execute(StringBuffer buffer, char c) {
		if (buffer.length()<20) {
			s = new Simbolo(buffer.toString());			
			if(TablaSimbolo.contains(s))
				{
					return TablaToken.get("ID");
				}
				else
				{
					TablaSimbolo.put(s.getValor(),s);
					return TablaToken.get("ID");
				}
		}else {
			s = new Simbolo(buffer.substring(0,19));
			buffer.setLength(20);
			TablaSimbolo.put(s.getValor(),s);
			return -3; 														// ID FUERA DE RANGO
		}
	}

	@Override
	public boolean acomodarLinea() {
		// TODO Auto-generated method stub
		return true;
	}

}
