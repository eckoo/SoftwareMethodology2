package Application;

public abstract class Account {
	protected Profile holder;
	protected boolean closed;
	protected double balance;
	protected String type;
	//maybe check account class
	
	/**
	 * 
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Account) {
			Account account = (Account) obj;
			if (!this.holder.equals(account.getHolder())) {
				return false;
			}
			if (!(this.closed == account.getClosed())) { //have to check to see how two booleans can be compared
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
	 * The toString method 
	 * @return 
	 */
	@Override
	public String toString() {
		return type + holder.toString() + "::Balance " + Double.toString(balance) + "::" + /*location and loyalty member and withdraw/deposit*/;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	/**
	 * 
	 * @param amount
	 */
	public void deposit(double amount) {
		balance += amount;
	}
	
	/**
	 * 
	 * @return
	 */
	public abstract double monthlyInterest(); { //return the monthly interest
	}
	
	/**
	 * 
	 * @return
	 */
	public abstract double fee(); {			//return the monthly fee
	}

	/**
	 * 
	 * @return
	 */
	public abstract String getType(); {		//return the account type (class name)
	}
	
	/**
	 * 
	 * @return 
	 */
	public Profile getHolder() {
		return this.holder;
	}
	
	public boolean getClosed() {
		return this.closed;
	}
	
	/**
	 * getBalance is a constructor method.
	 * @return balance.
	 * 
	 */
	public double getBalance() {
		return this.balance;
	}
	
}
