package Application;

/**
 * Checking holds the logic for getting and setting variables in the Checking class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class Checking extends Account {

	private static final double checkingMonthlyInterest = 0.1;
	private static final double checkingMonthlyFee = 25;
	private static final double checkingMonthlyFeeWaived = 0;
	private static final double checkingMinimumBalance = 1000;
	
	/**
	 * This is the Checking constructor method.
	 * @param holder Object of type Profile, balance Object of type double.
	 */
	public Checking(Profile holder, double balance) {
		this.holder = holder;
		this.balance = balance;
		this.type = "Checking";
	}
	
	/**
	 * monthlyInterest returns the monthly interest of the checking account.
	 * @return checkingMonthlyInterest if called.
	 */
	@Override
	public double monthlyInterest() {
		return checkingMonthlyInterest;
		//annual interest in checking = 0.1%
	}
	
	/**
	 * fee returns the monthly fee of the checking account.
	 * @return checkingMonthlyFee if account balance is less than $1000, checkingMonthlyFeeWaived if greater than or equal to $1000.
	 */
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
	
	/**
	 * getType is a constructor method.
	 * @return this.type = "Checking";
	 */
	@Override
	public String getType() {
		return this.type;
	}
	
	/**
	 * This is the toString method.
	 * @return the string representation of the Checking Account.
	 */
	@Override
	public String toString() {
		String str = super.toString();
		return this.type + "::" + holder + "::" + balance;
	}

}
