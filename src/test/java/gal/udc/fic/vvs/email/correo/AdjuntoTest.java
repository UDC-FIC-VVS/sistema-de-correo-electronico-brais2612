package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Imagen;
import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra
//Mecanismo de seleccion de datos: String/int random que se me ha ocurrido.

public class AdjuntoTest {
	
	Texto textoTest = new Texto("Texto", "textomensajetextomensajetextomensajetextomensaje");
	Mensaje mensajeTest =  new Mensaje(new Texto ("textomensaje","textomensajetextomensajetextomensaje"));
	Imagen imagenTest = new Imagen("Imagen", "newImagen(\fdgh,457@#~¬~€{{|#~|@#€ \"=%\");)");
	Audio audioTest = new Audio("Audio", "pomporompompompompooompororoooopomm");
	
	// Comprobar: obtenerTamaño de texto adjunto
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void textoAdjuntoObtenerTamaño() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, textoTest);

		assertEquals(mensajeTest.obtenerTamaño()+textoTest.obtenerTamaño(), adjuntoTest.obtenerTamaño());
	}
	
	// Comprobar: obtenerVisualizacion de texto
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void textoAdjuntoObtenerVisual() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, textoTest);

		assertEquals(mensajeTest.obtenerVisualizacion() + "\n\nAdxunto: " + textoTest.obtenerPreVisualizacion(),
				adjuntoTest.obtenerVisualizacion());
	}
	// Comprobar: obtenerTamaño de imagen adjunta
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void imagenAdjuntoObtenerTamaño() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, imagenTest);

		assertEquals(mensajeTest.obtenerTamaño()+imagenTest.obtenerTamaño(), adjuntoTest.obtenerTamaño());
	}
	
	// Comprobar: obtenerVisualizacion de immagen adjunta
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void imagenAdjuntoObtenerVisual() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, imagenTest);

		assertEquals(mensajeTest.obtenerVisualizacion() + "\n\nAdxunto: " + imagenTest.obtenerPreVisualizacion(),
				adjuntoTest.obtenerVisualizacion());
	}
	
	// Comprobar: obtenerTamaño de audio adjunto
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void audioAdjuntoObtenerTamaño() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, audioTest);

		assertEquals(mensajeTest.obtenerTamaño()+audioTest.obtenerTamaño(), adjuntoTest.obtenerTamaño());
	}
	
	// Comprobar: obtenerVisualizacion de audio adjunto
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void audioAdjuntoObtenerVisual() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, audioTest);

		assertEquals(mensajeTest.obtenerVisualizacion() + "\n\nAdxunto: " + audioTest.obtenerPreVisualizacion(),
				adjuntoTest.obtenerVisualizacion());
	}
	
	// Comprobar: obtenerPreVisualizacion de un mensaje adjunto
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void mensajeAdjuntoObtenerPreVisualizacion () {
		Adjunto adjunto = new Adjunto(mensajeTest, textoTest);
		
		assertEquals(mensajeTest.obtenerPreVisualizacion(),
				adjunto.obtenerPreVisualizacion());
	}
	
	// Comprobar: obtener tamaño con mensaje null no debe funcionar
	// Categoría: Funcional dinámica de caja negra positiva
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void expectedNullPointerExceptionMensajeNull() {
		Adjunto adjuntoTest = new Adjunto(null, textoTest);
		thrown.expect(NullPointerException.class);
		adjuntoTest.obtenerTamaño();
	}
	
	// Comprobar: obtener tamaño con texto del mensaje null no debe funcionar.
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Test
	public void expectedNullPointerExceptionArchivoNull() {
		Adjunto adjuntoTest = new Adjunto(mensajeTest, null);
		thrown.expect(NullPointerException.class);
		adjuntoTest.obtenerTamaño();
	}

}
