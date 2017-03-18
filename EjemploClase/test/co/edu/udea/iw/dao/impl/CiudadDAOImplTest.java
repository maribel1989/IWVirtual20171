package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * Prueba Unitaria que permite el correcto funcionamiento de la 
 * clase CiudadDAOImplTest
 * @author Maribel Chaeverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public class CiudadDAOImplTest {

	@Test
	public void testGet() {
		CiudadDAO ciudadDao = null;
		List<Ciudad> ciudades = null;
		
		try{
			ciudadDao = new CiudadDAOImpl();
			ciudades = ciudadDao.get();
			
			for(Ciudad ciudad: ciudades){
				System.out.println(ciudad.getCodigo() + 
						": " +  ciudad.getNombre());
			}
			
			assertTrue(ciudades.size()>0);
		}catch(MyException e){
			fail(e.getMessage());
		}
	}

}
