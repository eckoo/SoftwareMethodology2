package Application;

public class Checking extends Account {

	private static final double checkingMonthlyInterest = 0.1;
	private static final double checkingMonthlyFee = 25;
	private static final double checkingMonthlyFeeWaived = 0;
	private static final double checkingMinimumBalance = 1000;
	
	public Checking(Profile holder, double balance) {
		this.holder = holder;
		this.balance = balance;
		this.type = "Checking";
	}
	
	@Override
	public double monthlyInterest() {
		return checkingMonthlyInterest;
		//annual interest in checking = 0.1%
	}

	@Override
	public double fee() {
		if(balance < checkingMinimumBalance) {
			return checkingMonthlyFee;
		}
		else {
			return checkingMonthlyFeeWaived;
		}
		//$25 monthly fee waived if balance is >= $1000
	}

	@Override
	public String getType() {
		return this.type;
	}
	
	
	@Override
	public String toString() {
		String str = super.toString();
		return this.type + "::" + holder + "::" + balance;
	}

}
