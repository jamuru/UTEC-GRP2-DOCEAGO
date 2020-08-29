package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Conexion.DatabaseManager;
import Modelo.Rol;

public class DAO_Rol {
	
	private static final String BUSCAR_ROL = "SELECT * FROM ROL WHERE NOMBRE=?";
	
	public static Rol findRol(String nombre) {
		
		Rol r = null;
		
		//Cargo el resulset con los registros de la tabla Rol
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_ROL);
			
			statement.setString(1, nombre);
			
			ResultSet resultado = statement.executeQuery();
			
			//Recorro el resulset cargando cada registro a la lista de retorno
			while(resultado.next()) {
				
					r = new Rol();
					r.setId_rol(resultado.getInt("ID_ROL"));
					r.setNombre(resultado.getString("NOMBRE"));
					r.setDescripcion(resultado.getString("DESCRIPCION"));
					
					
			}//fin while
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Registro no encontrado. || " +  e.getMessage());
		}
		
		return r;
		
	}//Fin de la funcion findRol() 

}
