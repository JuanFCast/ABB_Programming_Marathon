package model;

public class Programador {

	private String nombre;
	private String telefono;
	private String direccion;
	private String eMail;

	private Programador izq;
	private Programador der;

	public Programador(String nombre, String telefono, String direccion, String eMail) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.eMail = eMail;
	}

	public int compareTo(Programador p) {
		return nombre.compareTo(p.darNombre());
	}

	public String darNombre() {
		return nombre;
	}

	public String darTelefono() {
		return telefono;
	}

	public String darDireccion() {
		return direccion;
	}

	public String darEmail() {
		return eMail;
	}

	public boolean esHoja() {

		if(izq == null && der == null) {
			return true;
		}else {
			return false;
		}

	}

	
	//No lo utilizo
	public Programador darMenor() {
		return null;
	}
	
	//No lo utilizo
	public Programador darMayor() {
		return null;
	}
	
	
	
	public int darAltura() {
		if(esHoja()) {
			return 1;
		}else {
			if(izq !=null && der !=null) {
				int left = izq.darAltura();
				int right = der.darAltura();
				return 1 + Math.max(left, right);
			}else if(der != null) {
				return 1+der.darAltura();
			}else {
				return 1+izq.darAltura();
			}
		}
	}

	//No lo utilizo
	public int darPeso() {
		return 0;
	}
	
	//No lo utilizo
	public void insertar(Programador p) {

	}
	
	//No lo utilizo
	public Programador buscar(String name) {
		return null;
	}
	
	//No lo utilizo
	public Programador eliminar(String name) {
		return null;
	}
	

	public Programador getIzq() {
		return izq;
	}

	public void setIzq(Programador izq) {
		this.izq = izq;
	}

	public Programador getDer() {
		return der;
	}

	public void setDer(Programador der) {
		this.der = der;
	}

	public String toString() {
		return "Nombre: "+nombre+"\n";
	}
	
	//Le puse un retorno Sting porque si lo ponía como void me veía obligado a imprimir desde una clase del model, lo cual es una mala practica 
	public String inorden(Programador p) {
		String list = "";
		if( p != null) {
			if(p.getIzq() != null) {
				list += inorden(p.getIzq());
			}
			list += p.toString();
			if(p.getDer() != null) {
				list += inorden(p.getDer());
			}
		}
		return list;
	}

}
