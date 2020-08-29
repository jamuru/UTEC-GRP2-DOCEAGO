package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

	private static Connection databaseConnection;

	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "DOCEAGOSTO";
	private static String CLAVE = "DOCEAGOSTO";

	static {

		databaseConnection = null;

		try {// tenemos vinculada la clase en nuestro proyecto

			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Se encontró el Driver para Oracle DB /  La librería necesaria está referenciada");

			try {// intentamos instanciar el objeto connection

				databaseConnection = DriverManager.getConnection(CONNECTION_STRING, USUARIO, CLAVE);

				System.out.println("Concexión creada con éxito, es posible acceder a la base de datos!");

			} catch (SQLException e) {

				System.out.println("No logramos instanciar una conexión!");
				e.printStackTrace();

			} // intentamos instanciar el objeto connection

		} catch (ClassNotFoundException e) {

			System.out.println("No tienes el driver en tu build-path");
			e.printStackTrace();

		} // tenemos vinculada la clase en nuestro proyecto?

	}

	public static Connection getConnection() {

		return databaseConnection;
	}

}
