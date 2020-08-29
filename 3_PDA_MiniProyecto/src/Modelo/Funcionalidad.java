package Modelo;

public class Funcionalidad {
	
	private int id_funcion;
	private String nombre;
	private String descripcion;

	public Funcionalidad(int id_funcion, String nombre, String descripcion) {
		this.id_funcion = id_funcion;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId_funcion() {
		return id_funcion;
	}

	public void setId_funcion(int id_funcion) {
		this.id_funcion = id_funcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
