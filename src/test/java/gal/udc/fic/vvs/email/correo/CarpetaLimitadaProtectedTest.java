package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba:Unidad , para probar los metodos protegidos de carpetaLimitada.class
//Categoría: Funcional dinámica de caja negra
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

public class CarpetaLimitadaProtectedTest {
		
	private final String nombre = "Carpeta de prueba";
	
	private int tamaño = 50;
	
	
	// Comprobar: obtener padre carpeta y establecer padre
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void obteneYEstablecerPadre() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombre);
		Carpeta padre = new Carpeta(nombre);	
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);	
		carpetaLimitada.establecerPadre(padre);
		
		assertEquals(padre, carpetaLimitada.obtenerPadre());
	}

	// Comprobar: poner como padre un mensaje, debe dar error.
	// Categoría: Funcional dinámica de caja negra negativo.
	// Bug:No sé si se debería dejar poner un mensaje como padre.
	
	
	@Test
	public void establecerMensajePadre() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombre);
		Mensaje mensaje = new Mensaje(new Texto("Padre", "MensajeMensajeMensaje"));		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		
		carpetaLimitada.establecerPadre(mensaje);
		
		assertEquals(mensaje, carpetaLimitada.obtenerPadre());
	}
}
