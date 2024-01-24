package es.tecdata.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Carrito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4506505765706358722L;

	@Id
	private String id;
	private String usuario;
	private List<Pedido> contenido = new ArrayList<>();
	private double importe;

	public Carrito(String usuario, List<Pedido> contenido, double importe) {
		super();
		this.usuario = usuario;
		this.contenido = contenido;
		this.importe = importe;
	}

	public Carrito() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Pedido> getContenido() {
		return contenido;
	}

	public void setContenido(List<Pedido> contenido) {
		this.contenido = contenido;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", usuario=" + usuario + ", contenido=" + contenido + ", importe=" + importe + "]";
	}

}
