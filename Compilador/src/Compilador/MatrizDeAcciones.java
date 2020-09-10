package Compilador;

import AccionesSemanticas.AccionSemantica;

public class MatrizDeAcciones {
	
	static AccionSemantica[][] accionesSemanticas;
	
	public AccionSemantica get(Integer i, Integer j) {
        return accionesSemanticas[j][i];
    }

}
