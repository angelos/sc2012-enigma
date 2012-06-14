package enigma;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RotorTest {
	Rotor rotor;
	
	@Before
	public void setup() {
		rotor = new Rotor("DCAB", 'C');
	}
	
	@Test
	public void goingLeftAShouldEncodeToD() {
		assertEquals(3, rotor.left().encode(0));
	}

	@Test
	public void goingRightBShouldEncodeToD() {
		assertEquals(3, rotor.right().encode(1));
	}
	
	@Test
	public void afterShiftingGoingLeftAShouldEncodeToB() {
		rotor.shift();
		assertEquals(1, rotor.left().encode(0));
	}

	@Test
	public void afterShiftingGoingRightAShouldEncodeToC() {
		rotor.shift();
		assertEquals(2, rotor.right().encode(0));
	}

	@Test
	public void afterSettingToBGoingRightAShouldEncodeToC() {
		rotor.set('B');
		assertEquals(2, rotor.right().encode(0));
	}
	
	@Test
	public void rotorShouldReportNotchInWindow() {
		rotor.shift();
		rotor.shift();
		assertTrue(rotor.notchInWindow());
	}

	@Test
	public void rotorShouldReportNotchNotInWindow() {
		assertTrue(!rotor.notchInWindow());
	}
}
