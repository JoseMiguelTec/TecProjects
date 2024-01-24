package es.tecdata.models;

public class Producto {

	private Long ID;

	private String descripcion;

	private double precio;

	public Producto() {
	}

	public Producto(Long iD, String descripcion, double precio) {
		super();
		ID = iD;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [ID=" + ID + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}

}
