package AccionesSemanticas;

public class as_Error extends AccionSemantica {

	@Override
	public int execute(StringBuffer buffer, char c) {
		// TODO Auto-generated method stub
		return -4; //Caracter invalido
	}

	@Override
	public boolean acomodarLinea() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
