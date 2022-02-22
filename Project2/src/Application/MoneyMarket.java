package Application;


/* • By default, it is a loyal customer account
• If the balance falls below $2500, then it is not a
loyal customer account anymore
• A loyal customer account gets additional interest
rate 0.15%; that is, annual interest rate will be
0.95%.
• Fee cannot be waived if the number of
withdrawals exceeds 3 times
*/
/**
 * MoneyMarket holds the logic for getting and setting variables in the MoneyMarket class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class MoneyMarket extends Savings {	//if balance falls below $2500, no longer loyal customer account. by default, loyal customer account.

	public static final int MINIMAL_LOYAL_BALANCE = 2500;
	
	protected int withdrawl;

	private static final double NORMAL_ANNUAL_INTEREST_RATE = 0.008;
	private static final double LOYAL_ANNUAL_INTEREST_RATE = 0.0095;
	private static final int NUM_MONTHS_IN_YEAR = 12;
	private static final double WAIVED = 0;
	private static final double FEE = 10;
	
	/**
	 * This is the MoneyMarket constructor method.
	 * @param holder Object of type Profile, balance Object of type double.
	 */
	public MoneyMarket(Profile holder, double balance) {
		super(holder, true);
	}
	
	/**
	 * monthlyInterest returns the monthly interest of the Money Market account.
	 * @return moneyMarketLoyalMonthlyInterest if loyal customer, moneyMarketNonLoyalMonthlyInterest if non-loyal customer.
	 */
	@Override
	public double monthlyInterest() {
		double annualInterestRate = isLoyal() ? LOYAL_ANNUAL_INTEREST_RATE : NORMAL_ANNUAL_INTEREST_RATE;
		return this.balance * annualInterestRate / NUM_MONTHS_IN_YEAR;
		//annual interest in MoneyMarket = 0.8%, monthlyInterest = 0.067%
		//if loyal customer, annual interest in MoneyMarket = 0.95%, monthlyInterest = 0.079167%
	}

	/**
	 * fee returns the monthly fee of the Money Market account.
	 * @return moneyMarketMonthlyFee if account balance is less than $2500, moneyMarketMonthlyFeeWaived if greater than or equal to $2500.
	 */
	@Override
	public double fee() {
		//$10 monthly fee waived if balance is >= $2500
		if (isLoyal()) {
			return WAIVED;
		}
		else {
			return FEE;
		}
	}
	
	/**
	 * This is the toString method.
	 * @return the string representation of the Money Market Account.
	 */
	@Override
	public String toString() {
		return super.toString() + "::withdrawl: " + withdrawl;
	}
	
	/**
	 * isLoyal is a constructor method.
	 * @return this.loyal = [1 = LOYAL, 0 = NON_LOYAL].
	 */
	public int isLoyal() {
		return this.loyal;
	}
	
	/**
	 * getType is a constructor method.
	 * this.type = "Money Market";
	 */
	@Override
	public String getType() {
		return this.type;
	}
	
	/**
	 * The withdraw method keeps count of how many times a withdraw has been made from an account.
	 * @param amount Object of type double.
	 * @return false if balance is less than minimum loyal balance.
	 */
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount);
		withdrawl++;
		if (this.balance < MINIMAL_LOYAL_BALANCE) {
			this.loyal = false;
		}
	}
}
