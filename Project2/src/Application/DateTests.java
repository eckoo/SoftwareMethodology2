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
		assertFalse(new Date("13/12/2022").isValid());
		assertFalse(new Date("0/5/2022").isValid());
		
		assertTrue(new Date("1/1/2023").isValid());
		assertFalse(new Date("13/12/2023").isValid());
		assertFalse(new Date("0/5/2023").isValid());
		
		assertFalse(new Date("2/31/2022").isValid());
		assertFalse(new Date("4/31/2022").isValid());
		assertFalse(new Date("6/31/2022").isValid());
		assertFalse(new Date("9/31/2022").isValid());
		assertTrue(new Date("10/31/2022").isValid());
		assertFalse(new Date("11/31/2022").isValid());
		
		assertTrue(new Date("1/1/2020").isValid());
		assertFalse(new Date("13/12/2020").isValid());
		assertFalse(new Date("0/5/2020").isValid());
		
		assertTrue(new Date("2/29/2020").isValid());
		assertTrue(new Date("2/28/2020").isValid());
		assertFalse(new Date("2/29/2019").isValid());
		assertTrue(new Date("2/28/2019").isValid());
	}

}
