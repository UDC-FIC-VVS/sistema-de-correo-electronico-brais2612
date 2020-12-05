package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class ReenvioTest {
	
	Mensaje mensajeTest = new Mensaje(new Texto("prueba", "pruebapruebapruebapruebaprueba"));

	Mensaje mensajeReenviadoTest = new Mensaje(new Texto("pruebareenviada", "pruebareenviadapruebareenviadapruebareenviadapruebareenviada"));

	
	@Test
	public void reenvioObtenerTamañoTest() {
		Reenvio reenvioTest = new Reenvio(mensajeTest, mensajeReenviadoTest);

	     assertEquals(mensajeTest.obtenerTamaño() + mensajeReenviadoTest.obtenerTamaño(), reenvioTest.obtenerTamaño());
				
	}
	
	@Test
	public void reenvioObtenerVisualTest() {
		Reenvio reenvioTest = new Reenvio(mensajeTest, mensajeReenviadoTest);

		assertEquals(mensajeTest.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n"
				+ mensajeReenviadoTest.obtenerVisualizacion()+ "\n---- Fin correo reenviado ----",
				reenvioTest.obtenerVisualizacion());
				
	}
	
	@Test(expected = NullPointerException.class)
	public void mensajeIsNullExceptionTest() {
		Reenvio reenvioTest = new Reenvio(null, mensajeReenviadoTest);
				
		reenvioTest.obtenerTamaño();
	}
	
	@Test(expected = NullPointerException.class)
	public void correoIsNullExceptionTest() {
		Reenvio reenvioTest = new Reenvio(mensajeTest,null);
				
		reenvioTest.obtenerTamaño();
	}
	
	
}
