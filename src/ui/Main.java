package ui;

import exceptions.ProgramadorRepetidoException;
import model.Maraton;

public class Main {

	private static Maraton maraton;

	
	public static void main(String[] args) {

		maraton = new Maraton();

		try {
			maraton.agregarProgramador("Juan Felipe Castillo", "3014410575", "Carrera 47", "jf.cg@gmail.com");
			maraton.agregarProgramador("Isabella Tejada", "3178886550", "Carrera 9", "isa@gmail.com");
			maraton.agregarProgramador("Ana Sofia Paz", "3007879451", "Carrera 1", "anita@gmail.com");
			maraton.agregarProgramador("Juan Felipe Chaves", "8654447845", "Carrera 84", "jf.cb@gmail.com");
			String[] list = maraton.darListaProgramadores();
			System.out.println("Los programadores registrados son: \n"+list[0]+"\n"+"La altura del arborl es: "+list[1]);
			
		} catch (ProgramadorRepetidoException e) {
			System.out.println("No pueden haber programadores repetidos");
		}

	}

}
