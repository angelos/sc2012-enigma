package enigma;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/*
 * Reflector   Rotor   Input
 *   A         A D      A
 *   B         B C      B
 *   A         C B      C
 *   B         D A      D
 */
public class MiniEnigmaTest {
	private Rotor rotor;
	private Reflector reflector;
	
	@Before
	public void setup() {
		rotor = new Rotor("DCAB");
		reflector = new Reflector("ABAB");
	}

	@Test
	public void testFirstStepEncodesAToD() {
		assertEquals("D", encode("A"));
	}
	
	private String encode(String input) {
		String val = input;
		val = rotor.left(val);
		val = reflector.reflect(val);
		val = rotor.right(val);
		return val;
	}

}
