package Application;

/**
 * AccountDatabase holds the logic for getting and setting variables in the AccountDatabase class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class AccountDatabase {
	private Account[] accounts;
	private int numAcct;

	public static final int OPEN_OK = 0;
	public static final int OPEN_REOPEN_OK = 1;
	public static final int OPEN_FAILED = 2;

	private static final int DEFAULT_CAPACITY = 10086;
	private static final int CLOSED_BALANCE = 0;
	private static final int EQUALS = 0;
	private static final int NOT_FOUND = -1;
	private static final int BEGINNING_INDEX = 0;
	private static final int EMPTY = 0;
	private static final int NEXT = 1;
	private static final int WITHDRAWL_RESET = 0;
	private static final int GROW = 0;

	/**
	 * This is the AccountDatabase constructor.
	 */
	public AccountDatabase() {
		this.accounts = new Account[DEFAULT_CAPACITY];
	}

	/**
	 * The find method checks to see if we can find the appointment in the system.
	 * 
	 * @param account Object of type Account.
	 * @return the index if found, or NOT_FOUND if not found.
	 */
	private int find(Account account) {
		for (int i = BEGINNING_INDEX; i < numAcct; i++) {
			Account anotherAccount = this.accounts[i];
			if (account.equals(anotherAccount)) {
				return i;
			}
		}
		return NOT_FOUND;
	}

	/**
	 * This is the grow method.
	 */
	private void grow() {
		Account[] newAccounts = new Account[this.accounts.length + GROW];
		for (int i = BEGINNING_INDEX; i < numAcct; i++) {
			newAccounts[i] = this.accounts[i];
		}
		this.accounts = newAccounts;
	}

	/**
	 * The open method adds an account to the list of accounts if it does not exist already.
	 * 
	 * @param account Object of type Account.
	 * @return true if we are able to successfully open the new account.
	 */
	public boolean open(Account account) {
		if (this.accounts.length == this.numAcct) {
			grow();
		}
		this.accounts[this.numAcct++] = account;
		return true;
	}

	/**
	 * The 'close' method closes an account from the list of accounts.
	 * 
	 * @param account Object of type Account.
	 * @return true if closed, false if account not found.
	 */
	public boolean close(Account account) {
		int index = find(account);
		if (index != NOT_FOUND) {
			Account found = this.accounts[index];
			if (found.closed) {
				return false;
			} else {
				found.closed = true;
				found.balance = CLOSED_BALANCE;
				if (found.getType().equals(Account.SAVINGS) || found.getType().equals(Account.MONEY_MARKET)) {
					((Savings) found).loyal = false;
				}
				if (found.getType().equals(Account.MONEY_MARKET)) {
					((MoneyMarket) found).withdrawl = WITHDRAWL_RESET;
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * The deposit method deposits a given amount into a given account.
	 * @param account Object of type Account.
	 */
	public void deposit(Account account) {
		this.getAccount(account).deposit(account.balance);
	}

	/**
	 * The withdraw method withdraws a certain amount from a given account.
	 * @param account Object of type Account.
	 * @return true if withdrawn successfully, false if not.
	 */
	public boolean withdraw(Account account) {
		Account anotherAccount = this.getAccount(account);
		double amount = account.getBalance();
		if (anotherAccount.getBalance() > amount) {
			anotherAccount.withdraw(amount);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This is the print method.
	 * Prints all the accounts in current order.
	 */
	public void print() {
		if (numAcct == EMPTY) {
			System.out.println("Account Database is empty!");
		} else {
			System.out.println();
			System.out.println("*list of accounts in the database*");
			for (int i = BEGINNING_INDEX; i < numAcct; i++) {
				System.out.println(this.accounts[i].toString());
			}
			System.out.println("*end of list*");
			System.out.println();
		}
	}

	/**
	 * This is the printByAccountType method.
	 * Prints all the accounts in order by Account Type.
	 */
	public void printByAccountType() {
		if (numAcct == EMPTY) {
			System.out.println("Account Database is empty!");
		} else {
			for (int i = BEGINNING_INDEX; i < this.numAcct; i++) {
				for (int j = i + NEXT; j < this.numAcct; j++) {
					if (this.accounts[i].getType().compareTo(this.accounts[j].getType()) > EQUALS) {
						Account temp = this.accounts[i];
						this.accounts[i] = this.accounts[j];
						this.accounts[j] = temp;
					}
				}
			}
			System.out.println();
			System.out.println("*list of accounts by account type.");
			for (int i = BEGINNING_INDEX; i < numAcct; i++) {
				System.out.println(this.accounts[i].toString());
			}
			System.out.println("*end of list.");
			System.out.println();
		}
	}

	/**
	 * This is the printFeeAndInterest method.
	 * Prints all the accounts in order by fee and interest.
	 */
	public void printFeeAndInterest() {
		if (numAcct == EMPTY) {
			System.out.println("Account Database is empty!");
		} else {

			System.out.println();
			System.out.println("*list of accounts with fee and monthly interest");
			for (int i = BEGINNING_INDEX; i < numAcct; i++) {
				Account account = this.accounts[i];
				System.out.print(account.toString());
				System.out.println("::fee $" + Util.moneyToString(account.fee()) + "::monthly interest $"
						+ Util.moneyToString(account.monthlyInterest()));
			}
			System.out.println("*end of list.");
			System.out.println();
		}
	}

	/**
	 * The updateBalance method updates the current balance of the account.
	 */
	public void updateBalance() {
		if (numAcct == EMPTY) {
			System.out.println("Account Database is empty!");
		} else {

			System.out.println();
			System.out.println("*list of accounts with updated balance");
			for (int i = BEGINNING_INDEX; i < numAcct; i++) {
				Account account = this.accounts[i];
				account.balance += account.monthlyInterest();
				account.balance -= account.fee();
				System.out.println(account.toString());
			}
			System.out.println("*end of list.");
			System.out.println();
		}
	}

	/**
	 * The checkOpen method will check to see if we can add an account to the list of accounts.
	 * @param account Object of type Account..
	 * @return OPEN_REOPEN_OK if account is able to be reopened, OPEN_FAILED if not.
	 */
	public int checkOpen(Account account) {
		String simpleAccountType = account.getType().replace(Account.COLLEGE_CHECKING, "C")
				.replace(Account.CHECKING, "C");
		for (int i = BEGINNING_INDEX; i < numAcct; i++) {
			Account anotherAccount = this.accounts[i];
			String anotherSimpleAccountType = anotherAccount.getType().replace(Account.COLLEGE_CHECKING,
					"C").replace(Account.CHECKING, "C");
			if (simpleAccountType.equals(anotherSimpleAccountType)
					&& account.getHolder().equals(anotherAccount.getHolder())) {
				if (anotherAccount.closed && anotherAccount.getType().equals(account.getType())) {
					return OPEN_REOPEN_OK;
				} else {
					return OPEN_FAILED;
				}
			}
		}
		return OPEN_OK;
	}

	/**
	 * This is the getAccount method. 
	 * @param account Object of type Account.
	 * @return the given accounts current index, or null if not found.
	 */
	public Account getAccount(Account account) {
		int index = find(account);
		if (index != NOT_FOUND) {
			return this.accounts[index];
		} else {
			return null;
		}
	}

}