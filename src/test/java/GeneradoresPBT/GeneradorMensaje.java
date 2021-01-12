package GeneradoresPBT;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class GeneradorMensaje extends Generator<Mensaje>{

	public GeneradorMensaje() {
		super(Mensaje.class);
	}
	
	private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = ".-\\;:_@[]^/|}{";
    private static final String ALL_MY_CHARS = LOWERCASE_CHARS
            + UPPERCASE_CHARS + NUMBERS + SPECIAL_CHARS;
    public static final int CAPACITY = (int) Math.random() + 1;

	@Override
	public Mensaje generate(SourceOfRandomness random, GenerationStatus status) {
		StringBuilder nombre = new StringBuilder(CAPACITY);
		StringBuilder contenido = new StringBuilder(CAPACITY);

        for (int i = 0; i < CAPACITY; i++) {
            int randomIndex = random.nextInt(ALL_MY_CHARS.length());
            nombre.append(ALL_MY_CHARS.charAt(randomIndex));
            contenido.append(ALL_MY_CHARS.charAt(randomIndex));
        }
		
		return new Mensaje(new Texto(nombre.toString(), contenido.toString()));
	}
}
