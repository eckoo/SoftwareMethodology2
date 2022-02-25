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
		
		//Checking Account
		Account account = new Checking(new Profile("John", "Doe", new Date("2/19/1989")));
	
		database.open(account);
		assertTrue(database.getAccount(account) == account);
		//closes account
		database.close(account);
		//reopens account
		database.open(account);
		//checks again to see if account can reopen
		assertEquals(database.checkOpen(account), 1);
		
		//CollegeChecking Account, NEW_BRUNSWICK campus code.
		Account account1a = new CollegeChecking(new Profile("April", "March", new Date("1/15/1987")), 0);
		
		database.open(account1a);
		assertTrue(database.getAccount(account1a) == account1a);
		//closes account
		database.close(account1a);
		//reopens account
		database.open(account1a);
		//checks again to see if account can reopen
		assertEquals(database.checkOpen(account1a), 1);
		
		//CollegeChecking Account, NEWARK campus code.
		Account account1b = new CollegeChecking(new Profile("August", "Krueger", new Date("8/14/1990")), 1);
		
		database.open(account1b);
		assertTrue(database.getAccount(account1b) == account1b);
		//closes account
		database.close(account1b);
		//reopens account
		database.open(account1b);
		//checks again to see if account can reopen
		assertEquals(database.checkOpen(account1b), 1);
		
		//CollegeChecking Account, CAMDEN campus code.
		Account account1c = new CollegeChecking(new Profile("May", "June", new Date("5/6/1956")), 2);
		
		database.open(account1c);
		assertTrue(database.getAccount(account1c) == account1c);
		//closes account
		database.close(account1c);
		//reopens account
		database.open(account1c);
		//checks again to see if account can reopen
		assertEquals(database.checkOpen(account1c), 1);
		
		//Savings Account, loyal member.
		Account account2a = new Savings(new Profile("Kate", "Lindsey", new Date("8/31/2001")), true);
		
		database.open(account2a);
		assertTrue(database.getAccount(account2a) == account2a);
		//closes account
		database.close(account2a);
		//reopens account
		database.open(account2a);
		//checks again to see if account can reopen
		assertEquals(database.checkOpen(account2a), 1);
		
		//Savings Account, non-loyal member.
		Account account2b = new Savings(new Profile("Roy", "Brooks", new Date("10/31/1979")), false);
		
		database.open(account2b);
		assertTrue(database.getAccount(account2b) == account2b);
		//closes account
		database.close(account2b);
		//reopens account
		database.open(account2b);
		//checks again to see if account can reopen
		assertEquals(database.checkOpen(account2b), 1);
		
		//MoneyMarket Account, loyal member.
		Account account3a = new MoneyMarket(new Profile("Kiernan", "King", new Date("8/18/2001")));
		
		database.open(account3a);
		assertTrue(database.getAccount(account3a) == account3a);
		//closes account
		database.close(account3a);
		//reopens account
		database.open(account3a);
		//checks again to see if account can reopen
		assertEquals(database.checkOpen(account3a), 1);
		
		//MoneyMarket Account, non-loyal member.
		Account account3b = new MoneyMarket(new Profile("Ahmed", "Alghazwi", new Date("2/14/2000")));
		
		database.open(account3b);
		assertTrue(database.getAccount(account3b) == account3b);
		//closes account
		database.close(account3b);
		//reopens account
		database.open(account3b);
		//checks again to see if account can reopen
		assertEquals(database.checkOpen(account3b), 1);
	}

	/**
	 * This is the testClose method.
	 */
	@Test
	void testClose() {
		AccountDatabase database = new AccountDatabase();

		Account account = new Checking(new Profile("Born", "Doe", new Date("2/18/1989")));
		
		database.open(account);
		database.close(account);
		assertTrue(account.closed);
		
		
		Account account1a = new CollegeChecking(new Profile("April", "March", new Date("4/3/1967")), 0);
		
		database.open(account1a);
		database.close(account1a);
		assertTrue(account1a.closed);
		
		
		Account account1b = new CollegeChecking(new Profile("March", "April", new Date("3/4/1976")), 1);
		
		database.open(account1b);
		database.close(account1b);
		assertTrue(account1b.closed);
		
		
		Account account1c = new CollegeChecking(new Profile("June", "July", new Date("6/7/1967")), 2);
		
		database.open(account1c);
		database.close(account1c);
		assertTrue(account1c.closed);
		
		
		Account account2a = new Savings(new Profile("Kate", "Lindsey", new Date("8/31/2001")), true);
		
		database.open(account2a);
		database.close(account2a);
		assertTrue(account2a.closed);
		
		
		Account account2b = new Savings(new Profile("Roy", "Brooks", new Date("10/31/1979")), false);
		
		database.open(account2b);
		database.close(account2b);
		assertTrue(account2b.closed);
		
		
		Account account3a = new Savings(new Profile("Kiernan", "King", new Date("8/18/2001")), true);
		
		database.open(account3a);
		database.close(account3a);
		assertTrue(account3a.closed);
		
		
		Account account3b = new Savings(new Profile("Ahmed", "Alghazwi", new Date("2/14/2000")), false);
		
		database.open(account3b);
		database.close(account3b);
		assertTrue(account3b.closed);
	}
	
}
