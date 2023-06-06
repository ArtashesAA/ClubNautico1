package tests;


import model.Patron;
import persistencia.GestorPersistencia;

public class TestPatron {
	static GestorPersistencia gp = new GestorPersistencia();

	public static void main(String[] args) {
		gp.crearPatron(new Patron("P2", "patron2", "patron2", "correo2")); 
		gp.actualizarPatron("P2", new Patron("P2", "nom1", "ap2", "correo2"));
		gp.eliminarPatronPorId("P2"); 
		System.out.println(gp.getPatrones()); 
		System.out.println(gp.getPatronPorId("P1"));
		
	}
}
