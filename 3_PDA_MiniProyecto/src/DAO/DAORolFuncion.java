package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.DatabaseManager;
import Modelo.*;


public class DAORolFuncion {
	private final String INSERT_ROL_FUNCION  = "INSERT INTO ROL_FUNCION (ID_ROL_FUNCION, ID_ROL, ID_FUNCION) VALUES (SEQ_ID_ROL_FUNCION.nextval,?,?)";
	private final String FIND_ROL = "SELECT rf.ID_ROL_FUNCION, rf.ID_ROL, rf.ID_FUNCION, r.NOMBRE rolnombre, r.DESCRIPCION roldesc, "
			+ "f.NOMBRE funcionnombre, f.DESCRIPCION funciondesc FROM ROL_FUNCION rf INNER JOIN ROL r ON rf.ID_ROL = r.ID_ROL "
			+ "INNER JOIN FUNCIONALIDAD f ON f.ID_FUNCIONALIDAD = rf.ID_FUNCION WHERE rf.ID_ROL = ? AND rf.ID_FUNCION = ?";
	
	// Constructor privado para poder hacer uso del singleton
	private DAORolFuncion() {
		
	}
	
	// Singleton
	private static DAORolFuncion instancia = null;
	public static DAORolFuncion getInstancia() {
		if(instancia == null) {
			return new DAORolFuncion();
		}
		return instancia;
	}
	
	
	/**
	 * Inserta un rol de funcion a la base de datos
	 * @param r
	 * @return boolean
	 */
	public boolean asignar(Rol_Funcion rf) {
		
		int row  = 0;
		
		try {
			PreparedStatement sentencia = DatabaseManager.getConnection().prepareStatement(INSERT_ROL_FUNCION);
			sentencia.setInt(1, rf.getId_rol());
			sentencia.setInt(2, rf.getId_funcion());
			
			row =  sentencia.executeUpdate();

			return row > 0;
		} catch (Exception e) {
			System.err.println("[CONSULTA] Error al ejecutar la consulta: " + INSERT_ROL_FUNCION);
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Obtiene un funcion_rol por rol id
	 * @param rolId
	 * @return RolFuncion
	 */
	public Rol_Funcion obtenerPorRolYFuncion(int idRol, int idFuncion) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(FIND_ROL);
			statement.setInt(1, idRol);
			statement.setInt(2, idFuncion);
			ResultSet rs = statement.executeQuery();
				
			if(rs.next()) {
				Rol r = new Rol(rs.getInt("ID_ROL"), rs.getString("ROLNOMBRE"), rs.getString("ROLDESC"));
				Funcionalidad f = new Funcionalidad(rs.getInt("ID_FUNCION"), rs.getString("FUNCIONNOMBRE"), rs.getString("FUNCIONDESC"));
				return new Rol_Funcion(rs.getInt("ID_ROL_FUNCION"), r.getId_rol(), f.getId_funcion());
			}
			
		} catch (SQLException e) {
			System.err.println("Error al buscar rol funcionalidad: " + FIND_ROL + " [ERROR] --> "  + e.getMessage());
		}
		return null;
	}
	
}


