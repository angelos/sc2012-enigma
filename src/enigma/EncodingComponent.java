package enigma;

public abstract class EncodingComponent {
	private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	protected String letter(int index) {
		return "" + ALPHABET.charAt(index);
	}
	
	protected int ordinal(char letter) {
		return ALPHABET.indexOf(letter);
	}

	protected int otherIndexOf(char character, String input, int notThisIndex) {
		int match = input.indexOf(character);
		if (match == notThisIndex) {
			match = input.indexOf(character, notThisIndex + 1);
		}
		return match;
	}
	
	protected int inrange(int input) {
		int result = input % componentSize();
		if (result < 0) {
			result += componentSize();
		}
		return result;
	}
	
	protected abstract int componentSize();

}
