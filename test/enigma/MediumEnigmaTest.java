package enigma;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*
 * Reflector   Rotor Rotor  Input
 *   A         A D   A D     A
 *   B         B C   B C     B
 *   A        >C B  >C B     C
 *   B         D A   D A     D
 */
public class MediumEnigmaTest {
	private Rotor rotor1;
	private Rotor rotor2;
	private Reflector reflector;
	
	@Before
	public void setup() {
		rotor1 = new Rotor("DCAB", 'C');
		rotor2 = new Rotor("DCAB", 'C');
		reflector = new Reflector("ABAB");
	}

	@Test
	public void encodesAToC() {
		assertEquals(2, encode(0));
	}

	@Test
	public void assembledEnigmaEncodesAToD() {
		Enigma enigma = new Enigma(reflector, rotor1, rotor2);
		assertEquals("D", enigma.encode("A"));
	}

	@Test
	public void assembledEnigmaEncodesAToDC() {
		Enigma enigma = new Enigma(reflector, rotor1, rotor2);
		assertEquals("D", enigma.encode("A"));
		assertEquals("C", enigma.encode("A"));
	}

	@Test
	public void assembledEnigmaEncodesAToDCC() {
		Enigma enigma = new Enigma(reflector, rotor1, rotor2);
		assertEquals("D", enigma.encode("A"));
		assertEquals("C", enigma.encode("A"));
		assertEquals("C", enigma.encode("A"));
	}

	private int encode(int input) {
		int val = input;
		val = rotor2.left().encode(val);
		val = rotor1.left().encode(val);
		val = reflector.encode(val);
		val = rotor1.right().encode(val);
		val = rotor2.right().encode(val);
		return val;
	}
}
