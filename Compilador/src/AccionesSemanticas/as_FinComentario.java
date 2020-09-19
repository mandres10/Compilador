package AccionesSemanticas;


import Compilador.AnalizadorLexico;

public class as_FinComentario extends AccionSemantica {

	@Override
	public int execute(StringBuffer buffer, char c) {
		buffer = new StringBuffer();
		AnalizadorLexico.limpiarBuffer();
		return 0;
	}

	@Override
	public boolean acomodarLinea() {
		// TODO Auto-generated method stub
		return false;
	}

}
