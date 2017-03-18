package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import co.edu.udea.iw.exception.MyException;

/**
 * Clase encargada de realizar conexiones a la base de datos
 * @autor Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0 
 */

public class DataSource {

	public Connection getConnection() throws MyException{
			
		String url = "jdbc:mysql://localhost:3306/clase";
		String usuario = "clase";
		String pws = "admin";
		String consulta = "SELECT * FROM Ciudades";
		Connection con = null;
		
		try{
			// Va a cargar en el class Loader de la aplicación 
			// el driver de la base de datos que vamos a acceder
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establece conexión con la base de datos
			//Solicita 3 atributos
			//	Url conexión a la base de datos
			//	Usuario de bd con el que se va a conectar
			//	Contraseña del usuario
			con = DriverManager.getConnection(url, usuario, pws);
		}catch(ClassNotFoundException e){
			throw new MyException("El driver de conexion a la base de "
					+ "datos no ha sido encontrado",e);
		}catch(SQLException e){
			throw new MyException("Ha ocurrido un error estableciendo "
					+ "conexion con la base de datos",e);
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
}

}