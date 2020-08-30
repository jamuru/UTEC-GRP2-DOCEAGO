package Modelo;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;

public class Persona {

	private int id_persona;
	private String documento;
	private String apellido1;
	private String apellido2;
	private String nombre1;
	private String nombre2;
	private java.util.Date fecNac;
	private String clave;
	private Integer id_rol;
	private String mail;
	
	

	public Persona(int id_persona, String documento, String apellido1, String apellido2, String nombre1, String nombre2,
			java.util.Date fecNac, String clave, int id_rol, String mail) {
		this.id_persona = id_persona;
		this.documento = documento;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.fecNac = fecNac;
		this.clave = clave;
		this.id_rol = id_rol;
		this.mail = mail;
	}
	
	public Persona(String documento, String apellido1, String apellido2, String nombre1, String nombre2,
			java.util.Date fecNac, String clave, int id_rol, String mail) {
		this.documento = documento;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.fecNac = fecNac;
		this.clave = clave;
		this.id_rol = id_rol;
		this.mail = mail;
	}
	

	public Persona(String documento, String apellido1, String apellido2, String nombre1, String nombre2, java.util.Date fecNac,
			Integer id_rol, String mail) {
		this.documento = documento;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.fecNac = fecNac;
		this.id_rol = id_rol;
		this.mail = mail;
	}

	public Persona(int id_persona, String documento, String apellido1, String apellido2, String nombre1, String nombre2,
			java.util.Date fecNac, Integer id_rol, String mail) {
		super();
		this.id_persona = id_persona;
		this.documento = documento;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.fecNac = fecNac;
		this.id_rol = id_rol;
		this.mail = mail;
	}

	public Persona() {
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public java.util.Date getFecNac() {
		return fecNac;
	}

	public void setFecNac(java.util.Date fechaSQL) {
		this.fecNac = fechaSQL;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
	@Override
	public String toString() {
		return "Persona [documento=" + documento + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", nombre1=" + nombre1 + ", nombre2=" + nombre2 + ", fechaNac=" + fecNac +  ", mail=" + mail + "]";
	}
	
}
	

	

