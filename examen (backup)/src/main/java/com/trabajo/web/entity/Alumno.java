package com.trabajo.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="alumnos")
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="alumno_id")
	private Integer id;
	
	@Column(name="nombre")
	@NotEmpty
	@Size(min=2, max=45)
	private String nombre;
	
	@Column(name="apellido")
	@NotEmpty
	@Size(min=2, max=45)
	private String apellido;
	
	@Column(name="nro_documento")
	@NotEmpty
	@Size(min=2, max=45)
	private String cedula;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="carrera_id", referencedColumnName = "carrera_id")
	private Carrera carreraId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Carrera getCarreraId() {
		return carreraId;
	}

	public void setCarreraId(Carrera carreraId) {
		this.carreraId = carreraId;
	}
	
	
	
}
