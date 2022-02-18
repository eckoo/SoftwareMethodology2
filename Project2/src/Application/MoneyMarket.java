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
 * 
 * @author Kiernan King and Ahmed Alghazwi
 *
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
	
	
	public MoneyMarket(Profile holder, double balance) {
		super(holder, balance);
		this.type = "Money Market";
		this.loyal = LOYAL;
	}
	
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
	
	@Override
	public String toString() {
		String str = super.toString();
		return str + "something else";
	}
	
	public int isLoyal() {
		return this.loyal;
	}

}
