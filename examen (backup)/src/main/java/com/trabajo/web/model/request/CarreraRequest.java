package com.trabajo.web.model.request;

import java.io.Serializable;

public class CarreraRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String descripcion;
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
