package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import GeneradoresPBT.GeneradorCarpeta;
import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba: Integracion y Unidad ( especifico en cada uno)
//Categoría: Funcional dinámica de caja negra 
//Mecanismo de seleccion de datos:   GeneradorMensaje.class && el propio StringGenerator.class de quickcheck


@RunWith(JUnitQuickcheck.class)
public class CarpetaPBT {

	// Comprobar: buscar carpeta con PBT
	// Prueba a nivel de integración
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void buscar(@From(GeneradorCarpeta.class) Carpeta carpetaTest) {

		Collection resultado = carpetaTest.buscar("MensajeMensaje");

		assertEquals(GeneradorCarpeta.TAMAÑO, carpetaTest.obtenerNoLeidos());
	}

	// Comprobar: establecerLeido carpeta con PBT
	// Prueba a nivel de integración
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void establecerLeido(@From(GeneradorCarpeta.class) Carpeta carpetaTest) throws OperacionInvalida {

		carpetaTest.establecerLeido(true);

		assertEquals(0, carpetaTest.obtenerNoLeidos());
	}

	// Comprobar: establecerNoLeido carpeta con PBT
	// Prueba a nivel de integración
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void establecerNoLeido(@From(GeneradorCarpeta.class) Carpeta carpetaTest) throws OperacionInvalida {

		carpetaTest.establecerLeido(false);

		assertEquals(GeneradorCarpeta.TAMAÑO, carpetaTest.obtenerNoLeidos());
	}

	// Comprobar: obtenerTamaño de mensajes con PBT
	// Prueba a nivel de integración
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void obtenerTamañoMensajes(@From(GeneradorCarpeta.class) Carpeta carpetaTest) throws OperacionInvalida {

		assertTrue(carpetaTest.obtenerTamaño() > 0);
	}

	// Comprobar: eliminar mensaje de carpeta con PBT
	// Prueba a nivel de integración
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void eliminarMensajeCarpeta(@From(GeneradorCarpeta.class) Carpeta carpetaTest) throws OperacionInvalida {

		int random = (int) (Math.random() * GeneradorCarpeta.TAMAÑO);
		Correo hijo = carpetaTest.obtenerHijo(random);
		carpetaTest.eliminar(hijo);

		assertFalse(carpetaTest.explorar().contains(hijo));
	}

	// Comprobar: obtener hijo de carpeta con mensaje con PBT
	// Prueba a nivel de unidad
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void obtenerHijoCarpetaConMensajes(@From(GeneradorCarpeta.class) Carpeta carpeta) throws OperacionInvalida {

		int random = (int) (Math.random() * GeneradorCarpeta.TAMAÑO);
		Mensaje mensaje = new Mensaje(
				new Texto(GeneradorCarpeta.nombreMensajes, GeneradorCarpeta.contenidoMensajes + random));

		assertEquals(mensaje.obtenerVisualizacion(), carpeta.obtenerHijo(random).obtenerVisualizacion());

	}

}
