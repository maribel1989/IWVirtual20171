package co.edu.udea.iw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

	/**
	 * Implementaqción de la interface {@link CiudadDAO}
	 * @author Maribel Chaeverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */

public class CiudadDAOImpl extends DataSource implements CiudadDAO {

	@Override
	public List<Ciudad> get() throws MyException {
		
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		/**
		 * Obtiene la lista de ciudades que existen en el sistema 
		 * @return lista de ciudades
		 * @throws MyException ocurre cuando hay un problema con la conexión 
		 * a la BD
		 */
		
		try{
			
		  con = getConnection();
		  ps = con.prepareStatement("SELECT * FROM ciudades ORDER BY Nombre");
		  rs = ps.executeQuery();
			
			while(rs.next()){
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("Codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
				ciudades.add(ciudad);
				
				
			}
			
		}catch(SQLException e){
			throw new MyException("Ocurrió un error obteniendo la información"
					+ " de las ciudades");
			
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
				throw new MyException("Ocurrio un error cerrando la conexión"
						+ " a la base de datos", e);
			}
		}
		return ciudades;
	}

}
