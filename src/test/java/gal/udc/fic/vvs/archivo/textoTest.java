package gal.udc.fic.vvs.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra , positiva
//Mecanismo de seleccion de datos: String random que se me ha ocurrido.
public class textoTest {
	private final String nombre= "Prueba";
	private final String contenido = "PruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPruebaPrueba.";
	
	@Test
	public void textoGeneratedNameTest() {
		Texto textoPrueba = new Texto(nombre,contenido);
		
		assertEquals(contenido,textoPrueba.obtenerContenido());		
	}
	
	@Test
	public void textoGeneratedContentTest() {
		Texto textoPrueba = new Texto(nombre,contenido);
		
		assertEquals(contenido,textoPrueba.obtenerContenido());		
	}
}