package enigma;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RotorTest {
	Rotor rotor;
	
	@Before
	public void setup() {
		rotor = new Rotor("DCAB");
	}
	
	@Test
	public void goingLeftAShouldEncodeToD() {
		assertEquals("D", rotor.left("A"));
	}

	@Test
	public void goingRightBShouldEncodeToD() {
		assertEquals("D", rotor.right("B"));
	}
	
	@Test
	public void afterShiftingGoingLeftAShouldEncodeToB() {
		rotor.shift();
		assertEquals("B", rotor.left("A"));
	}

	@Test
	public void afterShiftingGoingRightAShouldEncodeToC() {
		rotor.shift();
		assertEquals("C", rotor.right("A"));
	}
}
