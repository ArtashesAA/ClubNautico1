package model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "barco")
public class Barco {

	@Id
	@Column(name = "matricula", nullable = false, columnDefinition = "VARCHAR(10)")
	@Pattern(regexp = "^[a-zA-Z0-9]{8,10}$")
	private String matricula;

	@Column(name = "nombre", nullable = false, columnDefinition = "VARCHAR(50)")
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String nombre;

	@Column(name = "numAmarre", columnDefinition = "INT CHECK (numAmarre > 0)")
	private Integer numAmarre;

	@Column(name = "cuota", columnDefinition = "DOUBLE CHECK (cuota > 0)")
	private Double cuota;

	@Column(name = "capacidad", nullable = false, columnDefinition = "INT CHECK (capacidad > 0)")
	private Integer capacidad;

	@ManyToOne(optional = false, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "socio_dni", referencedColumnName = "dni")
	private Socio socio;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "Barco_Salida", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "matricula") })
	private List<Salida> salidas;

	public Barco() {
		this.salidas = new ArrayList<>();
	}

	public Barco(String matricula, String nombre, Integer numAmarre, Double cuota, Integer capacidad, Socio socio) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.numAmarre = numAmarre;
		this.cuota = cuota;
		this.capacidad = capacidad;
		this.socio = socio;
		this.salidas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getNumAmarre() {
		return numAmarre;
	}

	public void setNumAmarre(Integer numAmarre) {
		this.numAmarre = numAmarre;
	}

	public Double getCuota() {
		return cuota;
	}

	public void setCuota(Double cuota) {
		this.cuota = cuota;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public List<Salida> getSalidas() {
		return salidas;
	}

	public void setSalidas(List<Salida> salidas) {
		this.salidas = salidas;
	}

	@Override
	public String toString() {
		return "Barco [getNombre()=" + getNombre() + ", getCapacidad()=" + getCapacidad() + ", getMatricula()="
				+ getMatricula() + ", getNumAmarre()=" + getNumAmarre() + ", getCuota()=" + getCuota()
				+ ", getSalidas()=" + getSalidas() + "]";
	}

}
