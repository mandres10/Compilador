package AccionesSemanticas;

public class as_AgregarAlBuffer extends AccionSemantica {

	@Override
	public int execute(StringBuffer buffer, char c) {
		buffer.append(c);
		return 0;
	}

	@Override
	public boolean acomodarLinea() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
