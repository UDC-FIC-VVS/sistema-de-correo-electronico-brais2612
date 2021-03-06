package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Delegado;


//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

public class DelegadoTest {
	
	private String nombre = "archivador";
	
	
	//Comprobar establecerDelegado
	//Categoría: Funcional dinámica de caja negra positiva
	@Test
	public void establecerDelegadoTest() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre,1);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals(archivador,delegado.obtenerDelegado());
		
	}
	//Comprobar obtenerNombre
	//Categoría: Funcional dinámica de caja negra positiva
	@Test
	public void obtenerNombreTest() {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre,1);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals(nombre,delegado.obtenerNombre());
		
	}

}
