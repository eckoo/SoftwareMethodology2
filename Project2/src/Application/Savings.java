package Application;

//A loyal customer’s account gets additional interest rate 0.15%; that is, annual interest rate will be 0.45% for a loyal customer account.
public class Savings extends Account {

	protected int isLoyal;
	private static final int LOYAL = 1;
	private static final int NON_LOYAL = 0;
	private static final double savingsLoyalMonthlyInterest = 0.0375;
	private static final double savingsNonLoyalMonthlyInterest = 0.025;
	private static final double savingsMonthlyFee = 6.00;
	private static final double savingsMonthlyFeeWaived = 0.00;
	private static final double savingsWaivedMinimumBalance = 300;
	
	public Savings(Profile holder, double balance) {
		this.holder = holder;
		this.balance = balance;
		this.type = "Checking";
		this.loyal = loyal;
	}
	
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

	@Override
	public String getType() {
		return this.type;
	}
	
	public boolean isLoyal() {
		if(this.loyal == LOYAL) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		return this.type + str + "something else";
	}

}
