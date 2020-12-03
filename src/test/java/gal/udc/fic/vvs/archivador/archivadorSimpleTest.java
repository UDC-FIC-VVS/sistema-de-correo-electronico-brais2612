package gal.udc.fic.vvs.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;


//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra , positiva
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

public class archivadorSimpleTest {
	
	private String nombre = "archivador";
	private int espacio = 5000;
	
	@Test
	public void obtenerNombreTest() {
		ArchivadorSimple archivadorTest = new ArchivadorSimple(nombre,espacio);
		
		assertEquals(nombre,archivadorTest.obtenerNombre());
	}
	
	@Test
	public void obtenerEspacioTotalTest() {
		ArchivadorSimple archivadorTest = new ArchivadorSimple(nombre,espacio);
		
		assertEquals(espacio,archivadorTest.obtenerEspacioTotal());
	}
	
	@Test
	public void obtenerEspacioDisponibleTest() {
		ArchivadorSimple archivadorTest = new ArchivadorSimple(nombre,espacio);
		
		assertEquals(espacio,archivadorTest.obtenerEspacioDisponible());
	}
	
	@Test
	public void obtenerDelegadoTest() {
		ArchivadorSimple archivadorTest = new ArchivadorSimple(nombre,espacio);
		
		assertEquals(null,archivadorTest.obtenerDelegado());
	}


}
