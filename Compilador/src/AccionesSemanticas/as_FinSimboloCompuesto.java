package AccionesSemanticas;

import java.util.HashMap;

public class as_FinSimboloCompuesto extends AccionSemantica {
	
    HashMap<String,Integer> TablaToken; 
	
	public as_FinSimboloCompuesto(HashMap<String,Integer> TablaToken){
		this.TablaToken = TablaToken;			
	}

	@Override
	public int execute(StringBuffer buffer, char c) {
		buffer.append(c);
		return TablaToken.get(buffer.toString());	
		
	}

	@Override
	public boolean acomodarLinea() {
		// TODO Auto-generated method stub
		return true;
	}

}
