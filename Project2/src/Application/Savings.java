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
		
		return 0;
	}

	@Override
	public double fee() {
		
		return 0;
	}

	@Override
	public String getType() {
		return this.type;
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		return str + "something else";
	}

}
