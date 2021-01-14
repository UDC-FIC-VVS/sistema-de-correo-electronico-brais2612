package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

public class MensajeTest {

	private final String nombre = "Prueba";
	private final String contenido = "Pruebapruebapruebapruebapruebapruebapruebaprueba ";
	private final String previsualizacion = contenido.substring(0, Math.min(contenido.length(), 32)) + "...";
	private final String contenido2 = "Pruebapruebaprueba";
	private Texto textoTest = new Texto(nombre, contenido);

	// Comprobar: ObtenerNoLeidos
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void mensajeObtenerNoleidoTest() {

		Mensaje mensajeTest = new Mensaje(textoTest);

		assertEquals(1, mensajeTest.obtenerNoLeidos());
	}

	// Comprobar: obtenerTamaño
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void mensajeObtenerTamañoTest() {

		Mensaje mensajeTest = new Mensaje(textoTest);

		assertEquals(textoTest.obtenerTamaño(), mensajeTest.obtenerTamaño());

	}

	// Comprobar: obtenerIcono nuevo mensaje
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void mensajeObtenerIconoTest() {

		Mensaje mensajeTest = new Mensaje(textoTest);

		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensajeTest.obtenerIcono());
	}

	// Comprobar: obtenerPreVisualizacion
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void mensajeObtenerPreVisualTest() {

		Mensaje mensajeTest = new Mensaje(textoTest);

		assertEquals(previsualizacion, mensajeTest.obtenerPreVisualizacion());

	}

	// Comprobar: obtenerVisualizacion
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void mensajeObtenerVisualTest() {

		Mensaje mensajeTest = new Mensaje(textoTest);

		assertEquals(contenido, mensajeTest.obtenerVisualizacion());
	}

	// Comprobar: obtenerIcono mensaje
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerIconoLeidoTest() {

		Mensaje mensajeTest = new Mensaje(textoTest);

		mensajeTest.establecerLeido(true);

		assertEquals(Correo.ICONO_MENSAJE, mensajeTest.obtenerIcono());
	}

	// Comprobar: obtenerIcono nuevo mensaje no leido
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerIconoNoLeidoTest() {

		Mensaje mensajeTest = new Mensaje(textoTest);

		mensajeTest.establecerLeido(false);

		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensajeTest.obtenerIcono());
	}

	// Comprobar: buscar mensaje incompleto
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void buscarMensajeTrozoTest() {

		Mensaje mensajeTest = new Mensaje(textoTest);

		Collection expectedTest = new Vector();

		expectedTest.add(mensajeTest);

		assertEquals(expectedTest, mensajeTest.buscar(contenido2));
	}

	// Comprobar: buscar mensaje
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void buscarMensajeTest() {

		Mensaje mensajeTest = new Mensaje(textoTest);

		Collection expectedTest = new Vector();

		expectedTest.add(mensajeTest);

		assertEquals(expectedTest, mensajeTest.buscar(contenido));
	}

	// Comprobar: buscar mensaje sin contenido
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void buscarMensajeSinContenidoTest() {
		
		Mensaje mensajeTest = new Mensaje(textoTest);

		Collection expectedTest = new Vector();

		expectedTest.add(mensajeTest);

		assertEquals(expectedTest, mensajeTest.buscar(""));
	}
	
	
	// Comprobar: buscar mensaje con null, esperamos que salce excepción.
	// Categoría: Funcional dinámica de caja negra positiva

	@Test(expected = NullPointerException.class)
	public void buscarMensajeConNullTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);

		mensajeTest.buscar(null);
	}
	
	
	// Comprobar: obtenerRuta mensaje sin padre
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerRutaTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);

		assertEquals(mensajeTest.obtenerRuta(), mensajeTest.obtenerPreVisualizacion());
	}
	
	
	// Comprobar: obtenerRuta mensaje con padre
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerRutaConPadreTest() throws OperacionInvalida {
		Mensaje mensajeTest = new Mensaje(textoTest);

		Carpeta carpetaTest = new Carpeta("Padre");

		carpetaTest.añadir(mensajeTest);

		assertEquals(carpetaTest.obtenerPreVisualizacion() + " > " + mensajeTest.obtenerPreVisualizacion(),
				mensajeTest.obtenerRuta());
	}

	// Comprobar: obtenerPadre con null
	// Categoría: Funcional dinámica de caja negra positiva
	
	
	@Test
	public void obtenerPadreNullTest() {
		
		Mensaje mensajeTest = new Mensaje(textoTest);

		assertEquals(null, mensajeTest.obtenerPadre());
	}
	
	// Comprobar: obtenerPadre 
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void obtenerPadreTest() throws OperacionInvalida {
		
		Mensaje mensajeTest = new Mensaje(textoTest);	
		Carpeta carpetaTest = new Carpeta("CarpetaPadre");
		carpetaTest.añadir(mensajeTest);
		
		assertEquals(carpetaTest, mensajeTest.obtenerPadre());
	}
	
	
	// Comprobar: explorar lanza exceptcion
	// Categoría: Funcional dinámica de caja negra positiva

	@Test(expected = OperacionInvalida.class)
	public void explorarOpInvalidaTest() throws OperacionInvalida {
		Mensaje mensajeTest = new Mensaje(textoTest);
		mensajeTest.explorar();
	}

	// Comprobar: añadir lanza exceptcion
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test(expected = OperacionInvalida.class)
	public void añadirOpInvalidaTest() throws OperacionInvalida {
		Mensaje mensajeTest = new Mensaje(textoTest);
		mensajeTest.añadir(null);
	}

	// Comprobar: obtenerHijo lanza exceptcion
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoOpInvalidaTest() throws OperacionInvalida {
		Mensaje mensajeTest = new Mensaje(textoTest);
		mensajeTest.obtenerHijo(0);
	}

	// Comprobar: eliminar lanza exceptcion
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test(expected = OperacionInvalida.class)
	public void eliminarHijoOpInvalidaTest() throws OperacionInvalida {
		Mensaje mensajeTest = new Mensaje(textoTest);
		mensajeTest.eliminar(null);
		;
	}

}
