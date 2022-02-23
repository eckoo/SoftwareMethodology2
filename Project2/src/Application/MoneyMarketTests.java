package Application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This is the MoneyMarketTests class.
 * 
 * @author Kiernan King and Ahmed Alghazwi
 */
class MoneyMarketTests {

	/**
	 * This is the MoneyMarketTests constructor.
	 */
	public MoneyMarketTests() {
	}

	/**
	 * This is the testMonthlyInterest method.
	 */
	@Test
	void testMonthlyInterest() {
		MoneyMarket moneyMarket = new MoneyMarket(new Profile(null, null, null));
		moneyMarket.deposit(10000);
		assertEquals(0.01, moneyMarket.monthlyInterest(), 95);
	}

}
