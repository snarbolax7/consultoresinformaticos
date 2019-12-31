package com.trabajo.web.model.request;

import java.io.Serializable;

public class AlumnoRequest implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String apellido;
	private String cedula;
	private Integer carreraId;
	
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
	public Integer getCarreraId() {
		return carreraId;
	}
	public void setCarreraId(Integer carreraId) {
		this.carreraId = carreraId;
	}
}

