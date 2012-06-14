package enigma;

import java.util.HashMap;
import java.util.Map;

public class Rotor extends EncodingComponent {
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
	
	public int left(int input) {
		int shifted = inrange(input + shift);
		return inrange(left.get(shifted) - shift);
	}

	public int right(int input) {
		int shifted = inrange(input + shift);
		return inrange(right.get(shifted) - shift);
	}
	
	public void shift() {
		shift = inrange(shift + 1);
	}

	public void set(char letter) {
		shift = ordinal(letter);
	}
	
	@Override
	protected int componentSize() {
		return left.size();
	}

	public boolean notchInWindow() {
		return shift == notchPosition;
	}

}
