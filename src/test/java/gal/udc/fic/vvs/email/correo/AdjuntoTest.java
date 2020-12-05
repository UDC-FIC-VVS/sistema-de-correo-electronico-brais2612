package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Imagen;
import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra , positiva
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

public class AdjuntoTest {
	
	Texto textoTest = new Texto("Texto", "textomensajetextomensajetextomensajetextomensaje");
	Mensaje mensajeTest =  new Mensaje(new Texto ("textomensaje","textomensajetextomensajetextomensaje"));
	Imagen imagenTest = new Imagen("Imagen", "newImagen(\fdgh,457@#~¬~€{{|#~|@#€ \"=%\");)");
	Audio audioTest = new Audio("Audio", "pomporompompompompooompororoooopomm");
	
	@Test
	public void textoAdjuntoObtenerTamañoTest() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, textoTest);

		assertEquals(mensajeTest.obtenerTamaño()+textoTest.obtenerTamaño(), adjuntoTest.obtenerTamaño());
	}
	
	@Test
	public void textoAdjuntoObtenerVisualTest() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, textoTest);

		assertEquals(mensajeTest.obtenerVisualizacion() + "\n\nAdxunto: " + textoTest.obtenerPreVisualizacion(),
				adjuntoTest.obtenerVisualizacion());
	}
	
	@Test
	public void imagenAdjuntoObtenerTamañoTest() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, imagenTest);

		assertEquals(mensajeTest.obtenerTamaño()+imagenTest.obtenerTamaño(), adjuntoTest.obtenerTamaño());
	}
	
	@Test
	public void imagenAdjuntoObtenerVisualTest() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, imagenTest);

		assertEquals(mensajeTest.obtenerVisualizacion() + "\n\nAdxunto: " + imagenTest.obtenerPreVisualizacion(),
				adjuntoTest.obtenerVisualizacion());
	}
	
	@Test
	public void audioAdjuntoObtenerTamañoTest() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, audioTest);

		assertEquals(mensajeTest.obtenerTamaño()+audioTest.obtenerTamaño(), adjuntoTest.obtenerTamaño());
	}
	
	@Test
	public void audioAdjuntoObtenerVisualTest() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, audioTest);

		assertEquals(mensajeTest.obtenerVisualizacion() + "\n\nAdxunto: " + audioTest.obtenerPreVisualizacion(),
				adjuntoTest.obtenerVisualizacion());
	}
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void expectedNullPointerExceptionMensajeNull() {
		Adjunto adjuntoTest = new Adjunto(null, textoTest);
		thrown.expect(NullPointerException.class);
		adjuntoTest.obtenerTamaño();
	}
	
	@Test
	public void expectedNullPointerExceptionArchivoNull() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, null);
		thrown.expect(NullPointerException.class);
		adjuntoTest.obtenerTamaño();
	}

}
