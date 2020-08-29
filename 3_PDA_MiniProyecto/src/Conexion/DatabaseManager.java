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

			System.out.println("Se encontr� el Driver para Oracle DB /  La librer�a necesaria est� referenciada");

			try {// intentamos instanciar el objeto connection

				databaseConnection = DriverManager.getConnection(CONNECTION_STRING, USUARIO, CLAVE);

				System.out.println("Concexi�n creada con �xito, es posible acceder a la base de datos!");

			} catch (SQLException e) {

				System.out.println("No logramos instanciar una conexi�n!");
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
