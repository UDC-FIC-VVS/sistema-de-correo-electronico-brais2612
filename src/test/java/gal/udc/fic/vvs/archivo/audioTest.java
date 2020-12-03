package gal.udc.fic.vvs.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Audio;


//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra , positiva
//Mecanismo de seleccion de datos: String random que se me ha ocurrido.

//TODO: PBTś archivo

public class audioTest {
	
	private final String nombre= "Prueba";
	private final String contenido = "PruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPrueba.";
	
	@Test
	public void audioGeneratedNameTest() {
		 Audio audioPrueba = new Audio(nombre,contenido);
		
		assertEquals(nombre,audioPrueba.obtenerNombre());
	}
	
	@Test
	public void audioGeneratedContentTest() {
		 Audio audioPrueba = new Audio(nombre,contenido);
		
		assertEquals(contenido,audioPrueba.obtenerContenido());
	}

}
