package tests;

import model.Socio;
import persistencia.GestorPersistencia;

public class TestSocio {
	static GestorPersistencia gp = new GestorPersistencia();

	public static void main(String[] args) {
		gp.crearSocio(new Socio("98765452", "qwww", "wwwq", "trtrt", "5678"));
		gp.actualizarSocio("12345678", new Socio("23412454", "ppp", "ooo", "gjgjg", "8484"));
		gp.eliminarSocio("dni2");
		System.out.println(gp.getPorDni("98765432"));
		System.out.println(gp.getSociosCriteria());

	}
}
