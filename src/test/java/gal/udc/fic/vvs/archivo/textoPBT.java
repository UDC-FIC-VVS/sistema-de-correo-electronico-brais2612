package gal.udc.fic.vvs.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import GeneradoresPBT.GeneradorString;
import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra 
//Mecanismo de seleccion de datos: GeneradorString.class

@RunWith(JUnitQuickcheck.class)
public class textoPBT {

	// Comprobar: obtenerNombre con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void textoGeneratedNamePBT(@From(GeneradorString.class) String nombre,
			@From(GeneradorString.class) String contenido) {

		Texto textoPrueba = new Texto(nombre, contenido);

		assertEquals(nombre, textoPrueba.obtenerNombre());

	}

	// Comprobar: obtenerContenido con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void textoGeneratedContentPBT(@From(GeneradorString.class) String nombre,
			@From(GeneradorString.class) String contenido) {

		Texto textoPrueba = new Texto(nombre, contenido);

		assertEquals(contenido, textoPrueba.obtenerContenido());

	}

	// Comprobar: obtenerTamaño con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void textoObtenerTamaño(@From(GeneradorString.class) String nombre,
			@From(GeneradorString.class) String contenido) {

		Texto textoPrueba = new Texto(nombre, contenido);

		assertEquals(contenido.length(), textoPrueba.obtenerTamaño());

	}

	// Comprobar: obtenerPreVisualizacion con PBT
	// Categoría: Funcional dinámica de caja negra positiva

	@Property
	public void textoObtenerPrevisualizacion(@From(GeneradorString.class) String nombre,
			@From(GeneradorString.class) String contenido) {

		Texto textoPrueba = new Texto(nombre, contenido);
		final String previsualizacion = nombre + "(" + contenido.length() + " bytes, text/plain)";

		assertEquals(previsualizacion, textoPrueba.obtenerPreVisualizacion());

	}
}
