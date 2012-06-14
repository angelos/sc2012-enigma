package enigma;

import java.util.HashMap;
import java.util.Map;

public class Reflector implements Encoder {
	private final Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
	
	public Reflector(String encoder) {
		for (int i = 0; i < encoder.length(); i++) {
			char current = encoder.charAt(i);
			int other = otherIndexOf(current, encoder, i);
			mapping.put(i, other);
		}
	}

	@Override
	public int encode(int in) {
		return mapping.get(in);
	}
	
	private int otherIndexOf(char character, String input, int notThisIndex) {
		int match = input.indexOf(character);
		if (match == notThisIndex) {
			match = input.indexOf(character, notThisIndex + 1);
		}
		return match;
	}

}
