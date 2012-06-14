package enigma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Enigma {
	private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private final Reflector reflector;
	private final List<Rotor> rightwayRotors;
	private final List<Rotor> leftwayRotors;

	public Enigma(Reflector reflector, Rotor... rotors) {
		this.reflector = reflector;
		rightwayRotors = Arrays.asList(rotors);
		leftwayRotors = new ArrayList<Rotor>(rightwayRotors);
		Collections.reverse(leftwayRotors);
	}

	public String encode(String input) {
		StringBuilder sb = new StringBuilder();
		for (char c : input.toCharArray()) {
			sb.append(encode(c));
		}
		return sb.toString();
	}

	private char encode(char c) {
		shift();
		int val = ordinal(c);
		for (Rotor r : leftwayRotors) {
			val = r.left(val);
		}
		val = reflector.reflect(val);
		for (Rotor r : rightwayRotors) {
			val = r.right(val);
		}
		
		return letter(val);
	}

	private void shift() {
		shift(0);
	}

	private void shift(int rotorIndex) {
		if (rotorIndex > leftwayRotors.size() - 1) {
			return;
		}
		Rotor rotor = leftwayRotors.get(rotorIndex);
		if (rotor.notchInWindow()) {
			shift(rotorIndex + 1);
		}
		rotor.shift();
	}
	
	protected char letter(int index) {
		return ALPHABET.charAt(index);
	}
	
	protected int ordinal(char letter) {
		return ALPHABET.indexOf(letter);
	}


}
