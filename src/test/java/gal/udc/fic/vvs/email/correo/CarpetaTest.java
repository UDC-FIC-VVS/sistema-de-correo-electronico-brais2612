package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

import gal.udc.fic.vvs.email.archivo.Texto;


//Nivel de la prueba: Unidade
//Categoría: Funcional dinámica de caja negra
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

public class CarpetaTest {

	private final String nombre = "prueba";
	private final String nombre2 = "prueba2";
	private final String nombreTexto = "prueba";
	private final String contenido = "pruebapruebapruebapruebapruebapruebaprueba";
	private final int tamañoContenido = contenido.length();
	private final int numMensajes = 8;
	private final int numSubCarpetas = 6;

	private final Texto textoTest = new Texto(nombreTexto, contenido);

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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

	// Comprobar: ObtenerTamaño carpeta
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerTamaño() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);

		assertEquals(0, carpetaMensajes.obtenerTamaño());

	}

	// Comprobar: ObtenerNoLeidos
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerNoLeidos() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);

		assertEquals(0, carpetaMensajes.obtenerNoLeidos());

	}

	// Comprobar: obtenerVisualizacion
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerVisualizacion() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);

		assertEquals(nombre, carpetaMensajes.obtenerVisualizacion());

	}

	// Comprobar: obtenerPreVisualizacion
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerPreVisualizacion() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);

		assertEquals(nombre, carpetaMensajes.obtenerPreVisualizacion());

	}
	// Comprobar: obtenerIcono carpeta
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerIcono() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);

		assertEquals(Correo.ICONO_CARPETA, carpetaMensajes.obtenerIcono());

	}

	// Comprobar: buscar carpeta
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void buscar() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);

		assertEquals(new Vector(), carpetaMensajes.buscar(""));

	}

	// Comprobar: explorar carpeta
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void explorar() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);

		assertEquals(new Vector(), carpetaMensajes.explorar());
	}

	// Comprobar: explorar carpeta con mensajes
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void explorarConMensajes() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);
		Collection<Correo> hijos = collectionMensajes();

		for (Correo mensaje : hijos) {
			carpetaMensajes.añadir(mensaje);
		}

		assertEquals(hijos, carpetaMensajes.explorar());

	}

	// Comprobar: obtenerHijo carpeta y que devuelva esa excepcion si no hay
	// mensajes
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerHijo() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);

		thrown.expect(ArrayIndexOutOfBoundsException.class);

		carpetaMensajes.obtenerHijo(0);

	}

	// Comprobar: obtenerVisualizacion carpeta con mensajes
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerVisualizacionCarpetaConMensajes() throws OperacionInvalida {

		Carpeta carpetaMensajes = carpetaConMensajes();

		assertEquals(nombre + " (" + numMensajes + ")", carpetaMensajes.obtenerVisualizacion());
	}

	// Comprobar: obtenerPreVisualizacion carpeta con mensajes
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerPreVisualizacionCarpetaConMensajes() throws OperacionInvalida {

		Carpeta carpetaMensajes = carpetaConMensajes();

		assertEquals(nombre + " (" + numMensajes + ")", carpetaMensajes.obtenerPreVisualizacion());
	}

	// Comprobar: añadirMensaje a carpeta
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void añadirMensaje() throws OperacionInvalida {

		Carpeta carpetaMensajes = new Carpeta(nombre);
		Mensaje mensaje = new Mensaje(textoTest);

		carpetaMensajes.añadir(mensaje);

		assertEquals(mensaje, carpetaMensajes.obtenerHijo(0));
	}

	// Comprobar: buscar  mensaje en carpeta
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void buscarEnCarpetaConMensajes() throws OperacionInvalida {
		
		Carpeta carpetaMensajes = new Carpeta(nombre);

		Collection result = new Vector();


		Mensaje mensaje = new Mensaje(new Texto("Mensaje", "MensajeMensaje"));
		carpetaMensajes.añadir(mensaje);
		result.add(mensaje);

		assertEquals(result, carpetaMensajes.buscar("Mensaje"));


	}
	
	// Comprobar: añadirSubcarpetaVacia a carpeta
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void añadirSubcarpetaVaciaACarpeta() throws OperacionInvalida {
		
		Carpeta carpetaMensajes = new Carpeta(nombre);
		Carpeta subcarpeta = new Carpeta("subcarpeta");

		carpetaMensajes.añadir(subcarpeta);

		assertEquals(subcarpeta, carpetaMensajes.obtenerHijo(0));
	}
	
	// Comprobar: añadirSubcarpeta con mensaje a carpeta
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void añadirSubcarpetaConMensajeACarpeta() throws OperacionInvalida {
		
		Carpeta carpetaMensajes = new Carpeta(nombre);
		Carpeta subcarpeta = new Carpeta("subcarpeta");
		Mensaje mensaje = new Mensaje(textoTest);

		subcarpeta.añadir(mensaje);
		carpetaMensajes.añadir(subcarpeta);

		assertEquals(subcarpeta, carpetaMensajes.obtenerHijo(0));
	}

	// Comprobar: carpeta padre del mensaje, se cambia bien
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void cambiarMensajeCarpetaPadre () throws OperacionInvalida {
		
		Carpeta carpetaMensajes = new Carpeta(nombre);
		Carpeta Padre = new Carpeta(nombre);
		Mensaje mensajeTest = new Mensaje(textoTest);

		Padre.añadir(mensajeTest);
		
		carpetaMensajes.añadir(mensajeTest);

		assertEquals(carpetaMensajes, mensajeTest.obtenerPadre());
	}

}
