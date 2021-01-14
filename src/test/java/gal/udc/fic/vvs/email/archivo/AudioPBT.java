package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import GeneradoresPBT.GeneradorString;
import gal.udc.fic.vvs.email.archivo.Audio;

//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra
//Mecanismo de seleccion de datos: GeneradorString.class

@RunWith(JUnitQuickcheck.class)
public class AudioPBT {

	// COmprobar: obtenerNombre con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void obtenerNombre(@From(GeneradorString.class) String nombre,
			@From(GeneradorString.class) String contenido) {

		Audio audioPrueba = new Audio(nombre, contenido);

		assertEquals(nombre, audioPrueba.obtenerNombre());
	}

	// COmprobar: obtenerContenido con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void obtenerContenido(@From(GeneradorString.class) String nombre,
			@From(GeneradorString.class) String contenido) {

		Audio audioPrueba = new Audio(nombre, contenido);

		assertEquals(contenido, audioPrueba.obtenerContenido());
	}

	// COmprobar: obtenerTamaño con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void obtenerTamaño(@From(GeneradorString.class) String nombre,
			@From(GeneradorString.class) String contenido) {

		Audio audioPrueba = new Audio(nombre, contenido);

		assertEquals(contenido.length(), audioPrueba.obtenerTamaño());

	}

	// Comprobar: obtenerPreVisualizacion con PBT
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void obtenerPreVisualizacion(@From(GeneradorString.class) String nombre,
			@From(GeneradorString.class) String contenido) {

		Audio audioPrueba = new Audio(nombre, contenido);
		final String previsualizacion = nombre + "(" + contenido.length() + " bytes, audio/ogg)";

		assertEquals(previsualizacion, audioPrueba.obtenerPreVisualizacion());
	}
}
