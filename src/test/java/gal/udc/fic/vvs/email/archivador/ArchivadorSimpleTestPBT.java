package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import GeneradoresPBT.GeneradorString;
import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;


//Nivel de la prueba: Unidade
//Categoría: Funcional dinámica de caja negra 
//Mecanismo de seleccion de datos: GeneradorString.class 



@RunWith(JUnitQuickcheck.class)

public class ArchivadorSimpleTestPBT {
	
	private String nombre = "archivador";


	//Comprobar Almacenar correo
	//Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void almacenarCorreoRandomTest(@From(GeneradorString.class) String contenido,@InRange(min = "0") int espacio) {
		
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombre,espacio);
		
		Mensaje correo = new Mensaje(new Texto("PruebaPrueba",contenido));
		
		assertTrue(archivadorSimple.almacenarCorreo(correo));
		
	}
	
	//Comprobar obtenerNombre 
	//Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void obtenerNombreArchivadorSimple(@From(GeneradorString.class) String nombre) {
		
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombre, 1);
		
		assertEquals(nombre, archivadorSimple.obtenerNombre());
	}
	
	//Comprobar ObtenerEspacioDisponible
	//Categoría: Funcional dinámica de caja negra positiva
	
	@Property 
	public void almacenarCorreoTest_obtenerEspacioDisponible(@From(GeneradorString.class) String contenido,  @InRange(min = "1") int espacio) {
		
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombre, espacio);
		
		Mensaje correo = new Mensaje(new Texto("TextoPrueba", contenido));
		
		archivadorSimple.almacenarCorreo(correo);

		assertEquals(espacio - correo.obtenerTamaño(),
				archivadorSimple.obtenerEspacioDisponible());
	}
	
	//Comprobar obtenerEspacioTotal
	//Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void obtenerEspacioTotal(int espacio) {
		
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombre, espacio);
		
		assertEquals(archivadorSimple.obtenerEspacioTotal(), espacio);
	}

	//Comprobar obtenerEspacioDisp  sin archivos
	//Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void obtenerEspacioDisponibleSinAchivo(int espacio) {
		
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombre, espacio);
		
		assertEquals(archivadorSimple.obtenerEspacioDisponible(), espacio);
	}
	
	//Comprobar almacenar con espacio negativo
	//Categoría: Funcional dinámica de caja negra negativa.
	
	//BUG: No deberia dejar poner espacios negativos
	@Property 
	public void almacenarConEspacioNegativo(@InRange(max = "-1") int espacio) {
		
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombre, espacio);
			
		Mensaje correo = new Mensaje(new Texto("PruebaPruebaPrueba", "PruebaPruebaPruebaPruebaPrueba"));
				
		assertFalse(archivadorSimple.almacenarCorreo(correo));
	}
}
