package enigma;

import java.util.HashMap;
import java.util.Map;

public class Reflector extends EncodingComponent {
	private final Map<String, String> mapping = new HashMap<String, String>();
	
	public Reflector(String encoder) {
		for (int i = 0; i < encoder.length(); i++) {
			String current = "" + encoder.charAt(i);
			int other = otherIndexOf(current, encoder, i);
			mapping.put(letter(i), letter(other));
			System.out.println("mapping " + letter(i) + " to " + letter(other));
		}
		
	}

	public String reflect(String input) {
		return mapping.get(input);
	}

	@Override
	protected int componentSize() {
		return mapping.size();
	}
}
