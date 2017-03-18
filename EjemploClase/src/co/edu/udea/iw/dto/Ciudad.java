package co.edu.udea.iw.dto;

/**
 * DTO para la tabla Ciudad
 * @autor Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 * 
 */

public class Ciudad {
		/**
		 * Codigo de la ciudad en la base de datos
		 */
		private Long codigo;
		/**
		 * Nombre completo de la ciudad
		 */
		private String nombre;
		/**
		 * Código o indicativo para llamadas
		 */
		private String codigoArea;
		
			public Long getCodigo() {
				return codigo;
			}
			public void setCodigo(Long codigo) {
				this.codigo = codigo;
			}
			public String getNombre() {
				return nombre;
			}
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}
			public String getCodigoArea() {
				return codigoArea;
			}
			public void setCodigoArea(String codigoArea) {
				this.codigoArea = codigoArea;
			}
			
		
}
