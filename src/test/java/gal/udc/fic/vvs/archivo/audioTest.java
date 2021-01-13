package gal.udc.fic.vvs.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Audio;


//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra
//Mecanismo de seleccion de datos: String random que se me ha ocurrido.

//TODO: PBTś archivo

public class audioTest {
	
	private final String nombre= "Prueba";
	private final String contenido = "PruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPrueba.";
	
	//COmprobar: obtenerNombre
	//Categoría: Funcional dinámica de caja negra positiva
	@Test
	public void audioGeneratedNameTest() {
		 Audio audioPrueba = new Audio(nombre,contenido);
		
		assertEquals(nombre,audioPrueba.obtenerNombre());
	}
	
	//Comprobar: obtenerNombre con Audio vacío, no debería generar.
	//Categoría: Funcional dinámica de caja negra negativa

	//Bug: NO deberia estar vacio
	@Test
	public void audioVacioGeneratedNameTest() {
		 Audio audioPrueba = new Audio("","");
		 String  vacio = "";
		assertEquals(vacio,audioPrueba.obtenerNombre());
	}
	
	//COmprobar: obtenerNombre
	//Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void audioGeneratedContentTest() {
		 Audio audioPrueba = new Audio(nombre,contenido);
		
		assertEquals(contenido,audioPrueba.obtenerContenido());
	}
	
	//COmprobar: obtenerCOntenido y no deberia obtenerlo porque lo pondremos vacio
	//Categoría: Funcional dinámica de caja negra negativa
	//Bug:NO deberia estar vacio
	
	@Test
	public void audioVacioGeneratedContentTest() {
		 Audio audioPrueba = new Audio("","");
		 String  vacio = "";
		assertEquals(vacio,audioPrueba.obtenerContenido());
	}

}
