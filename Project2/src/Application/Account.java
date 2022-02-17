package Application;

public abstract class Account {
	protected Profile holder;
	protected boolean closed;
	protected double balance;
	protected String type;
	//maybe check account class
	
	/**
	 * equals compares two accounts.
	 * @param obj Object of type Accounts.
	 * @return boolean (True if holder, closed status, and balance match), (False if holder, closed status, and balance do not match)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Account) {
			Account account = (Account) obj;
			if (!this.holder.equals(account.getHolder())) {
				return false;
			}
			if (!(this.closed == account.getClosed())) {
				return false;
			}
			if (this.balance != (account.getBalance())) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * This is the toString method.
	 * 
	 * @return the string representation of the Account.
	 */
	@Override
	public String toString() {
		return type + holder.toString() + "::Balance " + Double.toString(balance);
	}
	
	/**
	 * The withdraw method will removed the designated amount from the balance of the account.
	 * @param amount Object of type Double.
	 */
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	/**
	 * The deposit method will add the designated amount to the balance of the account.
	 * @param amount Object of type Double.
	 */
	public void deposit(double amount) {
		balance += amount;
	}
	
	/**
	 * 
	 */
	public abstract double monthlyInterest();  //return the monthly interest
	
	
	/**
	 * 
	 */
	public abstract double fee(); 			//return the monthly fee
	

	/**
	 * 
	 */
	public abstract String getType();		//return the account type (class name)
	
	/**
	 * getHolder gets the holder for the Account.
	 * @return object of type Profile for the Account.
	 */
	public Profile getHolder() {
		return this.holder;
	}
	
	/**
	 * getClosed gets the closed status for the Account.
	 * @return object of type boolean for the Account.
	 */
	public boolean getClosed() {
		return this.closed;
	}
	
	/**
	 * getBalance gets the balance for the Account.
	 * @return object of type double for the Account.
	 */
	public double getBalance() {
		return this.balance;
	}
	
}
