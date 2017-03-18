package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * Interface que me define los métodos permitidos para las Ciudades 
 * en el sistema
 * @autor Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 * 
 */
public interface CiudadDAO {
	
	/**
	 * Obtiene la lista de ciudades que existen en el sistema 
	 * ordenadas alfabeticamente por el nombre
	 * @return lista de ciudades ordenada
	 * @throws MyException ocurre cuando hay un problema con la conexión 
	 * a la BD
	 */
	
	public List<Ciudad> get() throws MyException;
}
