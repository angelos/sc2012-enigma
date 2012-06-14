package enigma;

import java.util.HashMap;
import java.util.Map;

public class Reflector extends EncodingComponent {
	private final Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
	
	public Reflector(String encoder) {
		for (int i = 0; i < encoder.length(); i++) {
			char current = encoder.charAt(i);
			int other = otherIndexOf(current, encoder, i);
			mapping.put(i, other);
		}
	}

	public int reflect(int input) {
		return mapping.get(input);
	}

	@Override
	protected int componentSize() {
		return mapping.size();
	}
}
