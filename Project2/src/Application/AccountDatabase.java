package Application;

public class AccountDatabase {
	private Account[] accounts;
	private int numAcct;
	
	private static final int DEFAULT_CAPACITY = 10086;
	private static final int EMPTY = 0;
	private static final int BEGINNING_INDEX = 0;
	private static final int NEXT = 1;
	private static final int EQUALS = 0;
	private static final int GROW_AMOUNT = 0;
	
	//very very similar to schedule

	/**
	 * The find method checks to see if we can find the appointment in the system.
	 * 
	 * @param appt The appointment.
	 * @return the index if found, or NOT_FOUND if not found.
	 */
	private int find(Account account) {
		for (int i = BEGINNING_INDEX; i < this.numAcct; i++) {
			if (this.accounts[i].equals(account)) {
				return i;
			}
		}
		return NOT_FOUND;
	}
	
	/**
	 * This is the grow method.
	 * Increases the capacity of the container by 4.
	 */
	private void grow() {
		Account[] newCopy = new Account[this.appointments.length + GROW_AMOUNT];
		for (int i = BEGINNING_INDEX; i < this.numAcct; i++) {
			newCopy[i] = this.accounts[i];
		}
		this.accounts = newCopy;
	}
	
	/**
	 * This is the AccountDatabase constructor.
	 */
	public AccountDatabase() {
		this.accounts = new Account[DEFAULT_CAPACITY];
	}
	
	/**
	 * The 'add' method adds an appointment to the list of appointments if it does not exist already.
	 * 
	 * @param account Object of type Account.
	 * @return false if the account already exists (or if we have to grow the size of the array),
	 * and true if we are able to successfully open the new account.
	 */
	public boolean open(Account account) {
		if (this.find(account) != NOT_FOUND) {
			return false;
		}
		if (this.accounts.length == this.numAcct) {
			grow();
		}
		this.accounts[this.numAcct] = appt;
		this.numAcct++;
		return true;
	}
	
	/**
	 * The 'close' method closes an account from the list of accounts.
	 * 
	 * @param account Object of type Account.
	 * @return true if closed, false if account not found.
	 */
	public boolean close(Account account) {
		int index = this.find(account);
		if (index == NOT_FOUND) {
			return false;
		}
		this.numAcct--;
		for (int i = index; i < numAcct; i++) {
			this.accounts[i] = this.accounts[i + NEXT];
		}
		this.accounts[this.numAcct] = null;
		return true;
	}
	
	public void deposit(Account account) {
		
	}
	
	public boolean withdraw(Account account) {	//return false if insufficient fund
		if(withdraw > account.balance) {
			return false;
		}
		else {
			
		}
	}
	
	public void print() {
		
	}
	
	public void printByAccountType() {
		
	}
	
	public void printFeeAndInterest() {
		
	}
}
