package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Conexion.DatabaseManager;
import Modelo.Funcionalidad;

public class DAO_Funcionalidad {

	public static final String ALL_FUNCIONALIDADES = "SELECT * FROM FUNCIONALIDAD";
	public static final String INSERT_FUNCIONALIDAD = "INSERT INTO FUNCIONALIDAD (ID_FUNCION, NOMBRE, DESCRIPCION) VALUES (SEQ_ID_FUNCION.NEXTVAL,?,?)";
	private static final String DELETE_FUNCIONALIDAD = "DELETE FROM PERSONA WHERE ID_FUNCION=?";
	private static final String BUSCAR_FUNCIONALIDAD = "SELECT * FROM PERSONA WHERE NOMBRE=?";
	private static final String UPDATE_FUNCIONALIDAD = "UPDATE FUNCIONALIDAD SET NOMBRE=?, DESCRPCION=? WHERE ID_FUNCION=?";
	
	static Connection connection = DatabaseManager.getConnection();
	
	
	public static boolean insertarFuncionalidad(Funcionalidad funcion){
		
		if (funcion != null) {
			
			try {
				
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_FUNCIONALIDAD);
			
				statement.setString(1, funcion.getNombre());
				statement.setString(2, funcion.getDescripcion());
				
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
		
	}//fin insertarFuncionalidad()
	
}
