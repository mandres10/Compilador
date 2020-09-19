package Compilador;

public class Simbolo {
	
	public String valor; //lexema
	public String tipo=""; // uint,double.
	public String uso="";
	public int cant_ref; 
	
	public Simbolo(String valor) {
		this.valor=valor;
	}
	
	public Simbolo(String valor, String tipo) {
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}
	
	public int get_Ref() {
		return this.cant_ref;
	}

	public void increase_Ref() {
		this.cant_ref++;
	}

	public void decrease_Ref() {
		this.cant_ref--;
	}

}
