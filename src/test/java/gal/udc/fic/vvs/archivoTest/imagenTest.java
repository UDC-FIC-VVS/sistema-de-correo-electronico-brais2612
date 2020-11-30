package gal.udc.fic.vvs.archivoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Imagen;

public class imagenTest {
	
		private final String nombre= "Prueba";
		private final String contenido = "PruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPrueba.";
		private final String previsualizacion = nombre + "(" + contenido.length() + " bytes, image/png)";
		
		@Test
		public void imagenGeneratedTest() {
			 Imagen imagenPrueba = new Imagen(nombre,contenido);
			
			assertEquals(nombre,imagenPrueba.obtenerNombre());
			assertEquals(contenido,imagenPrueba.obtenerContenido());
			assertEquals(contenido.length(), imagenPrueba.obtenerTamaño());
			assertEquals(previsualizacion, imagenPrueba.obtenerPreVisualizacion());
		}

	
}
