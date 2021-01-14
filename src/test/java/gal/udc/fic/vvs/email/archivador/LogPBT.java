package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import GeneradoresPBT.GeneradorMensaje;
import GeneradoresPBT.GeneradorString;
import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Log;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

//Nivel de la prueba: Unidade
//Categoría: Funcional dinámica de caja negra 
//Mecanismo de seleccion de datos: GeneradorString.class  && GeneradorMensaje.class

@RunWith(JUnitQuickcheck.class)
public class LogPBT {

	// Comprobar obtenerNOmbre con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void LogPBT_obtenerNombre(@From(GeneradorString.class) String nombre) {

		ArchivadorSimple archivadorTest = new ArchivadorSimple(nombre, 5);
		Log logTest = new Log(archivadorTest);
		logTest.establecerDelegado(archivadorTest);

		assertEquals(nombre, logTest.obtenerNombre());

	}

	// Comprobar almacenar correo con PBT
	// Categoría: Funcional dinámica de caja negra positiva
	// El espacio minimo deberia ser 1

	@Property
	public void almacenarCorreo(@InRange(min = "1") int espacio, @From(GeneradorMensaje.class) Mensaje mensajeTest) {

		Log logTest = new Log(new ArchivadorSimple("archivadorTest", espacio));

		assertTrue(logTest.almacenarCorreo(mensajeTest));

	}
	// Comprobar obtenerEspacioTotal
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void obtenerEspacioTotal(int espacio) {

		Log logTest = new Log(new ArchivadorSimple("archivadorTest", espacio));

		assertEquals(espacio, logTest.obtenerEspacioTotal());

	}

	// Comprobar obtenerEspacioDisponible
	// Categoría: Funcional dinámica de caja negra positiva
	// El espacio minimo deberia ser 1

	@Property
	public void obtenerEspacioDisponible(@InRange(min = "1") int espacio) {

		Log logTest = new Log(new ArchivadorSimple("archivadorTest", espacio));

		assertEquals(espacio, logTest.obtenerEspacioDisponible());

	}

	// Comprobar almacenar correo con menos espacio
	// Categoría: Funcional dinámica de caja negra positiva
	// El espacio minimo deberia ser 1

	@Property
	public void almacenarCorreoMenosEspacio(@InRange(min = "1") int espacio,
			@From(GeneradorMensaje.class) Mensaje mensajeTest) {

		Log logTest = new Log(new ArchivadorSimple("archivadorTest", espacio));
		logTest.almacenarCorreo(mensajeTest);

		assertEquals(espacio - mensajeTest.obtenerTamaño(), logTest.obtenerEspacioDisponible());

	}

	// Comprobar que almacenaCorreo con PBT y mensaje
	// Categoría: Funcional dinámica de caja negra positiva
	// El espacio minimo deberia ser 1

	@Property
	public void almacenarCorreoPBT(@InRange(min = "1") int espacio, @From(GeneradorMensaje.class) Mensaje mensajeTest) {

		ArchivadorSimple archivadorTest = new ArchivadorSimple("archivadorTest", espacio);
		ArchivadorSimple archivadorDel = new ArchivadorSimple("archivadorDel", espacio);
		Log logTest = new Log(archivadorTest);

		logTest.establecerDelegado(archivadorDel);
		boolean assertT = logTest.almacenarCorreo(mensajeTest);

		assertTrue(assertT);

	}

	// Comprobar que almacenaCorreo con PBT y mensaje
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void almacenarCorreoFalse(@From(GeneradorString.class) String contenidoTest) throws OperacionInvalida {

		int max = contenidoTest.length() - 1;
		int min = 1;
		int range = max - min + 1;
		int espacio = (int) (Math.random() * range) + min;

		ArchivadorSimple archivadorTest = new ArchivadorSimple("archivadorTest", espacio);
		ArchivadorSimple archivadorDel = new ArchivadorSimple("archivadorDel", espacio);
		Log logTest = new Log(archivadorTest);

		logTest.establecerDelegado(archivadorDel);
		boolean assertF = logTest.almacenarCorreo(new Mensaje(new Texto("TEST", contenidoTest)));

		assertFalse(assertF);

	}

}
