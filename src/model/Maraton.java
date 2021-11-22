package model;

import exceptions.ProgramadorRepetidoException;

public class Maraton {

	private int numProgramadores;
	private Programador programadorRaiz;

	public Maraton() {
		numProgramadores = 0;
	}

	public void agregarProgramador(String n, String t, String d, String em) throws ProgramadorRepetidoException {

		Programador p = new Programador(n, t, d, em);

		if(programadorRaiz == null) {
			programadorRaiz = p;
		}else {
			agregarProgramador(p, programadorRaiz);
		}

	}

	private void agregarProgramador(Programador n, Programador r) throws ProgramadorRepetidoException {

		boolean added = false;

		while(!added) {
			if(n.compareTo(r) == 0) {
				throw new ProgramadorRepetidoException();
			}else if(n.compareTo(r)<0) {
				if(r.getIzq() == null) {
					r.setIzq(n);
					numProgramadores++;
					added = true;
				}else {
					r = r.getIzq();
				}
			}else {
				if(r.getDer() == null) {
					r.setDer(n);
					numProgramadores++;
					added = true;
				}else {
					r = r.getDer();
				}
			}
		}

	}
	//No lo utilizo
	public void eliminarProgramador(String name) {

	}

	//No lo utilizo
	public Programador buscarProgramador(String name) {
		return null;
	}

	public String[] darListaProgramadores() {
		String list[] = new String[2];
		if(programadorRaiz != null) {
			list [0] = programadorRaiz.inorden(programadorRaiz);
			list [1] = String.valueOf(programadorRaiz.darAltura());
		}else {
			list [0] = "No hay programadores registrados\n";
			list [1] = "0\n";
		}
		return list;
	}

	public int getNumProgramadores() {
		return numProgramadores;
	}



}