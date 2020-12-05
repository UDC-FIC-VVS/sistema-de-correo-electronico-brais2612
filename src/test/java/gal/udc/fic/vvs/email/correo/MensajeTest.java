package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class MensajeTest {

	private final String nombre = "Prueba";
	private final String contenido = "Pruebapruebapruebapruebapruebapruebapruebaprueba ";
	private final String previsualizacion = contenido.substring(0, Math.min(contenido.length(), 32)) + "...";
	private final String contenido2 = "Pruebapruebaprueba";
	private Texto textoTest = new Texto(nombre, contenido);

	@Test
	public void mensajeObtenerNoleidoTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);

		assertEquals(1, mensajeTest.obtenerNoLeidos());
	}

	@Test
	public void mensajeObtenerTamañoTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);

		assertEquals(textoTest.obtenerTamaño(), mensajeTest.obtenerTamaño());

	}

	@Test
	public void mensajeObtenerIconoTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);

		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensajeTest.obtenerIcono());
	}

	@Test
	public void mensajeObtenerPreVisualTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);

		assertEquals(previsualizacion, mensajeTest.obtenerPreVisualizacion());

	}

	@Test
	public void mensajeObtenerVisualTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);

		assertEquals(contenido, mensajeTest.obtenerVisualizacion());
	}

	@Test
	public void obtenerIconoLeidoTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);

		mensajeTest.establecerLeido(true);

		assertEquals(Correo.ICONO_MENSAJE, mensajeTest.obtenerIcono());
	}

	@Test
	public void obtenerIconoNoLeidoTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);

		mensajeTest.establecerLeido(false);

		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensajeTest.obtenerIcono());
	}

	// BUG : EL TEST DEBERÍA FALLAR, EL MENSAJE ESTÁ INCOMPLETO
	@Test
	public void buscarMensajeTrozoTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);

		Collection expectedTest = new Vector();

		expectedTest.add(mensajeTest);

		assertEquals(expectedTest, mensajeTest.buscar(contenido2));
	}

	@Test
	public void buscarMensajeTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);

		Collection expectedTest = new Vector();

		expectedTest.add(mensajeTest);

		assertEquals(expectedTest, mensajeTest.buscar(contenido));
	}

	// BUG: NO HAY MENSAJE, DEBERÍA FALLAR
	@Test
	public void buscarMensajeSinContenidoTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);

		Collection expectedTest = new Vector();

		expectedTest.add(mensajeTest);

		assertEquals(expectedTest, mensajeTest.buscar(""));
	}

	@Test(expected = NullPointerException.class)
	public void buscarMensajeConNullTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);

		mensajeTest.buscar(null);
	}
	
	@Test
	public void obtenerRutaTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);
		
		assertEquals(mensajeTest.obtenerRuta(), mensajeTest.obtenerPreVisualizacion());
	}
	
	@Test
	public void obtenerRutaConPadreTest() throws OperacionInvalida {
		Mensaje mensajeTest = new Mensaje(textoTest);
		
		Carpeta carpetaTest = new Carpeta("Padre");
		
		carpetaTest.añadir(mensajeTest);
		
		assertEquals(carpetaTest.obtenerPreVisualizacion() + " > " + mensajeTest.obtenerPreVisualizacion(),
				mensajeTest.obtenerRuta());
	}
	
	@Test
	public void obtenerPadreNullTest() {
		Mensaje mensajeTest = new Mensaje(textoTest);
		
		assertEquals(null, mensajeTest.obtenerPadre());
	}
	
	@Test(expected = OperacionInvalida.class)
	public void explorarOpInvalidaTest() throws OperacionInvalida {
		Mensaje mensajeTest = new Mensaje(textoTest);	
		mensajeTest.explorar();
	}
	
	@Test(expected = OperacionInvalida.class)
	public void añadirOpInvalidaTest() throws OperacionInvalida {
		Mensaje mensajeTest = new Mensaje(textoTest);	
		mensajeTest.añadir(null);
	}
	
	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoOpInvalidaTest() throws OperacionInvalida {
		Mensaje mensajeTest = new Mensaje(textoTest);	
		mensajeTest.obtenerHijo(0);
	}
	
	@Test(expected = OperacionInvalida.class)
	public void eliminarHijoOpInvalidaTest() throws OperacionInvalida {
		Mensaje mensajeTest = new Mensaje(textoTest);	
		mensajeTest.eliminar(null);;
	}


}
