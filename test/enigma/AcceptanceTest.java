package enigma;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AcceptanceTest {
	
	private Enigma enigma;
	
	@Before
	public void setup() {
		Rotor r1 = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q');
		r1.set('M');
		Rotor r2 = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E');
		r2.set('C');
		Rotor r3 = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V');
		r3.set('K');
		Reflector reflector = new Reflector("ABCDEFGDIJKGMKMIEBFTCVVJAT");
		enigma = new Enigma(reflector, r1, r2, r3);
	}

	@Test
	public void setupMCKShouldEncodeEtoQ() {
		assertEquals("Q", enigma.encode("E"));
	}
	
	@Test
	public void testQMJIDOMZWZJFJR() {
		// This ciphertext is part of the main assignment
		assertEquals("ENIGMAREVEALED", enigma.encode("QMJIDOMZWZJFJR"));
	}
}
