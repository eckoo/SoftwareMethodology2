package Application;

/**
 * Account holds the logic for getting and setting variables in the Account class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public abstract class Account {

	public static final String COLLEGE_CHECKING = "College Checking";
	public static final String MONEY_MARKET = "Money Market Savings";
	public static final String CHECKING = "Checking";
	public static final String SAVINGS = "Savings";
	
	protected Profile holder;
	protected boolean closed;
	protected double balance;

	/**
	 * This is the Account constructor.
	 * 
	 * @param holder the holder
	 */
	protected Account(Profile holder) {
		this.holder = holder;
		this.closed = false;
	}

	/**
	 * getHolder gets the holder for the Account.
	 * @return object of type Profile for the Account.
	 */
	public Profile getHolder() {
		return this.holder;
	}

	/**
	 * getBalance gets the balance for the Account.
	 * @return object of type double for the Account.
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * equals compares two accounts.
	 * @param obj Object of type Accounts.
	 * @return boolean (True if holder, closed status, and balance match), (False if holder, closed status, and balance do not match)
	 */
	@Override
	public boolean equals(Object obj) {
		//
		if (!(obj instanceof Account)) {
			return false;
		}
		Account account = (Account) obj;
		if (!this.getType().equals(account.getType())) {
			return false;
		}
		if (!this.getHolder().equals(account.getHolder())) {
			return false;
		}
		return true;
	}

	/**
	 * This is the toString method.
	 * 
	 * @return the string representation of the Account.
	 */
	@Override
	public String toString() {
		return this.getType() + "::" + this.holder.toString() + "::Balance $" + (Util.moneyToString(this.balance))
				+ "" + (closed ? "::CLOSED" : "");
	}

	/**
	 * The withdraw method will removed the designated amount from the balance of the account.
	 * @param amount Object of type Double.
	 */
	public void withdraw(double amount) {
		this.balance -= amount;
	}

	/**
	 * The deposit method will add the designated amount to the balance of the account.
	 * @param amount Object of type Double.
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}

	/**
	 * monthlyInterest returns the monthly interest.
	 */
	public abstract double monthlyInterest(); // return the monthly interest

	/**
	 * fee returns the monthly fee.
	 */
	public abstract double fee(); // return the monthly fee

	/**
	 * getType returns the account type.
	 */
	public abstract String getType(); // return the account type (class name)
}