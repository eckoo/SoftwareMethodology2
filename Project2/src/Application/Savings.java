package Application;

/**
 * Savings holds the logic for getting and setting variables in the Savings class.
 * 
 * @author Kiernan King and Ahmed Alghazwi
 */
public class Savings extends Account {

	protected boolean loyal;

	private static final double NORMAL_ANNUAL_INTEREST_RATE = 0.003;
	private static final double LOYAL_ANNUAL_INTEREST_RATE = 0.0045;
	private static final int NUM_MONTHS_IN_YEAR = 12;
	private static final int MINIMAL_BALANCE = 300;
	private static final int WAIVED = 0;
	private static final int FEE = 6;

	/**
	 * This is the Savings constructor method.
	 * @param holder Object of type Profile, balance Object of type double.
	 */
	public Savings(Profile holder, boolean loyal) {
		super(holder);
		this.loyal = loyal;
	}

	/**
	 * monthlyInterest returns the monthly interest of the savings account.
	 * @return savingsLoyalMonthlyInterest if loyal customer, savingsNonLoyalMonthlyInterest if non-loyal customer.
	 */
	@Override
	public double monthlyInterest() {
		double annualInterestRate = this.loyal ? LOYAL_ANNUAL_INTEREST_RATE : NORMAL_ANNUAL_INTEREST_RATE;
		return this.balance * annualInterestRate / NUM_MONTHS_IN_YEAR;
	}

	/**
	 * fee returns the monthly fee of the savings account.
	 * @return savingsMonthlyFee if account balance is less than $300, savingsMonthlyFeeWaived if greater than or equal to $300.
	 */
	@Override
	public double fee() {
		if (this.balance < MINIMAL_BALANCE) {
			return FEE;
		} else {
			return WAIVED;
		}
	}

	/**
	 * getType is a constructor method.
	 * @return "Savings";
	 */
	@Override
	public String getType() {
		return SAVINGS;
	}

	/**
	 * This is the toString method.
	 * @return the string representation of the Savings Account.
	 */
	@Override
	public String toString() {
		return super.toString() + (this.loyal ? "::Loyal" : "");
	}
}
