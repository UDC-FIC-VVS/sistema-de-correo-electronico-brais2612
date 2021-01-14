package GeneradoresPBT;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Audio;

public class GeneradorAudio extends Generator<Audio> {
	
	public GeneradorAudio() {
		super(Audio.class);
	}
	
	private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = ".-\\;:_@[]^/|}{";
    private static final String ALL_MY_CHARS = LOWERCASE_CHARS
            + UPPERCASE_CHARS + NUMBERS + SPECIAL_CHARS;
    public static final int CAPACITY = (int) (Math.random() * (1000 - 1)) + 1;

	@Override
	public Audio generate(SourceOfRandomness random, GenerationStatus status) {
		StringBuilder nombreGen = new StringBuilder(CAPACITY);
		StringBuilder contenidoGen = new StringBuilder(CAPACITY);

        for (int i = 0; i < CAPACITY; i++) {
            int randomIndex = random.nextInt(ALL_MY_CHARS.length());
            nombreGen.append(ALL_MY_CHARS.charAt(randomIndex));
            contenidoGen.append(ALL_MY_CHARS.charAt(randomIndex));
        }
		
		return new Audio(nombreGen.toString(), contenidoGen.toString());
	}

}
