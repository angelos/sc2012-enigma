package enigma;

public abstract class EncodingComponent {
	private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	protected String letter(int index) {
		return "" + ALPHABET.charAt(index);
	}
	
	protected int ordinal(String letter) {
		return ALPHABET.indexOf(letter);
	}

	protected int otherIndexOf(String character, String input, int notThisIndex) {
		int match = input.indexOf(character);
		if (match == notThisIndex) {
			match = input.indexOf(character, notThisIndex + 1);
		}
		return match;
	}
	
	protected int inrange(int input) {
		return input % componentSize();
	}
	
	protected abstract int componentSize();

}
