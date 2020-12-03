package gal.udc.fic.vvs.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;


//Nivel de la prueba: Unidade
//Categoría: Funcional dinámica de caja negra , positiva
//Mecanismo de seleccion de datos: GeneradorString.class 

//ASK: NO SÉ POR QUÉ ME DA UN ERROR LA CONSOLA, PERO EL JUNIT SE EJECUTA BIEN. PREGUNTAR A PROFE

@RunWith(JUnitQuickcheck.class)

public class archivadorSimpleTestPBT {
	
	private String nombre = "archivador";


	@Property
	public void almacenarCorreoTest(@From(GeneradorString.class) String contenido,@InRange(min = "0") int espacio) {
		
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombre,espacio);
		
		Mensaje correo = new Mensaje(new Texto("TextoPrueba",contenido));
		
		assertTrue(archivadorSimple.almacenarCorreo(correo));
		assertEquals(espacio-correo.obtenerTamaño(),archivadorSimple.obtenerEspacioDisponible());
		
	}
}
