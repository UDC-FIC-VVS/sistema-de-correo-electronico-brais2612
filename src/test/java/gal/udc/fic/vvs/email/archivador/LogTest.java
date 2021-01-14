package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Delegado;
import gal.udc.fic.vvs.email.archivador.Log;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;


//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

public class LogTest {
	
	private String nombre = "archivador";
	private String nombre1 = "archivadorDel";
	
	//Comprobar ObtenerNombre
	//Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void obtenerNombre() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre,1);
		
		Log log = new Log(archivador);
		
		assertEquals(nombre,log.obtenerNombre());
		
	}
	
	//COmprobar obtenerDelegado
	//Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void obtenerDelegado() {
		
		ArchivadorSimple archivador = new ArchivadorSimple(nombre,1);	
		ArchivadorSimple archivadorDel = new ArchivadorSimple(nombre1,1);	
		Delegado delegado = new Delegado(archivador);
		delegado.establecerDelegado(archivadorDel);	
		Log log = new Log(delegado);
		
		assertEquals(archivadorDel,log.obtenerDelegado());
		
	}
	
	//Comprobar obtenerDelegado con arch simple
	//Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void LogTest_obtenerDelegadoConArchivadorSimple () {

		
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", 1);
		ArchivadorSimple archivadorDel = new ArchivadorSimple("archivadorDelegado", 1);	
		Log log = new Log(archivador);	
		log.establecerDelegado(archivadorDel);
		
		assertEquals(null, log.obtenerDelegado());
		
	}
	
	//Comprobar que el mensaje que sale es el del log.
	//Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void mensajeLogVálido () throws OperacionInvalida {
		
		final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(outputStreamCaptor));		
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", 1);		
		ArchivadorSimple archivadorDel = new ArchivadorSimple("archivadorDelegado", 1);		
		Log log = new Log(archivador);
		
		log.establecerDelegado(archivadorDel);		
		log.almacenarCorreo(new Carpeta("carpeta"));	
		
		
		assertEquals("Mensaxe de log", outputStreamCaptor.toString().trim());
		
	}

}
