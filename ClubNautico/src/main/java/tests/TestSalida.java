package tests;

import java.util.GregorianCalendar;

import model.Patron;
import model.Salida;
import persistencia.GestorPersistencia;

public class TestSalida {
	static GestorPersistencia gp = new GestorPersistencia();

	public static void main(String[] args) {
		 gp.crearSalida(new Salida("S2", new GregorianCalendar(10, 1, 2023).getTime(), 10, "D2", new Patron("P3", "N3", "Ap3", "D3"))); 
		 gp.eliminarSalidaPorId("S2"); 
		 System.out.println(gp.getSalidaPorId("S1")); 
		 System.out.println(gp.getSalidas());
	}
}
