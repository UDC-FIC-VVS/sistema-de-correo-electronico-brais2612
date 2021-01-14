package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;


//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra 
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

public class ArchivadorSimpleTest {
	
	private String nombre = "archivador";
	private int espacio = 5000;
	
	
	//Comprobar:obtenerNombre
	//Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void obtenerNombreTest() {
		ArchivadorSimple archivadorTest = new ArchivadorSimple(nombre,espacio);
		
		assertEquals(nombre,archivadorTest.obtenerNombre());
	}
	
	//Comprobar:obtenerEspacioTotal
	//Categoría: Funcional dinámica de caja negra  positiva
	
	@Test
	public void obtenerEspacioTotalTest() {
		ArchivadorSimple archivadorTest = new ArchivadorSimple(nombre,espacio);
		
		assertEquals(espacio,archivadorTest.obtenerEspacioTotal());
	}
	
	//Comprobar:obtenerEspacioDisponible
	//Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void obtenerEspacioDisponibleTest() {
		ArchivadorSimple archivadorTest = new ArchivadorSimple(nombre,espacio);
		
		assertEquals(espacio,archivadorTest.obtenerEspacioDisponible());
	}
	
	//Comprobar:obtenerDelegado null
	//Categoría: Funcional dinámica de caja negra positiva
	@Test
	public void obtenerDelegadoTest() {
		ArchivadorSimple archivadorTest = new ArchivadorSimple(nombre,espacio);
		
		assertEquals(null,archivadorTest.obtenerDelegado());
	}
	
	//Comprobar: almacenar un correo con espacio vacío
	//Categoría: Funcional dinámica de caja negra negativa
	//BUG: No debería dejar con el valor del espacio del archivador siendo 0.
	
	@Test 
	public void almacenarCorreoVacio() {
		
		ArchivadorSimple archivadorTest = new ArchivadorSimple(nombre, 0);
			
		Mensaje correo = new Mensaje(new Texto("PruebaPruebaPrueba", "PruebaPruebaPruebaPruebaPrueba"));
				
		assertFalse(archivadorTest.almacenarCorreo(correo));
		
	}


}
