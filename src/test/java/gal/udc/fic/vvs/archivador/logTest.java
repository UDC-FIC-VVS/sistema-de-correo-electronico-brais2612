package gal.udc.fic.vvs.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Delegado;
import gal.udc.fic.vvs.email.archivador.Log;


//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra , positiva
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

public class logTest {
	
	private String nombre = "archivador";
	private String nombre1 = "archivadorDel";
	
	@Test
	public void obtenerNombre() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre,1);
		
		Log log = new Log(archivador);
		
		assertEquals(nombre,log.obtenerNombre());
		
	}
	
	@Test
	public void obtenerDelegado() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre,1);
		
		ArchivadorSimple archivadorDel = new ArchivadorSimple(nombre1,1);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivadorDel);
		
		Log log = new Log(delegado);
		
		assertEquals(archivadorDel,log.obtenerDelegado());
		
	}

}
