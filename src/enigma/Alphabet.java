package enigma;

public class Alphabet {
	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static char letter(int index) {
		return ALPHABET.charAt(index);
	}
	
	public static int ordinal(char letter) {
		return ALPHABET.indexOf(letter);
	}
}
