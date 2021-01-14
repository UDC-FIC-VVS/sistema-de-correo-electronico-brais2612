package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

public class ReenvioTest {

	Mensaje mensajeTest = new Mensaje(new Texto("prueba", "pruebapruebapruebapruebaprueba"));

	Mensaje mensajeReenviadoTest = new Mensaje(
			new Texto("pruebareenviada", "pruebareenviadapruebareenviadapruebareenviadapruebareenviada"));

	// Comprobar: eenvioObtenerTamaño
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void reenvioObtenerTamañoTest() {
		Reenvio reenvioTest = new Reenvio(mensajeTest, mensajeReenviadoTest);

		assertEquals(mensajeTest.obtenerTamaño() + mensajeReenviadoTest.obtenerTamaño(), reenvioTest.obtenerTamaño());

	}

	// Comprobar: reenvioObtenerVisual
	// Categoría: Funcional dinámica de caja negra positiva

	@Test
	public void reenvioObtenerVisualTest() {
		Reenvio reenvioTest = new Reenvio(mensajeTest, mensajeReenviadoTest);

		assertEquals(
				mensajeTest.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n"
						+ mensajeReenviadoTest.obtenerVisualizacion() + "\n---- Fin correo reenviado ----",
				reenvioTest.obtenerVisualizacion());

	}

	// Comprobar: Falla cuando reenviamos un mensaje con mensaje null
	// Categoría: Funcional dinámica de caja negra positiva

	@Test(expected = NullPointerException.class)
	public void mensajeIsNullExceptionTest() {
		Reenvio reenvioTest = new Reenvio(null, mensajeReenviadoTest);

		reenvioTest.obtenerTamaño();
	}

	// Comprobar: Que falla cuando  el mensaje reenviado es null
	// Categoría: Funcional dinámica de caja negra positiva

	@Test(expected = NullPointerException.class)
	public void correoIsNullExceptionTest() {
		Reenvio reenvioTest = new Reenvio(mensajeTest, null);

		reenvioTest.obtenerTamaño();
	}

}
