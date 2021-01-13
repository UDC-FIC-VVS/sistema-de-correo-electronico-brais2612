package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import GeneradoresPBT.GeneradorMensaje;

//Nivel de la prueba: Unidad
//Categoría: Funcional dinámica de caja negra 
//Mecanismo de seleccion de datos:   GeneradorMensaje.class && el propio StringGenerator.class de quickcheck

@RunWith(JUnitQuickcheck.class)
public class CabeceraPBT {

	// Comprobar: obtenerTamaño audio con PBT
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void cabeceraObtenerTamañoTest(@From(GeneradorMensaje.class) Mensaje mensajeTest,
			@From(StringGenerator.class) String nombreTest, @From(StringGenerator.class) String valorTest) {
		
		Cabecera cabeceraPrueba = new Cabecera(mensajeTest, nombreTest, valorTest);

		assertEquals(mensajeTest.obtenerTamaño() + nombreTest.length() + valorTest.length(), cabeceraPrueba.obtenerTamaño());

	}

}
