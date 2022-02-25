package Application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This is the AccountDatabaseTests class.
 * 
 * @author Kiernan King and Ahmed Alghazwi
 */
public class AccountDatabaseTests {

	/**
	 * This is the AccountDatabaseTests constructor.
	 */
	public AccountDatabaseTests() {
	}

	/**
	 * This is the testOpen method.
	 */
	@Test
	void testOpen() {
		AccountDatabase database = new AccountDatabase();
		Account account = new Checking(new Profile("John", "Doe", new Date("1/1/2000")));
		Account account1 = new Checking(new Profile("John", new Date("1/1/2000")));
		
		database.open(account);
		assertTrue(database.getAccount(account) == account);
		

	}

	/**
	 * This is the testClose method.
	 */
	@Test
	void testClose() {
		AccountDatabase database = new AccountDatabase();
		Account account = new Checking(new Profile("John", "Doe", new Date("1/1/2000")));
		
		database.open(account);
		database.close(account);
		assertTrue(account.closed);
	}
	
	/**
	 * This is the testDeposit method.
	 */
	@Test
	void testDeposit() {
		AccountDatabase database = new AccountDatabase();
		Account account = new Checking(new Profile("John", "Doe", new Date("1/1/2000")));
		
		database.open(account);
		account.deposit(2500);
		assertTrue(account.balance == 2500);
		account.withdraw(1000);
		
		
	}
	
	/**
	 * This is the testWithdrawal method.
	 */
	@Test
	void testWithdrawal() {
		AccountDatabase database = new AccountDatabase();
		Account account = new Checking(new Profile("John", "Doe", new Date("1/1/2000")));
		
		database.open(account);
		account.deposit(2500);
		account.withdraw(2500);
		assertTrue(account.balance == 0);
		
		account.deposit(500);
		account.withdraw(1000);
		assertTrue(account.balance == 500);
	}
}
