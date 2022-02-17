package Application;

import java.util.Scanner;

public class BankTeller {
	
	private Account account;

	private static final int COMMAND_TOKEN_INDEX = 0;
	private static final int O_COMMAND_TOKEN_COUNT = 7;
	private static final int C_COMMAND_TOKEN_COUNT = 7;
	private static final int P_COMMAND_TOKEN_COUNT = 1;
	private static final int PT_COMMAND_TOKEN_COUNT = 1;
	private static final int PI_COMMAND_TOKEN_COUNT = 1;
	private static final int CP_COMMAND_TOKEN_COUNT = 4;
	private static final int Q_COMMAND_TOKEN_COUNT = 1;
	private static final int B_COMMAND_DOB_TOKEN_INDEX = 1;
	private static final int B_COMMAND_FNAME_TOKEN_INDEX = 2;
	private static final int B_COMMAND_LNAME_TOKEN_INDEX = 3;
	private static final int B_COMMAND_D_TOKEN_INDEX = 4;
	private static final int B_COMMAND_T_TOKEN_INDEX = 5;
	private static final int B_COMMAND_L_TOKEN_INDEX = 6;
	private static final int C_COMMAND_DOB_TOKEN_INDEX = 1;
	private static final int C_COMMAND_FNAME_TOKEN_INDEX = 2;
	private static final int C_COMMAND_LNAME_TOKEN_INDEX = 3;
	private static final int C_COMMAND_D_TOKEN_INDEX = 4;
	private static final int C_COMMAND_T_TOKEN_INDEX = 5;
	private static final int C_COMMAND_L_TOKEN_INDEX = 6;
	private static final int CP_COMMAND_DOB_TOKEN_INDEX = 1;
	private static final int CP_COMMAND_FNAME_TOKEN_INDEX = 2;
	private static final int CP_COMMAND_LNAME_TOKEN_INDEX = 3;
	private static final int GREATER = 1;
	private static final int LESSER = -1;
	
	public void run() {
		System.out.println("Bank Teller is running.");
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String line = Util.readLine(scanner);
			String[] tokens = Util.tokenize(line, ' ');
			if (handleTokens(tokens)) {
				System.out.println();
				break;
			}
		}
		scanner.close();
	}
	
	/**
	 * This is the handleTokens method.
	 * 
	 * @param tokens The tokens.
	 * @return true if ended.
	 */
	private boolean handleTokens(String[] tokens) {
		int n = tokens.length;
		if ((n == O_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("O"))) {
			b1(tokens);
		}
		else if ((n == C_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("C"))) { //closeAccount sets account to close, balance to 0, isLoyalAccount to false. Remain
			closeAccount(tokens);																//in database and can be reopened later
		}
		else if ((n == D_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("D"))) { //D calls the deposit
			AccountDatabase.deposit(tokens);																
		}
		else if ((n == W_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("W"))) { //W calls the withdraw
			AccountDatabase.withdraw(tokens);																
		}
		else if ((n == P_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("P"))) { //prints all accounts in database in current order
			AccountDatabase.print();
		}
		else if ((n == PT_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("PT"))) { //prints all accounts in database ordered by account type
			AccountDatabase.printByAccountType();
		}
		else if ((n == PI_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("PI"))) { //prints all accounts in database with calculated fees and monthly interests
			AccountDatabase.printFeeAndInterest();
		}
		else if ((n == CP_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("UB"))) {// UB updates balances for all accounts with calculated fees and monthly interests
			cp(tokens);																		   // and displays all the accounts in the database with the updated balances.
		}
		else if ((n == Q_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("Q"))) {
			System.out.println("Bank Teller is terminated.");
			return true;
		}
		else {
			System.out.println("Invalid command!");
		}
		return false;
	}
	
	/**
	 * This is the b1 method
	 * 
	 * @param tokens the tokens.
	 */
	private void b1(String[] tokens) {
		Date dob = new Date(tokens[B_COMMAND_DOB_TOKEN_INDEX]);
		Date d = new Date(tokens[B_COMMAND_D_TOKEN_INDEX]);
		Time t = new Time(tokens[B_COMMAND_T_TOKEN_INDEX]);
		Timeslot ts = new Timeslot(d, t);
		Location l = Util.stringToLocation(tokens[B_COMMAND_L_TOKEN_INDEX].toUpperCase());
		b2(tokens, dob, d, t, ts, l);
	}

	/**
	 * This is the b2 method.
	 * 
	 * @param tokens the tokens
	 * @param dob    the dob
	 * @param d      the d
	 * @param t      the t
	 * @param ts     the ts
	 * @param l      the l
	 */
	//dob,
	private void b2(String[] tokens, Date dob, Date d, Time t, Timeslot ts, Location l) {
		Date today = new Date();
		if (!withdraw.isValid()) {
			System.out.println("Invalid withdrawal. Withdrawal amount is greater than account balance.");
			return;
		}
		if(!deposit.isValid()) {
			System.out.println("");
		}	
		if (dob.compareTo(today) != LESSER) {
			System.out.println("Date of birth invalid -> it is a future date.");
			return;
		}
		if (!d.isValid() || !d.thisYear()) {
			System.out.println("Invalid appointment date!");
			return;
		}
		if (d.compareTo(today) != GREATER) {
			System.out.println("AccountDatabase date invalid -> must be a future date.");
			return;
		}
		if (!t.isValid()) {
			System.out.println(
					"Invalid appointment time! Must enter a time between 9:00 and 16:45 with a 15-minute interval.");
			return;
		}
		if (l == Location.INVALID) {
			System.out.println("Invalid location!");
			return;
		}
		b3(tokens, dob, ts, l);
	}

	/**
	 * This is the b3 method, which checks to see if we can add an account to the database.
	 * 
	 * @param tokens the tokens
	 * @param dob    the dob
	 * @param ts     the ts
	 * @param l      the l
	 */
	private void b3(String[] tokens, Date dob, Timeslot ts, Location l) {
		Profile p = new Profile(tokens[B_COMMAND_FNAME_TOKEN_INDEX], tokens[B_COMMAND_LNAME_TOKEN_INDEX], dob);
		AccountDatabase a = new AccountDatabase(p, ts, l);
		int check = account.checkAdd(a);
		if (check == Account.CHECK_ADD_OK) {
			this.account.add(a);
			System.out.println("AccountDatabase booked and added to the account.");
		} else if (check == Account.CHECK_ADD_CASE_ONE) {
			System.out.println("Same appointment exists in the account.");
		} else if (check == Account.CHECK_ADD_CASE_TWO) {
			System.out.println("Time slot has been taken at this location.");
		} else if (check == Account.CHECK_ADD_CASE_THREE) {
			System.out.println("Same patient cannot book an appointment with the same date.");
		}
	}

	/**
	 * This is the closeAccount method.
	 * 
	 * @param tokens Object of type String[]
	 */
	private void closeAccount(String[] tokens) {
		Date dob = new Date(tokens[C_COMMAND_DOB_TOKEN_INDEX]);
		Date d = new Date(tokens[C_COMMAND_D_TOKEN_INDEX]);
		Time t = new Time(tokens[C_COMMAND_T_TOKEN_INDEX]);
		Timeslot ts = new Timeslot(d, t);
		Location l = Util.stringToLocation(tokens[C_COMMAND_L_TOKEN_INDEX].toUpperCase());
		Profile p = new Profile(tokens[C_COMMAND_FNAME_TOKEN_INDEX], tokens[C_COMMAND_LNAME_TOKEN_INDEX], dob);
		AccountDatabase a = new AccountDatabase(p, ts, l);
		if (account.checkRemove(a)) {
			this.account.remove(a);
			System.out.println("AccountDatabase cancelled.");
		} else {
			System.out.println("Not cancelled, appointment does not exist.");
		}
	}

	/**
	 * This is the cp method.
	 * 
	 * @param tokens the tokens.
	 */
	private void cp(String[] tokens) {
		Date dob = new Date(tokens[CP_COMMAND_DOB_TOKEN_INDEX]);
		Profile p = new Profile(tokens[CP_COMMAND_FNAME_TOKEN_INDEX], tokens[CP_COMMAND_LNAME_TOKEN_INDEX], dob);
		AccountDatabase a = new AccountDatabase(p, null, null);
		account.removeProfile(a);
		System.out.println("All appointments for " + p.toString() + " have been cancelled.");
	}
	
	//have to write method for checking to see if input is valid/invalid, especially campuscode
}

}
