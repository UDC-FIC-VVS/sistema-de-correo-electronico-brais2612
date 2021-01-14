package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import GeneradoresPBT.GeneradorMensaje;

//Nivel de la prueba: Unidad
//Categoría: Funcional dinámica de caja negra 
//Mecanismo de seleccion de datos:   GeneradorMensaje.class

@RunWith(JUnitQuickcheck.class)
public class ReenvioPBT {
	
	// Comprobar:obtener tamaño de reenvio con PBT
	// Categoría: Funcional dinámica de caja negra positiva
	
	@Property
	public void reenvioObtenerTamañoTest(@From(GeneradorMensaje.class) Mensaje mensajeTest,
			@From(GeneradorMensaje.class) Mensaje mensajeReenviadoTest) {
		Reenvio reenvioTest = new Reenvio(mensajeTest, mensajeReenviadoTest);

		assertEquals(mensajeTest.obtenerTamaño() + mensajeReenviadoTest.obtenerTamaño(), reenvioTest.obtenerTamaño());
	}

}
