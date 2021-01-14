package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Vector;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import GeneradoresPBT.GeneradorCarpetaLimitada;
import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba: Integracion 
//Categoría: Funcional dinámica de caja negra 
//Mecanismo de seleccion de datos:   GeneradorMensaje.class y GeneradorCarpetaLimitada.class

@RunWith(JUnitQuickcheck.class)
public class CarpetaLimitadaPBT {

	// Comprobar: obtenerTamañoMensaje con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void obtenerTamañoMensaje(@From(GeneradorCarpetaLimitada.class) CarpetaLimitada carpetaLimitada)
			throws OperacionInvalida {

		assertTrue(carpetaLimitada.obtenerTamaño() > 0);
	}

	// Comprobar: establecer mensaje como no leido con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void establecerComoNoLeido(@From(GeneradorCarpetaLimitada.class) CarpetaLimitada carpetaLimitada)
			throws OperacionInvalida {

		carpetaLimitada.establecerLeido(false);

		assertEquals(GeneradorCarpetaLimitada.TAMAÑO, carpetaLimitada.obtenerNoLeidos());
	}

	// Comprobar: establecer mensaje como leido con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void establecerComoLeido(@From(GeneradorCarpetaLimitada.class) CarpetaLimitada carpetaLimitada)
			throws OperacionInvalida {

		carpetaLimitada.establecerLeido(true);

		assertEquals(0, carpetaLimitada.obtenerNoLeidos());
	}

	// Comprobar: obtener hijo carpeta limitada con mensaje, con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void obtenerHijoCarpetaLimitadaConMensaje(
			@From(GeneradorCarpetaLimitada.class) CarpetaLimitada carpetaLimitada) throws OperacionInvalida {

		int random = (int) (Math.random() * GeneradorCarpetaLimitada.TAMAÑO);
		Mensaje mensaje = new Mensaje(
				new Texto(GeneradorCarpetaLimitada.nombreMensaje, GeneradorCarpetaLimitada.contenidoMensaje + random));

		assertEquals(mensaje.obtenerVisualizacion(), carpetaLimitada.obtenerHijo(random).obtenerVisualizacion());

	}

	// Comprobar: eliminar mensaje de carpeta limitada, con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void eliminarMensajeDeCarpetaLimitada(@From(GeneradorCarpetaLimitada.class) CarpetaLimitada carpetaLimitada)
			throws OperacionInvalida {

		int random = (int) (Math.random() * GeneradorCarpetaLimitada.TAMAÑO);
		Correo hijo = carpetaLimitada.obtenerHijo(random);
		carpetaLimitada.eliminar(hijo);

		assertFalse(carpetaLimitada.explorar().contains(hijo));
	}

	// Comprobar: buscar mensaje de carpeta limitada, con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void buscar(@From(GeneradorCarpetaLimitada.class) CarpetaLimitada carpetaLimitada) {

		assertEquals(carpetaLimitada.obtenerNoLeidos(), GeneradorCarpetaLimitada.TAMAÑO);

		Collection result = carpetaLimitada.buscar("Mensaje");

		assertEquals(result.size(), carpetaLimitada.obtenerNoLeidos());
	}

	// Comprobar: buscar en carpeta llena con tamaño menor que el maximo ,con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void buscarCarpetaLlena(@From(GeneradorCarpetaLimitada.class) CarpetaLimitada carpetaLimitada)
			throws OperacionInvalida {

		Collection result = new Vector();

		for (int i = 1; i <= GeneradorCarpetaLimitada.TAMAÑO; i++) {
			Mensaje mensaje = new Mensaje(new Texto("Texto " + i, "TextoTextoTexto" + i));
			result.add(mensaje);
			carpetaLimitada.añadir(mensaje);
		}

		assertEquals(result, carpetaLimitada.buscar("Texto"));
		assertEquals(result.size(), carpetaLimitada.buscar("Texto").size());

	}

	// Comprobar: buscar en carpeta llena con tamaño siendo el maximo, con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void buscarConTamañoMenorQueMaxTest(
			@From(GeneradorCarpetaLimitada.class) CarpetaLimitada carpetaLimitada) throws OperacionInvalida {
	
		Collection result = new Vector();

		for (int i = 1; i < GeneradorCarpetaLimitada.TAMAÑO; i++) {
			Mensaje mensaje = new Mensaje(new Texto("Texto " + i, "TextoTextoTexto" + i));
			result.add(mensaje);
			carpetaLimitada.añadir(mensaje);
		}

		assertEquals(result, carpetaLimitada.buscar("Texto"));
		assertEquals(result.size(), carpetaLimitada.buscar("Texto").size());
	}

	
	// Comprobar: buscar en carpeta llena con los tamaños más que el máx, con PBT
	// Categoría: Funcional dinámica de caja negra negativo
	// BuG: Debería fallar ya que pasa el máximo.


	@Property
	public void buscarEnCarpetaLimitadaFueraDeLimites(@From(GeneradorCarpetaLimitada.class) CarpetaLimitada carpetaLimitada)
			throws OperacionInvalida {
		assertEquals(carpetaLimitada.obtenerNoLeidos(), GeneradorCarpetaLimitada.TAMAÑO);

		carpetaLimitada.añadir(new Mensaje(new Texto("Mensaje", "MensajeMensajeMensajeMensaje")));
		carpetaLimitada.añadir(new Mensaje(new Texto("Mensaje", "MensajeMensajeMensajeMensaje")));
		carpetaLimitada.añadir(new Mensaje(new Texto("Mensaje", "MensajeMensajeMensajeMensaje")));

		Collection result = carpetaLimitada.buscar("Mensaje");

		assertTrue(result.size() > GeneradorCarpetaLimitada.TAMAÑO);
	}

}
