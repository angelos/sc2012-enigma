package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectorTest {
	Reflector reflector = new Reflector("ABAB");
	
	@Test
	public void reflectingDShouldMapToB() {
		assertEquals(1, reflector.reflect(3));
	}

}
