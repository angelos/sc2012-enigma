package enigma;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/*
 * Reflector   Rotor   Input
 *   A         A D      A
 *   B         B C      B
 *   A        >C B      C
 *   B         D A      D
 */
public class MiniEnigmaTest {
	private Rotor rotor;
	private Reflector reflector;
	
	@Before
	public void setup() {
		rotor = new Rotor("DCAB", "C");
		reflector = new Reflector("ABAB");
	}

	@Test
	public void firstStepEncodesAToD() {
		assertEquals("D", encode("A"));
	}
	
	@Test
	public void afterShiftEncodesAToB() {
		rotor.shift();
		assertEquals("B", encode("A"));
	}
	
	@Test
	public void encodesAToBAndAToD() {
		rotor.shift();
		assertEquals("B", encode("A"));
		rotor.shift();
		assertEquals("D", encode("A"));
	}

	@Test
	public void assembledEnigmaEncodesAToB() {
		Enigma enigma = new Enigma(reflector, rotor);
		assertEquals("B", enigma.encode("A"));
	}

	@Test
	public void assembledEnigmaEncodesAToBAndAToD() {
		Enigma enigma = new Enigma(reflector, rotor);
		assertEquals("B", enigma.encode("A"));
		assertEquals("D", enigma.encode("A"));
	}

	private String encode(String input) {
		String val = input;
		val = rotor.left(val);
		val = reflector.reflect(val);
		val = rotor.right(val);
		return val;
	}

}
