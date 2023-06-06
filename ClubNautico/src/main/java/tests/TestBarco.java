package tests;

import model.Barco;
import model.Socio;
import persistencia.GestorPersistencia;

public class TestBarco {
	static GestorPersistencia gp = new GestorPersistencia();

	public static void main(String[] args) {
		gp.crearBarco(new Barco("BR21", "barco21", 23, 20.0, 30, new Socio("dni4", "qwww", "wwwq", "trtrt", "5678")));
		gp.actualizarBarco("BR21", new Barco("BR23", "barco23", 23, 20.0, 30, new Socio("dni3", "twww", "ggg", "rrr", "3678")));
		gp.eliminarBarco("BR21");
		System.out.println(gp.getPorMatricula("BR21"));
		System.out.println(gp.getBarcos());
		
	}
}
