package Application;

/**
 * CollegeChecking holds the logic for getting and setting variables in the CollegeChecking class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class CollegeChecking extends Checking {
	protected int campusCode;
	private static final int NEW_BRUNSWICK = 0;
	private static final int NEWARK = 1;
	private static final int CAMDEN = 2;
	private static final double collegeCheckingMonthlyInterest = 0.1;
	private static final double collegeCheckingMonthlyFee = 25.00;
	private static final double collegeCheckingMonthlyFeeWaived = 0.00;
	private static final double collegeCheckingWaivedMinimumBalance = 1000;
	//must provide campus code
	//if account holder has checking account, cannot create College Checking account. each account holder can only have ONE checking account.
	/**
	 * This is the CollegeChecking Constructor method.
	 * @param holder Object of type Profile, balance Object of type double, code Object of type int.
	 */
	public CollegeChecking(Profile holder, double balance, int code) {
		super(holder, balance);

		this.type = "College Checking";
		this.campusCode = code;
	}

	/**
	 * This is the toString method.
	 * @return the string representation of the College Checking Account.
	 */
	@Override
	public String toString() {
		String str = super.toString();
		return this.type + "::" + holder + "::" + balance + "::" + this.campusCode;
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
	 * monthlyInterest returns the monthly interest of the College Checking account.
	 * @return collegeCheckingMonthlyInterest if called.
	 */
	@Override
	public double monthlyInterest() {
		return collegeCheckingMonthlyInterest;
		//annual interest in checking = 0.1%
	}

	/**
	 * fee returns the monthly fee of the College Checking account.
	 * @return collegeCheckingMonthlyFee if account balance is less than $1000, collegeCheckingMonthlyFeeWaived if greater than or equal to $1000.
	 */
	@Override
	public double fee() {
		if(balance < collegeCheckingWaivedMinimumBalance) {
			return collegeCheckingMonthlyFee;
		}
		else {
			return collegeCheckingMonthlyFeeWaived;
		}
		//$25 monthly fee waived if balance is >= $1000
	}
	
	/**
	 * getCampusCode is a constructor method.
	 * @return this.campusCode = [0 = NEW_BRUNSWICK, 1 = NEWARK, 2 = CAMDEN]
	 */
	public int getCampusCode() {
		return this.campusCode;
	}
}
