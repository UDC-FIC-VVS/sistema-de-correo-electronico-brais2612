package gal.udc.fic.vvs.archivoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class textoTest {
	private final String nombre= "Prueba";
	private final String contenido = "PruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPrueba.";
	
	@Test
	public void textoGeneratedTest() {
		Texto textoPrueba = new Texto(nombre,contenido);
		
		assertEquals(nombre,textoPrueba.obtenerNombre());
		assertEquals(contenido,textoPrueba.obtenerContenido());		
	}
}
