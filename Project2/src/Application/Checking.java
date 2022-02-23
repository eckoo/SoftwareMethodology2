package Application;

/**
 * Checking holds the logic for getting and setting variables in the Checking class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class Checking extends Account {

	private static final double MINIMAL_BALANCE = 1000;
	private static final double FEE = 25;
	private static final double WAIVED = 0;
	private static final double ANNUAL_INTEREST_RATE = 0.001;
	private static final int NUM_MONTHS_IN_YEAR = 12;

	/**
	 * This is the Checking constructor method.
	 * @param holder Object of type Profile, balance Object of type double.
	 */
	public Checking(Profile holder) {
		super(holder);
	}

	/**
	 * monthlyInterest returns the monthly interest of the checking account.
	 * @return checkingMonthlyInterest if called.
	 */
	@Override
	public double monthlyInterest() {
		return this.balance * ANNUAL_INTEREST_RATE / NUM_MONTHS_IN_YEAR;
	}

	/**
	 * fee returns the monthly fee of the checking account.
	 * @return checkingMonthlyFee if account balance is less than $1000, checkingMonthlyFeeWaived if greater than or equal to $1000.
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
	 * @return this.type = "Checking";
	 */
	@Override
	public String getType() {
		return CHECKING;
	}
}
