package Application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * MoneyMarketTests holds the logic for testing the monthlyInterest() method in the MoneyMarket class.
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
		//Money Market
		MoneyMarket moneyMarket = new MoneyMarket(new Profile("John", "Doe", null));
		moneyMarket.deposit(3000);
		assertEquals(2.375, moneyMarket.monthlyInterest());
		
		MoneyMarket moneyMarket2 = new MoneyMarket(new Profile("John", "Doe", null));
		moneyMarket2.deposit(750);
		assertEquals(0.59375, moneyMarket2.monthlyInterest());
	}
	
	
	/*
	 * This is the testFee method.
	 */
	/*
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
	*/

}
