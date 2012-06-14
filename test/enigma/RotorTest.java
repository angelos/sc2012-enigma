package enigma;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RotorTest {
	Rotor rotor;
	
	@Before
	public void setup() {
		rotor = new Rotor("DCAB", "C");
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

	@Test
	public void afterSettingToBGoingRightAShouldEncodeToC() {
		rotor.set("B");
		assertEquals("C", rotor.right("A"));
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
