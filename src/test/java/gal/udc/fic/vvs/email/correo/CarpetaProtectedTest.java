package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba:Unidad , para probar los metodos protegidos de carpeta.class
//Categoría: Funcional dinámica de caja negra
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.


public class CarpetaProtectedTest {
	
	private final String nombre = "Carpeta de prueba";
	
	
	// Comprobar: obtener padre carpeta y establecer padre
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void obteneYEstablecerrPadre() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombre);
		Carpeta padre = new Carpeta(nombre);
		carpeta.establecerPadre(padre);
		
		assertEquals(padre, carpeta.obtenerPadre());
	}

	
	// Comprobar: poner como padre un mensaje, debe dar error.
	// Categoría: Funcional dinámica de caja negra negativo.
	// Bug:No sé si se debería dejar poner un mensaje como padre.
	
	@Test
	public void establecerMensajePadre() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombre);
		Mensaje mensaje = new Mensaje(new Texto("Padre", "MensajeMensajeMensaje"));				
		carpeta.establecerPadre(mensaje);
		
		assertEquals(mensaje, carpeta.obtenerPadre());
	}
}
