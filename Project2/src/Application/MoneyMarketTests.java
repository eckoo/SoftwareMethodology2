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
	
	/**
	 * This is the testFee method.
	 */
	@Test
	void testFee() {
		MoneyMarket moneyMarket = new MoneyMarket(new Profile(null, null, null));
		moneyMarket.deposit(2500);
		assertEquals(0, moneyMarket.fee()); //passes, means the account is loyal
		moneyMarket.withdraw(2500); //sets balance back to 0
		
		moneyMarket.deposit(1000);
		assertEquals(10, moneyMarket.fee()); //passes, means the account is not loyal
		moneyMarket.withdraw(1000);
	}

}
