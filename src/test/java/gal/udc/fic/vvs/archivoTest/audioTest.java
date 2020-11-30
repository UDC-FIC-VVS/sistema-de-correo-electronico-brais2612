package gal.udc.fic.vvs.archivoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Audio;

public class audioTest {
	
	private final String nombre= "Prueba";
	private final String contenido = "PruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPrueba.";
	
	@Test
	public void audioGeneratedTest() {
		 Audio audioPrueba = new Audio(nombre,contenido);
		
		assertEquals(nombre,audioPrueba.obtenerNombre());
		assertEquals(contenido,audioPrueba.obtenerContenido());
	}

}
