package Modelo;

public class Rol {

	private int id_rol;
	private String nombre;
	private String descripcion;

	public Rol(int id_rol, String nombre, String descripcion) {
		this.id_rol = id_rol;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Rol(int id_rol, String nombre) {
		this.id_rol = id_rol;
		this.nombre = nombre;
	}
	
	
	public Rol() {
		
	}
	
	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
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
	
	public String toString() {
		
		return this.getId_rol() + "," + this.getNombre() + "," + this.getDescripcion();
		
	}

}

