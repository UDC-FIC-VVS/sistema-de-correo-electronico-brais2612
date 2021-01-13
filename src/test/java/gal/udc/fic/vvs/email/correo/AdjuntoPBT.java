package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import GeneradoresPBT.GeneradorAudio;
import GeneradoresPBT.GeneradorImagen;
import GeneradoresPBT.GeneradorMensaje;
import GeneradoresPBT.GeneradorTexto;
import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Imagen;
import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba: Integración
//Categoría: Funcional dinámica de caja negra 
//Mecanismo de seleccion de datos:   GeneradorMensaje.class && GeneradorTexto.class 
//	                               && GeneradorAudio.class && GeneradorImagen.class

@RunWith(JUnitQuickcheck.class)
public class AdjuntoPBT {

	// Comprobar: obtenerTamaño texto con PBT
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void textoAdjuntoObtenerTamaño(@From(GeneradorMensaje.class) Mensaje mensaje,
			@From(GeneradorTexto.class) Texto texto) {
		
		Adjunto adjunto = new Adjunto(mensaje, texto);

		assertEquals(mensaje.obtenerTamaño() + texto.obtenerTamaño(), adjunto.obtenerTamaño());

	}
	
	// Comprobar: obtenerTamaño audio con PBT
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void audioAdjuntoObtenerTamaño(@From(GeneradorMensaje.class) Mensaje mensaje,
			@From(GeneradorAudio.class) Audio audio) {
		
		Adjunto adjunto = new Adjunto(mensaje, audio);

		assertEquals(mensaje.obtenerTamaño() + audio.obtenerTamaño(), adjunto.obtenerTamaño());
		
	}
	
	// Comprobar: obtenerTamaño imagen con PBT
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void imagenAdjuntoObtenerTamaño(@From(GeneradorMensaje.class) Mensaje mensaje,
			@From(GeneradorImagen.class) Imagen imagen) {
		
		Adjunto adjunto = new Adjunto(mensaje, imagen);
		
		assertEquals(mensaje.obtenerTamaño() + imagen.obtenerTamaño(), adjunto.obtenerTamaño());
		
	}
}
