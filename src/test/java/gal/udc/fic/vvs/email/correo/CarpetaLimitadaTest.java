package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

public class CarpetaLimitadaTest {

	private final String nombre = "prueba";
	private final String nombre2 = "prueba2";
	private final String nombreTexto = "prueba";
	private final String contenido = "pruebapruebapruebapruebapruebapruebaprueba";
	private final int tamañoContenido = contenido.length();
	private final int numMensajes = 8;
	private final int numSubCarpetas = 6;

	private final Texto textoTest = new Texto(nombreTexto, contenido);

	// Se hace para tener una carpeta con mensajes
	private Carpeta carpetaConMensajes() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);

		for (int i = 1; i <= numMensajes; i++) {
			Mensaje mensaje = new Mensaje(textoTest);
			carpetaMensajes.añadir(mensaje);
		}

		return carpetaMensajes;
	}

	// Preparamos un collection con los mensajes

	private Collection collectionMensajes() {

		Collection mensajes = new Vector();

		for (int i = 1; i <= numMensajes; i++) {
			Mensaje mensaje = new Mensaje(textoTest);
			mensajes.add(mensaje);
		}

		return mensajes;
	}

	// Comprobar: ObtenerIcono carpeta limitada
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerIcono() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);
		Mensaje mensaje = new Mensaje(new Texto("Prueba", "PruebaPruebaPrueba"));
		carpetaMensajes.añadir(mensaje);
		CarpetaLimitada carpetaLimitadaTest = new CarpetaLimitada(carpetaMensajes, tamañoContenido);

		assertEquals(Correo.ICONO_CARPETA, carpetaLimitadaTest.obtenerIcono());
	}

	// Comprobar: obtenerVisualizacionMensajes carpeta limitada
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerVisualizacionMensajes() throws OperacionInvalida {

		Carpeta carpetaMensajes = carpetaConMensajes();
		CarpetaLimitada carpetaLimitadaTest = new CarpetaLimitada(carpetaMensajes, tamañoContenido);

		assertEquals(nombre + " (" + numMensajes + ")", carpetaLimitadaTest.obtenerVisualizacion());
	}

	// Comprobar: obtenerPreVisualizacionMensajes carpeta limitada
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerPreVisualizacionMensajes() throws OperacionInvalida {

		Carpeta carpetaMensajes = carpetaConMensajes();
		CarpetaLimitada carpetaLimitadaTest = new CarpetaLimitada(carpetaMensajes, tamañoContenido);

		assertEquals(nombre + " (" + numMensajes + ")", carpetaLimitadaTest.obtenerPreVisualizacion());
	}

	// Comprobar: explorarCarpeta limitada ConMensajes
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void explorarCarpetaLimitadaConMensajes() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);
		CarpetaLimitada carpetaLimitadaTest = new CarpetaLimitada(carpetaMensajes, tamañoContenido);
		Collection<Correo> hijos = collectionMensajes();

		for (Correo mensaje : hijos) {
			carpetaLimitadaTest.añadir(mensaje);
		}

		assertEquals(hijos, carpetaLimitadaTest.explorar());

	}

	// Comprobar: buscar en Carpeta limitada ConMensajes
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void buscarEnCarpetaLimitadaConMensajes() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);
		Collection result = new Vector();
		Collection result2 = new Vector();

		Mensaje mensaje = new Mensaje(new Texto("1", "Mensaje1"));
		carpetaMensajes.añadir(mensaje);
		result.add(mensaje);

		Mensaje mensaje2 = new Mensaje(new Texto("2", "Mensaje2"));
		carpetaMensajes.añadir(mensaje2);
		result.add(mensaje2);
		result2.add(mensaje2);

		CarpetaLimitada carpetaLimitadaTest = new CarpetaLimitada(carpetaMensajes, tamañoContenido);

		assertEquals(result2, carpetaLimitadaTest.buscar("Mensaje2"));

	}

	// Comprobar: cambiar carpeta limitada del mensaje
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void cambiarPadreMensaje() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);
		Carpeta carpetaPadre = new Carpeta(nombre);
		CarpetaLimitada carpetaLimitadaTest = new CarpetaLimitada(carpetaMensajes, tamañoContenido);
		Mensaje mensajePrueba = new Mensaje(textoTest);

		carpetaPadre.añadir(mensajePrueba);
		carpetaLimitadaTest.añadir(mensajePrueba);

		assertEquals(carpetaMensajes, mensajePrueba.obtenerPadre());
	}

	// Comprobar: obtener ruta carpeta limitada sin padre
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerRutaCarpetaLimitadaSinPadre() {

		Carpeta carpetaMensajes = new Carpeta(nombre);
		CarpetaLimitada carpetaLimitadaTest = new CarpetaLimitada(carpetaMensajes, tamañoContenido);

		assertEquals(carpetaLimitadaTest.obtenerRuta(), carpetaLimitadaTest.obtenerPreVisualizacion());
	}

	// Comprobar: obtener ruta carpeta limitada con padre
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerRutaCarpetaLimitadaConnPadre() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);
		Carpeta carpetaPadre = new Carpeta(nombre);
		CarpetaLimitada carpetaLimitadaTest = new CarpetaLimitada(carpetaMensajes, tamañoContenido);

		carpetaPadre.añadir(carpetaLimitadaTest);

		assertEquals(carpetaPadre.obtenerPreVisualizacion() + " > " + carpetaLimitadaTest.obtenerPreVisualizacion(),
				carpetaLimitadaTest.obtenerRuta());
	}


}
