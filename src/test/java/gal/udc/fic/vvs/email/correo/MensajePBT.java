package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import GeneradoresPBT.GeneradorTexto;
import gal.udc.fic.vvs.email.archivo.Texto;

//Nivel de la prueba:  Unidad 
//Categoría: Funcional dinámica de caja negra 
//Mecanismo de seleccion de datos:   GeneradorTexto.class


@RunWith(JUnitQuickcheck.class)
public class MensajePBT {
	
	@Property
	public void obtenerTamaño(@From(GeneradorTexto.class) Texto textoTest) {
		
		Mensaje mensaje = new Mensaje(textoTest);

		assertEquals(textoTest.obtenerTamaño(), mensaje.obtenerTamaño());
	}

}
