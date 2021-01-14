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
import GeneradoresPBT.GeneradorMensaje;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;


//Nivel de la prueba: Unidade
//Categoría: Funcional dinámica de caja negra 
//Mecanismo de seleccion de datos: GeneradorString.class 

@RunWith(JUnitQuickcheck.class)
public class DelegadoPBT {

	// Comprobar obtenerNombre
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void obtenerNombre(@From(GeneradorString.class) String nombre) {

		ArchivadorSimple archivadorTest = new ArchivadorSimple(nombre, 5);
		Delegado delegadoTest = new Delegado(archivadorTest);
		delegadoTest.establecerDelegado(archivadorTest);

		assertEquals(nombre, delegadoTest.obtenerNombre());
	}

	// Comprobar ObtenerEspacioDisponible sin el correo
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void obtenerEspacioDisponibleSinCorreo(int espacio) {

		ArchivadorSimple archivadorTest = new ArchivadorSimple("archivadorTest", espacio);
		Delegado delegadoTest = new Delegado(archivadorTest);
		delegadoTest.establecerDelegado(archivadorTest);

		assertEquals(espacio, delegadoTest.obtenerEspacioDisponible());
	}

	// Comprobar obtenerEspacioTotal
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void obtenerEspacioTotal(int espacio) {

		ArchivadorSimple archivadorTest = new ArchivadorSimple("archivadorTest", espacio);
		Delegado delegadoTest = new Delegado(archivadorTest);
		delegadoTest.establecerDelegado(archivadorTest);

		assertEquals(espacio, delegadoTest.obtenerEspacioTotal());
	}

	// Comprobar AlmacenarCorreo
	// Categoría: Funcional dinámica de caja negra positiva
	// El espacio minimo deberia ser 1

	@Property
	public void almacenarCorreo(@InRange(min = "1") int espacio, @From(GeneradorMensaje.class) Mensaje mensajeTest) {

		ArchivadorSimple archivadorTest = new ArchivadorSimple("archivadorTest", espacio);
		Delegado delegadoTest = new Delegado(archivadorTest);
		delegadoTest.establecerDelegado(archivadorTest);

		assertTrue(delegadoTest.almacenarCorreo(mensajeTest));
	}

	// Comprobar AlmacenarCorreo con menor espacio
	// Categoría: Funcional dinámica de caja negra positiva
	// El espacio minimo deberia ser 1

	@Property
	public void almacenarCorreoMenosEspacio(@InRange(min = "1") int espacio,
			@From(GeneradorMensaje.class) Mensaje mensajeTest) {

		ArchivadorSimple archivadorTest = new ArchivadorSimple("archivadorTest", espacio);
		Delegado delegadoTest = new Delegado(archivadorTest);

		delegadoTest.establecerDelegado(archivadorTest);
		delegadoTest.almacenarCorreo(mensajeTest);

		assertEquals(espacio - mensajeTest.obtenerTamaño(), delegadoTest.obtenerEspacioDisponible());
	}

	// COmprobar almacenarCorreo con archivador sin espacio
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void almacenarCorreoArchivadorSinEspacio(@From(GeneradorString.class) String contenido) {

		int max = contenido.length() - 1;
		int min = 1;
		int range = max - min + 1;
		int espacio = (int) (Math.random() * range) + min;

		ArchivadorSimple archivadorTest = new ArchivadorSimple("archivadorTest", espacio);
		Delegado delegadoTest = new Delegado(archivadorTest);
		delegadoTest.establecerDelegado(archivadorTest);
		Mensaje mensajeTest = new Mensaje(new Texto("Pruebaprueba", contenido));

		assertFalse(delegadoTest.almacenarCorreo(mensajeTest));
	}

}
