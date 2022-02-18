package Application;

/**
 * Savings holds the logic for getting and setting variables in the Savings class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class Savings extends Account {

	protected int isLoyal;
	private static final int LOYAL = 1;
	private static final int NON_LOYAL = 0;
	private static final double savingsLoyalMonthlyInterest = 0.0375;
	private static final double savingsNonLoyalMonthlyInterest = 0.025;
	private static final double savingsMonthlyFee = 6.00;
	private static final double savingsMonthlyFeeWaived = 0.00;
	private static final double savingsWaivedMinimumBalance = 300;
	//A loyal customer’s account gets additional interest rate 0.15%; that is, annual interest rate will be 0.45% for a loyal customer account.
	
	/**
	 * This is the Savings constructor method.
	 * @param holder Object of type Profile, balance Object of type double.
	 */
	public Savings(Profile holder, double balance) {
		this.holder = holder;
		this.balance = balance;
		this.type = "Checking";
		this.loyal = loyal;
	}
	
	/**
	 * monthlyInterest returns the monthly interest of the savings account.
	 * @return savingsLoyalMonthlyInterest if loyal customer, savingsNonLoyalMonthlyInterest if non-loyal customer.
	 */
	@Override
	public double monthlyInterest() {
		if(isLoyal()) {
			return savingsLoyalMonthlyInterest;
		}
		else {
			return savingsNonLoyalMonthlyInterest;
		}
		//annual interest = 0.3%, monthlyInterest = 0.025%
		//if loyal customer, annual interest = 0.45%, monthlyInterest = 0.0375%
	}

	/**
	 * fee returns the monthly fee of the savings account.
	 * @return savingsMonthlyFee if account balance is less than $300, savingsMonthlyFeeWaived if greater than or equal to $300.
	 */
	@Override
	public double fee() {
		if(balance < savingsWaivedMinimumBalance) {
			return savingsMonthlyFee;
		}
		else {
			return savingsMonthlyFeeWaived;
		}
		//$6 monthly fee waived if account balance is >= $300
	}

	/**
	 * getType is a constructor method.
	 * this.type = "Savings";
	 */
	@Override
	public String getType() {
		return this.type;
	}
	
	/**
	 * isLoyal is a constructor method.
	 * @return this.loyal = [1 = LOYAL, 0 = NON_LOYAL].
	 */
	public int isLoyal() {
		return this.loyal;
	}
	
	/**
	 * This is the toString method.
	 * @return the string representation of the Savings Account.
	 */
	@Override
	public String toString() {
		String str = super.toString();
		return this.type + str + "something else";
	}

}
