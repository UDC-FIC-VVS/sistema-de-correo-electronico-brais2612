package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Imagen;

//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra 
//Mecanismo de seleccion de datos: String random que se me ha ocurrido.

public class ImagenTest {
	
		private final String nombre= "Prueba";
		private final String contenido = "PruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPrueba.";
		private final String previsualizacion = nombre + "(" + contenido.length() + " bytes, image/png)";
		
		
		// Comprobar: obtenerNombre
		// Categoría: Funcional dinámica de caja negra positiva
		
		@Test
		public void imagenGeneratedNameTest() {
			 Imagen imagenPrueba = new Imagen(nombre,contenido);
			
			assertEquals(nombre,imagenPrueba.obtenerNombre());
		}
		
		// Comprobar: obtenerNombre con imagen que NO deberia estar vacia
		// Categoría: Funcional dinámica de caja negra negativa
		//BUG: No deberia estar vacio
		
		@Test
		public void imagenVaciaGeneratedNameTest() {
			
			Imagen imagenPrueba = new Imagen("", "");
			
			assertEquals("", imagenPrueba.obtenerNombre());
			
		}
		
		// Comprobar: obtenerContenido
		// Categoría: Funcional dinámica de caja negra positiva
		@Test
		public void imagenGeneratedContentTest() {
			 Imagen imagenPrueba = new Imagen(nombre,contenido);
			
			assertEquals(contenido,imagenPrueba.obtenerContenido());

		}
		// Comprobar: obtenerContenido con imagen que NO deberia estar vacia
		// Categoría: Funcional dinámica de caja negra negativa
		
		//BUG :  No deberia estar vacio
		@Test
		public void imagenVaciaGeneratedContentTest() {
			
			Imagen imagenPrueba = new Imagen("", "");
			
			assertEquals("", imagenPrueba.obtenerContenido());
			
		}
		
		// Comprobar: obtenerPreVisualizacion con PBT
		// Categoría: Funcional dinámica de caja negra positiva
		
		@Test
		public void imagenGeneratedTamañoTest() {
			 Imagen imagenPrueba = new Imagen(nombre,contenido);
			
			assertEquals(contenido.length(), imagenPrueba.obtenerTamaño());
		}
		
		// Comprobar: obtenerPreVisualizacion con PBT
		// Categoría: Funcional dinámica de caja negra positiva
		
		@Test
		public void imagenGeneratedPreVisualTest() {
			 Imagen imagenPrueba = new Imagen(nombre,contenido);

			assertEquals(previsualizacion, imagenPrueba.obtenerPreVisualizacion());
		}
	
}
