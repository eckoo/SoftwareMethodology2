package Application;

public class Checking extends Account {

	
	public Checking(Profile holder, double balance) {
		this.holder = holder;
		this.balance = balance;
		this.type = "Checking";
	}
	
	@Override
	public double monthlyInterest() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double fee() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}
	
	
	@Override
	public String toString() {
		String str = super.toString();
		return this.type + "::" + holder + "::" + balance;
	}

}
