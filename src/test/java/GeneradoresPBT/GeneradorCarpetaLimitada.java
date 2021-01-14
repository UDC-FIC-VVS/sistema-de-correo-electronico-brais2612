package GeneradoresPBT;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.CarpetaLimitada;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

public class GeneradorCarpetaLimitada extends Generator<CarpetaLimitada> {

	public static final int TAMAÑO = (int) (Math.random() * (1000 - 1)) + 1;
	public static final String nombreMensaje = "Mensaje";
	public static final String contenidoMensaje = "Mensaje de prueba ";

	public GeneradorCarpetaLimitada() {
			super(CarpetaLimitada.class);
		}

	@Override
	public CarpetaLimitada generate(SourceOfRandomness random, GenerationStatus status) {
		Carpeta carpeta = new Carpeta("Carpeta de prueba");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, TAMAÑO);
		for (int i = 0; i < TAMAÑO; i++) {
			try {
				carpeta.añadir(new Mensaje(new Texto(nombreMensaje, contenidoMensaje + i)));
			} catch (OperacionInvalida e) {
			}
		}
		return carpetaLimitada;
	}
}
