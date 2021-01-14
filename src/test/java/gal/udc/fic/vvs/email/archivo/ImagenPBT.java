package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import GeneradoresPBT.GeneradorString;
import gal.udc.fic.vvs.email.archivo.Imagen;

//Nivel de la prueba:Unidade
//Categoría: Funcional dinámica de caja negra 
//Mecanismo de seleccion de datos: GeneradorString.class

@RunWith(JUnitQuickcheck.class)
public class ImagenPBT {

	
	// Comprobar: obtenerNombre con PBT
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void obtenerNombre(@From(GeneradorString.class) String nombre,
			@From(GeneradorString.class) String contenido) {

		Imagen imagenPrueba = new Imagen(nombre, contenido);

		assertEquals(nombre, imagenPrueba.obtenerNombre());

	}

		
	// Comprobar: obtenerContenido con PBT
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void obtenerContenido(@From(GeneradorString.class) String nombre,
			@From(GeneradorString.class) String contenido) {

		Imagen imagenPrueba = new Imagen(nombre, contenido);

		assertEquals(contenido, imagenPrueba.obtenerContenido());

	}

	// Comprobar: obtenerTamaño con PBT
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void obtenerTamaño(@From(GeneradorString.class) String nombre,
			@From(GeneradorString.class) String contenido) {

		Imagen imagenPrueba = new Imagen(nombre, contenido);

		assertEquals(contenido.length(), imagenPrueba.obtenerTamaño());

	}

	// Comprobar: obtenerPreVisualizacion con PBT
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void obtenerPreVisualizacion(@From(GeneradorString.class) String nombre,
			@From(GeneradorString.class) String contenido) {

		Imagen imagenPrueba = new Imagen(nombre, contenido);
		final String previsualizacion = nombre + "(" + contenido.length() + " bytes, image/png)";

		assertEquals(previsualizacion, imagenPrueba.obtenerPreVisualizacion());
	}
}
