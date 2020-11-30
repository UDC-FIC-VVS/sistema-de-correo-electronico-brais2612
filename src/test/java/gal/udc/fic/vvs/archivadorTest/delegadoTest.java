package gal.udc.fic.vvs.archivadorTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Delegado;

public class delegadoTest {
	
	private String nombre = "archivador";
	
	@Test
	public void establecerDelegadoTest() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre,1);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals(archivador,delegado.obtenerDelegado());
		
	}
	
	@Test
	public void obtenerNombreTest() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre,1);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals(nombre,delegado.obtenerNombre());
		
	}

}
