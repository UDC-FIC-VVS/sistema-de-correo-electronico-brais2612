package gal.udc.fic.vvs.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Imagen;

//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra , positiva
//Mecanismo de seleccion de datos: String random que se me ha ocurrido.

public class imagenTest {
	
		private final String nombre= "Prueba";
		private final String contenido = "PruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPrueba.";
		private final String previsualizacion = nombre + "(" + contenido.length() + " bytes, image/png)";
		
		@Test
		public void imagenGeneratedNameTest() {
			 Imagen imagenPrueba = new Imagen(nombre,contenido);
			
			assertEquals(nombre,imagenPrueba.obtenerNombre());
		}
		
		@Test
		public void imagenGeneratedContentTest() {
			 Imagen imagenPrueba = new Imagen(nombre,contenido);
			
			assertEquals(contenido,imagenPrueba.obtenerContenido());

		}

		@Test
		public void imagenGeneratedTamañoTest() {
			 Imagen imagenPrueba = new Imagen(nombre,contenido);
			
			assertEquals(contenido.length(), imagenPrueba.obtenerTamaño());
			assertEquals(previsualizacion, imagenPrueba.obtenerPreVisualizacion());
		}
		
		@Test
		public void imagenGeneratedPreVisualTest() {
			 Imagen imagenPrueba = new Imagen(nombre,contenido);

			assertEquals(previsualizacion, imagenPrueba.obtenerPreVisualizacion());
		}
	
}
