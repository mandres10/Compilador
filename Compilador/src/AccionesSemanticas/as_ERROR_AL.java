package AccionesSemanticas;

public class as_ERROR_AL extends AccionSemantica {

	@Override
	public int execute(StringBuffer buffer, char c) {
		// TODO Auto-generated method stub
		buffer = new StringBuffer();
		return -4; //caracter invalido
	}

	@Override
	public boolean acomodarLinea() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
