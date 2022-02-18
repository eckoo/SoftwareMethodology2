package Application;

//must provide campus code
public class CollegeChecking extends Checking {
	protected int campusCode;
	private static final int NEW_BRUNSWICK = 0;
	private static final int NEWARK = 1;
	private static final int CAMDEN = 2;
	private static final double collegeCheckingMonthlyInterest = 0.1;
	private static final double collegeCheckingMonthlyFee = 25.00;
	private static final double collegeCheckingMonthlyFeeWaived = 0.00;
	private static final double collegeCheckingWaivedMinimumBalance = 1000;
	
	//if account holder has checking account, cannot create College Checking account. each account holder can only have ONE checking account.
	public CollegeChecking(Profile holder, double balance, int code) {
		super(holder, balance);

		this.type = "College Checking";
		this.campusCode = code;
	}

	@Override
	public String toString() {
		String str = super.toString();
		return this.type + "::" + holder + "::" + balance + "::" + this.campusCode;
	}
	
	@Override
	public String getType() {
		return this.type;
	}
	
	@Override
	public double monthlyInterest() {
		return collegeCheckingMonthlyInterest;
		//annual interest in checking = 0.1%
	}

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
	
	public int getCampusCode() {
		return this.campusCode;
	}
}
