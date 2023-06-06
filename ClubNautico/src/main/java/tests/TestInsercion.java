package tests;

import java.util.GregorianCalendar;

import model.Barco;
import model.Patron;
import model.Salida;
import model.Socio;
import persistencia.GestorPersistencia;

public class TestInsercion {

	public static void main(String[] args) {
		GestorPersistencia gp = new GestorPersistencia();

		Socio socio1 = new Socio("12345678", "AA", "BB", "QQWW", "1234");
		Barco barco1 = new Barco("BR11", "AA", 12, 40.0, 100, socio1);
		Patron patron1 = new Patron("P1", "AA", "SS", "aass");
		Salida salida1 = new Salida("S1", new GregorianCalendar(2020, 10, 12).getTime(), 10, "qqwwee", patron1);

		agregarBarcos(socio1, barco1);
		agregarSalidas(barco1, salida1);
		agregarSocio(barco1, socio1);
		agregarSalida(salida1);

		if (gp.crearSocio(socio1)) {
			System.out.println("Se ha insertado");
		} else {
			System.out.println("No se ha podido insertar");
		}
	}

	private static void agregarBarcos(Socio s, Barco b) {
		s.getBarcos().add(b);
		b.setSocio(s);
	}

	private static void agregarSalidas(Barco b, Salida s) {
		b.getSalidas().add(s);
	}

	private static void agregarSocio(Barco b, Socio s) {
		b.setSocio(s);
		s.getBarcos().add(b);
	}

	private static void agregarSalida(Salida s) {
		
	}
}