package gal.udc.fic.vvs.email.correo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CarpetaTest {
	
	private final String nombre= "prueba";
	private final String nombre2 = "prueba2";	
	private final String nombreTexto = "prueba";
	private final String contenido = "pruebapruebapruebapruebapruebapruebaprueba";
	private final int tamañoContenido= contenido.length();
	private final int numMensajes=3;
	private final int numSubCarpetas=2;
	private final Texto textoTest = new Texto(nombreTexto,contenido);

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void carpetaObtenerTamañoTest() {
		Carpeta carpetaTest = new Carpeta(nombre);
		Mensaje mensaje = new Mensaje(textoTest);
		
	//	carpetaTest.añadir(mensaje);
		
		
	}
}
