package Application;

//must provide campus code
public class CollegeChecking extends Checking {
	protected int campusCode;
	private static final int NEW_BRUNSWICK = 0;
	private static final int NEWARK = 1;
	private static final int CAMDEN = 2;
	
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
		//annual interest in checking = 0.1%
	}

	@Override
	public double fee() {
		//$25 monthly fee waived if balance is >= $1000
	}
	
	public void getCampusCode(int code) {
		if(this.campusCode == NEW_BRUNSWICK) {
			code = NEW_BRUNSWICK;
		}
		else if(this.campusCode == NEWARK) {
			code = NEWARK;
		}
		else {
			code = CAMDEN;
		}
	}
}
