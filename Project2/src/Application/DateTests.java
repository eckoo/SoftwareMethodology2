package Application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This is the DateTests class.
 * 
 * @author Kiernan King and Ahmed Alghazwi
 */
public class DateTests {

	/**
	 * This is the DateTests constructor.
	 */
	public DateTests() {
	}

	/**
	 * This is the testIsValid method.
	 */
	@Test
	void testIsValid() {
		assertTrue(new Date("1/1/2022").isValid());
	}

}
