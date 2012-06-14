package enigma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static enigma.Alphabet.*;

public class Enigma {
	private final List<Rotor> rotors;
	private final List<Encoder> encoders;

	public Enigma(Reflector reflector, Rotor... rotors) {
		this.rotors = Arrays.asList(rotors);
		
		encoders = new ArrayList<Encoder>();
		ListIterator<Rotor> reverse = this.rotors.listIterator(this.rotors.size());
		while (reverse.hasPrevious()) {
			encoders.add(reverse.previous().left());
		}
		encoders.add(reflector);
		for (Rotor r : rotors) {
			encoders.add(r.right());
		}
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
		for (Encoder e : encoders) {
			val = e.encode(val);
		}
		return letter(val);
	}

	private void shift() {
		shift(rotors.size() - 1);
	}

	private void shift(int rotorIndex) {
		if (rotorIndex > rotors.size() - 1) {
			return;
		}
		Rotor rotor = rotors.get(rotorIndex);
		if (rotor.notchInWindow()) {
			shift(rotorIndex - 1);
		}
		rotor.shift();
	}
}
