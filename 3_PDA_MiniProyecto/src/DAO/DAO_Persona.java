package DAO;

import javax.swing.JOptionPane;

import Conexion.DatabaseManager;
import Modelo.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.LinkedList;

public class DAO_Persona {
	
	public static final String ALL_PERSONAS = "SELECT * FROM PERSONA";
	public static final String CUENTA_PERSONAS = "SELECT COUNT (ID_PERSONA) AS CUENTA FROM PERSONA";
	public static final String INSERT_PERSONA = "INSERT INTO PERSONA (DOCUMENTO,APELLIDO1,APELLIDO2,NOMBRE1,NOMBRE2,FECHA_NAC,CLAVE,ID_ROL,MAIL)"
			+ " values (?,?,?,?,?,?,?,?,?)";
	private static final String DELETE_PERSONA = "DELETE FROM PERSONA WHERE ID_PERSONA=?";
	private static final String BUSCAR_PERSONA = "SELECT * FROM PERSONA WHERE APELLIDO1=? AND NOMBRE1=?";
	private static final String UPDATE_PERSONA = "UPDATE PERSONA SET DOCUMENTO=?, APELLIDO1=?, APELLIDO2=?, NOMBRE1=?, NOMBRE2=? WHERE ID_PERSONA=?";
	
	static Connection connection = DatabaseManager.getConnection();

	
	public static int cuentaPersonas() {

		int Cuenta = 0;
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CUENTA_PERSONAS);
			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {

				Cuenta = resultado.getInt("CUENTA");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return Cuenta;
	}//fin cuentaPersonas()
	
	
	public static boolean insertar_Persona(Persona persona){
		
		if (persona != null) {
			
			try {
				
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_PERSONA);
			
				statement.setString(1, persona.getDocumento());
				statement.setString(2, persona.getApellido1());
				statement.setString(3, persona.getApellido2());
				statement.setString(4, persona.getNombre1());
				statement.setString(5, persona.getNombre2());
				statement.setDate(6, (java.sql.Date) persona.getFecNac());
				statement.setString(7, persona.getClave());
				statement.setInt(8, persona.getId_rol());
				statement.setString(9, persona.getMail());
				
				int retorno = statement.executeUpdate();
	
				JOptionPane.showMessageDialog(null, "Ingreso exitoso","Ingreso exitoso", JOptionPane.INFORMATION_MESSAGE);
	
				return retorno>0;
							
			} catch (SQLException e) {
				
				JOptionPane.showMessageDialog(null, "Error al ingresar los datos.||" + e.getMessage(),"No se pudo ingresar los datos.", JOptionPane.ERROR_MESSAGE);
				
				return false;
				
			}
			
		} else {
			
			JOptionPane.showMessageDialog(null, "Error al ingresar los datos","No se pudo ingresar los datos.", JOptionPane.ERROR_MESSAGE);
			return false;
			
		}//fin if
		
	}//fin insertarPersona()
	
	public static LinkedList<Persona> findAll() {

	LinkedList<Persona> personas = new LinkedList<>();
		
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_PERSONAS);
			
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()) {
				
				String documento = resultado.getString("DOCUMENTO");
				
				String apellido1 = resultado.getString("APELLIDO1");
				
				String apellido2 = resultado.getString("APELLIDO2");
				
				String nombre1 = resultado.getString("NOMBRE1");
				
				String nombre2 = resultado.getString("NOMBRE2");
				
				Date fecNac = resultado.getDate("FECHA_NAC");
				
				int id_rol = resultado.getInt("ID_ROL");
				
				String mail = resultado.getString("MAIL");
				
				Persona p = new Persona(documento, apellido1, apellido2, nombre1, nombre2, fecNac, id_rol, mail);
				
				personas.add(p);
				
			}
			
			return personas;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return null;
			
		}
		
	} // listar personas
	
	public static boolean delete(int idPersona) {
		
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_PERSONA);
			
			statement.setInt(1, idPersona);
			
			int retorno = statement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Se ha eliminado a la persona de la BD.");	
			
			return retorno>0;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "No se ha eliminado a la persona de la BD.");
			
			return false;
			
		}	
		
	} // delete
	
	public static boolean edit(Persona p) {
		
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_PERSONA);
			
			statement.setString(1, p.getDocumento());

			statement.setString(2, p.getApellido1());
			
			statement.setString(3, p.getApellido2());
			
			statement.setString(4, p.getNombre1());
			
			statement.setString(5, p.getNombre2());
			
			//statement.setInt(6, p.getId_persona());
			
			int retorno = statement.executeUpdate();
			
			return retorno > 0;
					
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	} // edit

	public static Persona findPersona(String documento, String mail) {
		
		Persona unaPer = null;
		
		//Cargo el resulset con los registros de la tabla Persona
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_PERSONA);
			
			statement.setString(1, documento);
			statement.setString(2, mail);
			
			ResultSet resultado = statement.executeQuery();
			
			//Recorro el resulset cargando cada registro a la lista de retorno
			while(resultado.next()) {
				
					unaPer = new Persona();
					unaPer.setId_persona(resultado.getInt("ID_PERSONA"));
					unaPer.setDocumento(resultado.getString("DOCUMENTO"));
					unaPer.setApellido1(resultado.getString("APELLIDO1"));
					unaPer.setApellido2(resultado.getString("APELLIDO2"));
					unaPer.setNombre1(resultado.getString("NOMBRE1"));
					unaPer.setNombre2(resultado.getString("NOMBRE2"));
					unaPer.setFecNac(resultado.getDate("FECHA_NAC"));
					unaPer.setId_rol(resultado.getInt("ID_ROL"));
					unaPer.setMail(resultado.getString("MAIL"));
					
			}//fin while
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Registro no encontrado. || " +  e.getMessage());
		}
		
		return unaPer;
		
	}//Fin de la funcion findPersona() 
	

}//fin clase