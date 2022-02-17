package Application;

public class Checking extends Account {

	
	public Checking(Profile holder, double balance) {
		this.holder = holder;
		this.balance = balance;
		this.type = "Checking";
	}
	
	@Override
	public double monthlyInterest() {
		//annual interest in checking = 0.1%
	}

	@Override
	public double fee() {
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
