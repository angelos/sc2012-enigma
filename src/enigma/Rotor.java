package enigma;

import java.util.HashMap;
import java.util.Map;

public class Rotor extends EncodingComponent {
	private final Map<String, String> left = new HashMap<String, String>();
	private final Map<String, String> right = new HashMap<String, String>();
	
	private int shift = 0;
	private final int notchPosition;

	public Rotor(String encoder, String notchPosition) {
		for (int i = 0; i < encoder.length(); i++) {
			left.put(letter(i), "" + encoder.charAt(i));
			right.put("" + encoder.charAt(i), letter(i));
		}
		this.notchPosition = ordinal(notchPosition);
	}
	
	public String left(String input) {
		int ordinal = ordinal(input);
		
		ordinal = inrange(ordinal + shift);
		String unshiftedLetter = left.get(letter(inrange(ordinal))); 
		return letter(inrange(ordinal(unshiftedLetter) - shift));
	}

	public String right(String input) {
		int ordinal = ordinal(input);
		
		ordinal = inrange(ordinal + shift);
		String unshiftedLetter = right.get(letter(inrange(ordinal))); 
		return letter(inrange(ordinal(unshiftedLetter) - shift));
	}
	
	public void shift() {
		shift = inrange(shift + 1);
	}

	public void set(String letter) {
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
