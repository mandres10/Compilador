package Compilador;

import java.util.Hashtable;

public class DiccionarioAscii {
	
static Hashtable<Integer, Integer> diccionario= new Hashtable<Integer, Integer>();
	
	
	public DiccionarioAscii() {
		diccionario.put(1, 0);		//L
		diccionario.put(2, 1);      //l
		diccionario.put(3, 2);		//D
		diccionario.put(95, 3);     // _
		diccionario.put(117,4);     //u
		diccionario.put(105,5);		//i
		diccionario.put(46, 6);     //.
		diccionario.put(100,7);     //d
		diccionario.put(45, 8);     //-
		diccionario.put(43, 9);     //+
		diccionario.put(34, 10);    //"
		diccionario.put(13, 11);    ///n
		diccionario.put(37, 12);    //%
		diccionario.put(60, 13);    //<
		diccionario.put(62, 14);    //>
		diccionario.put(33, 15);    //!
		diccionario.put(61, 16);    //=
		diccionario.put(9, 17);     //tab
		diccionario.put(32, 17);    //space
		diccionario.put(58, 18);    //:
		
	}
	
	
	public int asciiToColumna(int ascii){
		if(((ascii >= 65 && ascii <= 90))) {
			return diccionario.get(1);
		}
		if((ascii>= 97 && ascii <= 122)) {
			if (ascii==100) {
				return diccionario.get(100);
			}
			if (ascii==105) {
			return diccionario.get(105);
			}
			if (ascii==117) {
				return diccionario.get(117);
			}
			
		return diccionario.get(2);
		}
		if ((ascii >= 48 && ascii <= 57)) {
			return diccionario.get(3);
		}
		if (diccionario.containsKey(ascii)) {
			return diccionario.get(ascii);
		}
		
		return 19;	
	}
		
	
	public static boolean contiene(int clave) {
		return diccionario.containsKey(clave);
	}

}
