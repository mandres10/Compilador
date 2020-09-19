package AccionesSemanticas;

import java.util.HashMap;

public class as_FinPalRes extends AccionSemantica {
	
	HashMap<String,Integer> TablaToken; 
		
	
	public as_FinPalRes(HashMap<String,Integer> TablaToken){
		this.TablaToken = TablaToken;			
	}
	
	public int execute (StringBuffer buffer, char c) {
		if (TablaToken.containsKey(buffer.toString())) {
			return TablaToken.get(buffer.toString());
		}else 
			return -2; //PalResMALESCRITA
	}
	public boolean acomodarLinea() {
		return true;
	}

}
