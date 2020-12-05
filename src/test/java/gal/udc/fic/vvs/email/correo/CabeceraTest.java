package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Cabecera;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class CabeceraTest {

	private String nombreTest = "prueba";
	private String valorTest = "pruebaprueba";
	private Mensaje mensajeTest = new Mensaje(new Texto("prueba", "pruebapruebapruebaprueba"));
	private Carpeta carpetaTest = new Carpeta(nombreTest);

	@Test
	public void cabeceraGeneratedTamañoTest() {
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(mensajeTest.obtenerTamaño() + nombreTest.length() + valorTest.length(),
				cabeceraPrueba.obtenerTamaño());

	}

	@Test
	public void cabeceraGeneratedVisualTest() {
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(nombreTest + ": " + valorTest + "\n" + mensajeTest.obtenerVisualizacion(),
				cabeceraPrueba.obtenerVisualizacion());
	}

	@Test(expected = NullPointerException.class)
	public void cabeceraValorNullTest() {
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, null);

		cabeceraPrueba.obtenerTamaño();

	}

	@Test(expected = NullPointerException.class)
	public void cabeceraNombreNullTest() {
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, null, valorTest);

		cabeceraPrueba.obtenerTamaño();

	}

	@Test(expected = NullPointerException.class)
	public void cabeceraMensajeNullTest() {
		Cabecera cabeceraPrueba = new Cabecera(null, nombreTest, valorTest);

		cabeceraPrueba.obtenerTamaño();

	}

	@Test
	public void obtenerPreVisualizacionTest() {
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(cabeceraPrueba.obtenerPreVisualizacion(), mensajeTest.obtenerPreVisualizacion());

	}

	@Test
	public void buscarTest() {
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		Collection collectionTest = new Vector();
		collectionTest.add(cabeceraPrueba);

		Collection collectionObtained = cabeceraPrueba.buscar(nombreTest);
		assertEquals(collectionObtained, collectionTest);

	}

	@Test
	public void noLeidosTest() {
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(cabeceraPrueba.obtenerNoLeidos(), 1);
	}

	@Test
	public void leidoTest() {
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraPrueba.establecerLeido(true);

		assertEquals(cabeceraPrueba.obtenerNoLeidos(), 0);
	}

	@Test
	public void obtenerIconoMensajeNoLeidoTest() {
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(cabeceraPrueba.obtenerIcono(), Correo.ICONO_NUEVO_MENSAJE);

	}

	@Test
	public void obtenerIconoMensajeLeidoTest() {
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraPrueba.establecerLeido(true);

		assertEquals(cabeceraPrueba.obtenerIcono(), Correo.ICONO_MENSAJE);

	}

	@Test
	public void ObtenerRutaSinPadreTest() {
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(cabeceraPrueba.obtenerRuta(), mensajeTest.obtenerRuta());

	}

	@Test
	public void ObtenerRutaConPadreTest() {
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraPrueba.establecerPadre(carpetaTest);
		assertEquals(cabeceraPrueba.obtenerRuta(), mensajeTest.obtenerRuta());

	}

	@Test(expected = OperacionInvalida.class)
	public void explorarOperacionInvalidaExpectedTest() throws OperacionInvalida {
		Cabecera cabeceraDePrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraDePrueba.explorar();
	}

	@Test(expected = OperacionInvalida.class)
	public void añadirOperacionInvalidaExpectedTest() throws OperacionInvalida {
		Cabecera cabeceraDePrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraDePrueba.añadir(mensajeTest);
	}

	@Test(expected = OperacionInvalida.class)
	public void eliminarOperacionInvalidaExpectedTest() throws OperacionInvalida {
		Cabecera cabeceraDePrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraDePrueba.añadir(mensajeTest);
	}

	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoOperacionInvalidaExpectedTest() throws OperacionInvalida {
		Cabecera cabeceraDePrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraDePrueba.obtenerHijo(0);
	}

}
