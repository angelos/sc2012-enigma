package enigma;

import static enigma.Alphabet.ordinal;

import java.util.HashMap;
import java.util.Map;

public class Rotor {
	private final Map<Integer, Integer> left = new HashMap<Integer, Integer>();
	private final Map<Integer, Integer> right = new HashMap<Integer, Integer>();
	
	private int shift = 0;
	private final int notchPosition;

	public Rotor(String encoder, char notchPosition) {
		for (int i = 0; i < encoder.length(); i++) {
			left.put(i, ordinal(encoder.charAt(i)));
			right.put(ordinal(encoder.charAt(i)), i);
		}
		this.notchPosition = ordinal(notchPosition);
	}
	
	public Encoder left() {
		return new RotorEncoder(left);
	}
	
	public Encoder right() {
		return new RotorEncoder(right);
	}
	
	public void shift() {
		shift = inrange(shift + 1);
	}

	public void set(char letter) {
		shift = ordinal(letter);
	}
	
	protected int componentSize() {
		return left.size();
	}

	public boolean notchInWindow() {
		return shift == notchPosition;
	}
	
	private int inrange(int input) {
		int result = input % componentSize();
		if (result < 0) {
			result += componentSize();
		}
		return result;
	}

	private class RotorEncoder implements Encoder {
		private final Map<Integer, Integer> encodings;

		public RotorEncoder(Map<Integer, Integer> encodings) {
			this.encodings = encodings;
		}

		@Override
		public int encode(int in) {
			int shifted = inrange(in + shift);
			return inrange(encodings.get(shifted) - shift);
		}
	}
}
