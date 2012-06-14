package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class AcceptanceTest {

	@Test
	public void setupMCKShouldEncodeEtoQ() {
		Enigma e = new Enigma("M", "C", "K");
		assertEquals("Q", e.encode("E"));
	}
	
	
//		String plaintext = "Welcome to Bletchley Park";

}
