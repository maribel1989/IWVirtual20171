import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase creada para consultar la lista de ciudades en la base de datos
 * y mostrar su resultado en consola
 * 
 * @autor Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 */
public class PruebaCiudades {

	/*
	 * Llama al metodo consularCiudades el cual consulta los datos
	 * de las ciudades de la base de datos
	 * 
	 */
	public static void main(String[] args) {
		consultarCiudades();
	}
		
	/*
	 * Método que permite consultar las ciudades en la base de datos y 
	 * mostrar su codigo y su nombre en consola
	 */
	public static void consultarCiudades(){
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/clase";
		String usuario = "clase";
		String pws = "admin";
		String consulta = "SELECT * FROM Ciudades";
		
		try{
			// Va a cargar en el class Loader de la aplicación 
			// el driver de la base de datos que vamos a acceder
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establece conexión con la base de datos
			//Solicita 3 atributos
			//Url conexión a la base de datos
			//Usuario de bd con el que se va a conectar
			//Contraseña del usuario
			con = DriverManager.getConnection(url, usuario, pws);
			
			//Preparar la consulta o sentencia a ejecutar contra la base de datos
			ps = con.prepareStatement(consulta);
			
			//Obtener el resultado de la consulta en objeto que se pueda iterar
			rs = ps.executeQuery();
			
			//Iterar el resultado 
			while(rs.next()){
				System.out.println(rs.getLong("codigo")+ 
						": " + rs.getString("Nombre"));
			}
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(con!=null){
					con.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

}