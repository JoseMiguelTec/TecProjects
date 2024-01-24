package es.tecdata.models;

import java.io.Serializable;

public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8308858867832202895L;

	private Long id;

	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
