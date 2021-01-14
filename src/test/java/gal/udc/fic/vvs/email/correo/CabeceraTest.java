package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

public class CabeceraTest {

	private String nombreTest = "prueba";
	private String valorTest = "pruebaprueba";
	private Mensaje mensajeTest = new Mensaje(new Texto("prueba", "pruebapruebapruebaprueba"));
	private Carpeta carpetaTest = new Carpeta(nombreTest);

	// Comprobar: obtenerTamaño cabecera
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void cabeceraGeneratedTamañoTest() {

		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(mensajeTest.obtenerTamaño() + nombreTest.length() + valorTest.length(),
				cabeceraPrueba.obtenerTamaño());

	}

	// Comprobar: obtenerVisualizacion cabecera
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void cabeceraGeneratedVisualTest() {

		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(nombreTest + ": " + valorTest + "\n" + mensajeTest.obtenerVisualizacion(),
				cabeceraPrueba.obtenerVisualizacion());
	}

	// Comprobar: obtenerTamaño con valor null, no deberia funcionar.
	// Categoría: Funcional dinámica de caja negra positiva

	@Test(expected = NullPointerException.class)
	public void cabeceraValorNullTest() {

		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, null);

		cabeceraPrueba.obtenerTamaño();

	}

	// Comprobar: obtenerTamaño con nombre null, no deberia funcionar.
	// Categoría: Funcional dinámica de caja negra positiva

	@Test(expected = NullPointerException.class)
	public void cabeceraNombreNullTest() {

		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, null, valorTest);

		cabeceraPrueba.obtenerTamaño();

	}

	// Comprobar: obtenerTamaño con mensaje null, no deberia funcionar.
	// Categoría: Funcional dinámica de caja negra positiva

	@Test(expected = NullPointerException.class)
	public void cabeceraMensajeNullTest() {

		Cabecera cabeceraPrueba = new Cabecera(null, nombreTest, valorTest);

		cabeceraPrueba.obtenerTamaño();

	}

	// Comprobar: obtenerPreVisualizacion de cabecera con nombre y valor null.
	// Categoría: Funcional dinámica de caja negra negativa.
	//Bug: Debería generar un error.


	public void cabeceraNombreYValorNullTest() {

		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, "", "");

		assertEquals("" + ": " + "" + "\n" + mensajeTest.obtenerVisualizacion(),
				cabeceraPrueba.obtenerVisualizacion());
	}

	// Comprobar: obtenerPreVisualizacion del mensaje.
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerPreVisualizacionTest() {

		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(cabeceraPrueba.obtenerPreVisualizacion(), mensajeTest.obtenerPreVisualizacion());

	}

	// Comprobar: buscarTest
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void buscarTest() {

		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		Collection collectionTest = new Vector();
		collectionTest.add(cabeceraPrueba);

		Collection collectionObtained = cabeceraPrueba.buscar(nombreTest);
		assertEquals(collectionObtained, collectionTest);

	}

	// Comprobar: obtenerNoLeidos
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void noLeidosTest() {

		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(cabeceraPrueba.obtenerNoLeidos(), 1);
	}

	// Comprobar: obtenerNoLeidos con leido a true.
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void leidoTest() {

		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraPrueba.establecerLeido(true);

		assertEquals(cabeceraPrueba.obtenerNoLeidos(), 0);
	}

	// Comprobar: obtenerIconoMensajeNoLeido
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerIconoMensajeNoLeidoTest() {

		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(cabeceraPrueba.obtenerIcono(), Correo.ICONO_NUEVO_MENSAJE);

	}

	// Comprobar: obtenerIconoMensajeLeido
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void obtenerIconoMensajeLeidoTest() {

		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraPrueba.establecerLeido(true);

		assertEquals(cabeceraPrueba.obtenerIcono(), Correo.ICONO_MENSAJE);

	}

	// Comprobar: ObtenerRutaSinPadre
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void ObtenerRutaSinPadreTest() {

		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(cabeceraPrueba.obtenerRuta(), mensajeTest.obtenerRuta());

	}

	// Comprobar: ObtenerRutaConPadre
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void ObtenerRutaConPadreTest() {

		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraPrueba.establecerPadre(carpetaTest);

		assertEquals(cabeceraPrueba.obtenerRuta(), mensajeTest.obtenerRuta());

	}
	
	// Comprobar: ObtenerPadre
		// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void obtenerPadre() {
		
		Cabecera cabeceraDePrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraDePrueba.establecerPadre(carpetaTest);
		
		assertEquals(carpetaTest, cabeceraDePrueba.obtenerPadre());
	}
	
	// Comprobar: ObtenerPadre sin carpeta padre(null), se espera que devuelva null
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void obtenerPadreConPadreNull() {
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(null, cabeceraPrueba.obtenerPadre());
	}
	

	// Comprobar: explorarOperacionInvalida en la cabecera
	// Categoría: Funcional dinámica de caja negra positiva

	@Test(expected = OperacionInvalida.class)
	public void explorarOperacionInvalidaExpectedTest() throws OperacionInvalida {

		Cabecera cabeceraDePrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraDePrueba.explorar();
	}

	// Comprobar: añadirOperacionInvalida en la cabecera
	// Categoría: Funcional dinámica de caja negra positiva

	@Test(expected = OperacionInvalida.class)
	public void añadirOperacionInvalidaExpectedTest() throws OperacionInvalida {

		Cabecera cabeceraDePrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraDePrueba.añadir(mensajeTest);
	}

	// Comprobar: eliminarOperacionInvalida en la cabecera
	// Categoría: Funcional dinámica de caja negra positiva

	@Test(expected = OperacionInvalida.class)
	public void eliminarOperacionInvalidaExpectedTest() throws OperacionInvalida {

		Cabecera cabeceraDePrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraDePrueba.añadir(mensajeTest);
	}

	// Comprobar: obtenerHijoOperacionInvalida en la cabecera
	// Categoría: Funcional dinámica de caja negra positiva

	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoOperacionInvalidaExpectedTest() throws OperacionInvalida {

		Cabecera cabeceraDePrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		cabeceraDePrueba.obtenerHijo(0);
	}

}
