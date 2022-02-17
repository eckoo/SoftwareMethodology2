package Application;

//A loyal customer’s account gets additional interest rate 0.15%; that is, annual interest rate will be 0.45% for a loyal customer account.
public class Savings extends Account {

	public Savings(Profile holder, double balance) {
		this.holder = holder;
		this.balance = balance;
		this.type = "Checking";
	}
	
	@Override
	public double monthlyInterest() {
		//annual interest = 0.3%, monthlyInterest = 0.025%
		//if loyal customer, annual interest = 0.45%, monthlyInterest = 0.0375%
	}

	@Override
	public double fee() {
		//$6 monthly fee waived if account balance is >= $300
	}

	@Override
	public String getType() {
		return this.type;
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		return this.type + str + "something else";
	}

}
