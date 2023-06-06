package persistencia;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.Barco;
import model.Patron;
import model.Salida;
import model.Socio;

public class GestorPersistencia {

	public EntityManagerFactory fabrica;
	GestorPersistencia gp;

	public GestorPersistencia() {
		this.fabrica = Persistence.createEntityManagerFactory("Persistencia");
	}

	public void cerrar() {
		this.fabrica.close();
	}

	/*----------------------------------------------Métodos Socio------------------------------------------------------------------------*/

	public Boolean crearSocio(Socio s) {
		EntityManager em = this.fabrica.createEntityManager();

		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();
		em.persist(s);
		try {
			transaccion.commit();
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}

		return true;
	}

	public Boolean actualizarSocio(String dni, Socio s) {
		EntityManager em = this.fabrica.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();

		try {
			Socio socioExistente = em.find(Socio.class, dni);
			if (socioExistente != null) {
				socioExistente.setNombre(s.getNombre());
				socioExistente.setApellidos(s.getApellidos());
				socioExistente.setTelefono(s.getTelefono());
				socioExistente.setDireccion(s.getDireccion());
				socioExistente.setBarcos(s.getBarcos());

				em.persist(socioExistente);
				transaccion.commit();
			} else {
				return false;
			}
		} finally {
			em.close();
		}

		return true;
	}

	public Boolean eliminarSocio(String dni) {
		EntityManager em = this.fabrica.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();

		try {
			Socio socioExistente = em.find(Socio.class, dni);
			if (socioExistente != null) {
				em.remove(socioExistente);
				transaccion.commit();
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}

		return true;
	}

	public Socio getPorDni(String dni) {
		EntityManager em = this.fabrica.createEntityManager();

		String consulta = "SELECT s FROM Socio s where s.dni=:dni";

		Socio socio = em.createQuery(consulta, Socio.class).setParameter("dni", dni).getSingleResult();

		em.close();

		return socio;
	}

	public List<Socio> getSociosCriteria() {
		EntityManager em = this.fabrica.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Socio> configConsulta = cb.createQuery(Socio.class);
		Root<Socio> raizSocio = configConsulta.from(Socio.class);

		configConsulta.select(raizSocio);

		List<Socio> socios = em.createQuery(configConsulta).getResultList();

		em.close();

		return socios;
	}

	/*----------------------------------------------Métodos Barco------------------------------------------------------------------------*/

	public Boolean crearBarco(Barco b) {
		EntityManager em = this.fabrica.createEntityManager();

		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();
		em.persist(b);
		try {
			transaccion.commit();
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}

		return true;
	}

	public Boolean actualizarBarco(String matricula, Barco b) {
		EntityManager em = this.fabrica.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();

		try {
			Barco barcoExistente = em.find(Barco.class, matricula);
			if (barcoExistente != null) {
				barcoExistente.setNombre(b.getNombre());
				barcoExistente.setCapacidad(b.getCapacidad());
				barcoExistente.setCuota(b.getCuota());
				barcoExistente.setNumAmarre(b.getNumAmarre());
				barcoExistente.setSalidas(b.getSalidas());
				barcoExistente.setSocio(b.getSocio());

				em.persist(barcoExistente);
				transaccion.commit();
			} else {
				return false;
			}
		} finally {
			em.close();
		}

		return true;
	}

	public Boolean eliminarBarco(String matricula) {
		EntityManager em = this.fabrica.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();

		try {
			Barco barcoExistente = em.find(Barco.class, matricula);
			if (barcoExistente != null) {
				em.remove(barcoExistente);
				transaccion.commit();
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}

		return true;
	}

	public List<Barco> getBarcos() {
		EntityManager em = this.fabrica.createEntityManager();

		String consulta = "SELECT b FROM Barco b";

		List<Barco> barcos = em.createQuery(consulta).getResultList();

		return barcos;
	}

	public Barco getPorMatricula(String matricula) {
		EntityManager em = this.fabrica.createEntityManager();

		String consulta = "SELECT b FROM Barco b where matricula=:matricula";

		Barco barco = em.createQuery(consulta, Barco.class).setParameter("matricula", matricula).getSingleResult();

		return barco;
	}

	/*----------------------------------------------Métodos Patron------------------------------------------------------------------------*/

	public Boolean crearPatron(Patron p) {
		EntityManager em = this.fabrica.createEntityManager();

		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();
		em.persist(p);
		try {
			transaccion.commit();
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}

		return true;
	}

	public Boolean actualizarPatron(String id, Patron p) {
		EntityManager em = this.fabrica.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();

		try {
			Patron patronExistente = em.find(Patron.class, id);
			if (patronExistente != null) {
				patronExistente.setNombre(p.getNombre());
				patronExistente.setApellidos(p.getApellidos());
				patronExistente.setCorreo(p.getCorreo());

				em.persist(patronExistente);
				transaccion.commit();
			} else {
				return false;
			}
		} finally {
			em.close();
		}

		return true;
	}

	public Boolean eliminarPatronPorId(String id) {
		EntityManager em = this.fabrica.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();

		try {
			Patron patronExistente = em.find(Patron.class, id);
			if (patronExistente != null) {
				em.remove(patronExistente);
				transaccion.commit();
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}

		return true;
	}

	public List<Patron> getPatrones() {
		EntityManager em = this.fabrica.createEntityManager();

		String consulta = "SELECT p FROM Patron p";

		List<Patron> patrones = em.createQuery(consulta).getResultList();

		em.close();

		return patrones;
	}

	public Patron getPatronPorId(String id) {
		EntityManager em = this.fabrica.createEntityManager();

		String consulta = "SELECT p FROM Patron p where id=:id";

		Patron patron = em.createQuery(consulta, Patron.class).setParameter("id", id).getSingleResult();

		em.close();

		return patron;
	}

	/*----------------------------------------------Métodos Salida------------------------------------------------------------------------*/

	public Boolean crearSalida(Salida s) {
		EntityManager em = this.fabrica.createEntityManager();

		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();
		em.persist(s);
		try {
			transaccion.commit();
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}

		return true;
	}

	public Boolean eliminarSalidaPorId(String id) {
		EntityManager em = this.fabrica.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();

		try {
			Salida salidaExistente = em.find(Salida.class, id);
			if (salidaExistente != null) {
				em.remove(salidaExistente);
				transaccion.commit();
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}

		return true;
	}

	public List<Salida> getSalidas() {
		EntityManager em = this.fabrica.createEntityManager();

		String consulta = "SELECT s FROM Salida s";

		List<Salida> salidas = em.createQuery(consulta).getResultList();

		em.close();

		return salidas;
	}

	public Salida getSalidaPorId(String id) {
		EntityManager em = this.fabrica.createEntityManager();

		String consulta = "SELECT s FROM Salida s where id=:id";

		Salida salida = em.createQuery(consulta, Salida.class).setParameter("id", id).getSingleResult();

		em.close();

		return salida;
	}

}
