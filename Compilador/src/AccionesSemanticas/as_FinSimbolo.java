package AccionesSemanticas;

public class as_FinSimbolo extends AccionSemantica {

	@Override
	public int execute(StringBuffer buffer, char c) {
		buffer = new StringBuffer();
		return c;
	}

	@Override
	public boolean acomodarLinea() {
		// TODO Auto-generated method stub
		return false;
	}

}
