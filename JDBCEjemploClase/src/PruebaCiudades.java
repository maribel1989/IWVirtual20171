import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStaterment;

/*
 *Clase creada para consultar la lista de ciudades en la base de datos
 *y mostrar su resultado en consola 
 *
 *@autor Maribel Chaverra Valencia 
 */
public class PruebaCiudades {

	public static void main(String[] args) {
		
		consultarCiudades();

	}
	
	/*
	 * metodo que me permite consultar las ciudades en la base de datos y
	 * mostrar su codigo y nombre en consola
	 */
	public static void consultarCiudades(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/clase";
		String usuario = "clase";
		String pws = "claseingenieriaweb*";
		String consulta = "SELECT * From Ciudades";
		
		try{
			//Va a cargar en el class loader de la aplicación el driver 
			//de la base de datos que vamos a acceder.
			Class.forName("com.mysql.jdbc.Driver");
			//Establece conexion con la base de datos
				//Solicita 3 atributos
				//URL Conexion a la base de datos
				//Usuario de bd con el que se va a conectar
				//Contraseña del usuario
			con = DriverManager.getConnection(url,usuario,pws);
			
			//Preparar la consulta o sentencia que voy a ejecutar contra la base de datos
			ps = con.prepareStatement(consulta);
			//Obtener el resultado de la consulta en un objeto que se pueda iterar
			rs=ps.executeQuery();
			//Iterar el resultado 
			while(rs.next()){
				System.out.println(rs.getLong("codigo")+ ": "+ rs.getString("Nombre"));
			}
		  }catch(ClassNotFoundException | SQLException e){
			  e.printStackTrace();
		  }finally{
			  try{
				  if (rs!=null){
					  rs.close();
				  }
				  if (ps!=null){
					  ps.close();
				  }
				  if(con!=null){
					  con.close();
				  }
			  }catch (SQLException e){
				  e.printStackTrace();
			  }
		  }
	}
}
