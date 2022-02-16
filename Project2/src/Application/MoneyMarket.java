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
public class MoneyMarket extends Savings {

	public MoneyMarket(Profile holder, double balance) {
		super(holder, balance);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		return str + "something else";
	}

}
