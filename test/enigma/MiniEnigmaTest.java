package enigma;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
		rotor = new Rotor("DCAB", 'C');
		reflector = new Reflector("ABAB");
	}

	@Test
	public void firstStepEncodesAToD() {
		assertEquals(3, encode(0));
	}
	
	@Test
	public void afterShiftEncodesAToB() {
		rotor.shift();
		assertEquals(1, encode(0));
	}
	
	@Test
	public void encodesAToBAndAToD() {
		rotor.shift();
		assertEquals(1, encode(0));
		rotor.shift();
		assertEquals(3, encode(0));
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

	private int encode(int val) {
		val = rotor.left().encode(val);
		val = reflector.encode(val);
		val = rotor.right().encode(val);
		return val;
	}

}
