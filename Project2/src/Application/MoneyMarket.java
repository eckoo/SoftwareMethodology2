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

	private static final int LOYAL = 1;
	private static final int NON_LOYAL = 0;
	private static final int withdrawalCounter = 0;
	private static final int WithdrawLimit = 3;
	private static final int MinimumBalance = 2500;
	private static final double moneyMarketMonthlyInterest = 0.1;
	private static final double moneyMarketMonthlyFee = 10.00;
	private static final double moneyMarketMonthlyFeeWaived = 0.00;
	private static final double moneyMarketWaivedMinimumBalance = 2500;
	private static final double moneyMarketLoyalMonthlyInterest = 0.079;
	private static final double moneyMarketNonLoyalMonthlyInterest = 0.067;
	
	/**
	 * This is the MoneyMarket constructor method.
	 * @param holder Object of type Profile, balance Object of type double.
	 */
	public MoneyMarket(Profile holder, double balance) {
		super(holder, balance);
		this.type = "Money Market";
		this.loyal = LOYAL;
	}
	
	/**
	 * monthlyInterest returns the monthly interest of the Money Market account.
	 * @return moneyMarketLoyalMonthlyInterest if loyal customer, moneyMarketNonLoyalMonthlyInterest if non-loyal customer.
	 */
	@Override
	public double monthlyInterest() {
		if(isLoyal()) {
			return moneyMarketLoyalMonthlyInterest;
		}
		else {
			return moneyMarketNonLoyalMonthlyInterest;
		}
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
		if(balance < moneyMarketWaivedMinimumBalance) {
			return moneyMarketMonthlyFee;
		}
		else {
			return moneyMarketMonthlyFeeWaived;
		}
		withdrawalCounter++
	}
	
	/**
	 * This is the toString method.
	 * @return the string representation of the Money Market Account.
	 */
	@Override
	public String toString() {
		String str = super.toString();
		return str + "something else";
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

}
