package Compilador;


public class Comando  {

	char tipo;
	Object ref1;
	Object ref2;
	Object ref3;


	public Comando(char tipo) {
		this.tipo = tipo;
		this.ref1 = null;
		this.ref2 = null;
		this.ref3 = null;
	}



	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public Object getRef1() {
		return ref1;
	}

	public void setRef1(Object ref1) {
		this.ref1 = ref1;
	}

	public Object getRef2() {
		return ref2;
	}

	public void setRef2(Object ref2) {
		this.ref2 = ref2;
	}

	public Object getRef3() {
		return ref3;
	}

	public void setRef3(Object ref3) {
		this.ref3 = ref3;
	}

	public String toString(){
		String msg;
		msg = "Tipo: " + this.getTipo();
		if(this.getRef1() != null)
			msg += " Ref1: " + this.getRef1();
		if(this.getRef2() != null)
			msg += " Ref2: " + this.getRef2();
		if(this.getRef3() != null)
			msg += " Ref3: " + this.getRef3();
		msg += "\n";
		return msg;

	}




}
