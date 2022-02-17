package Application;

import java.util.Scanner;

public class BankTeller {
	
	
	//new > JUnit Test Class
	private Account account;

	private static final int COMMAND_TOKEN_INDEX = 0;
	private static final int O_COMMAND_TOKEN_COUNT = 7;
	private static final int C_COMMAND_TOKEN_COUNT = 7;
	private static final int P_COMMAND_TOKEN_COUNT = 1;
	private static final int PT_COMMAND_TOKEN_COUNT = 1;
	private static final int PI_COMMAND_TOKEN_COUNT = 1;
	private static final int UB_COMMAND_TOKEN_COUNT = 4;
	private static final int Q_COMMAND_TOKEN_COUNT = 1;
	private static final int O_COMMAND_DOB_TOKEN_INDEX = 1;
	private static final int O_COMMAND_FNAME_TOKEN_INDEX = 2;
	private static final int O_COMMAND_LNAME_TOKEN_INDEX = 3;
	private static final int O_COMMAND_D_TOKEN_INDEX = 4;
	private static final int O_COMMAND_T_TOKEN_INDEX = 5;
	private static final int O_COMMAND_L_TOKEN_INDEX = 6;
	private static final int C_COMMAND_DOB_TOKEN_INDEX = 1;
	private static final int C_COMMAND_FNAME_TOKEN_INDEX = 2;
	private static final int C_COMMAND_LNAME_TOKEN_INDEX = 3;
	private static final int C_COMMAND_D_TOKEN_INDEX = 4;
	private static final int C_COMMAND_T_TOKEN_INDEX = 5;
	private static final int C_COMMAND_L_TOKEN_INDEX = 6;
	private static final int UB_COMMAND_DOB_TOKEN_INDEX = 1;
	private static final int UB_COMMAND_FNAME_TOKEN_INDEX = 2;
	private static final int UB_COMMAND_LNAME_TOKEN_INDEX = 3;
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
			openAccount(tokens);
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
		else if ((n == UB_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("UB"))) {// UB updates balances for all accounts with calculated fees and monthly interests
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
	 * This is the openAccount method, which will start the process of adding an account to the database.
	 * 
	 * @param tokens the tokens.
	 */
	private void openAccount(String[] tokens) {
		Date dob = new Date(tokens[O_COMMAND_DOB_TOKEN_INDEX]);
		Profile profile = new Profile(tokens[O_COMMAND_PROFILE_TOKEN_INDEX]);
		String type = new String(tokens[O_COMMAND_TYPE_TOKEN_INDEX]);
		double initialDeposit = new double(token[O_COMMAND_DEPOSIT_TOKEN_INDEX]); //not very sure
		Location l = Util.stringToLocation(tokens[B_COMMAND_L_TOKEN_INDEX].toUpperCase()); //B_COMMAND_L should prob be O_COMMAND_DEPOSIT
		openCheckInput(tokens, dob, profile, type, initalDeposit);
	}

	/**
	 * This is the openCheckInput method. Checks to see if the account trying to be opened is input correctly.
	 * have to have param about dob, balance, if account already exists, initial deposit, withdrawal amount, database is empty, invalid campus code, minimum for moneymarket,
	 * invalid command, not a valid amount, missing data for opening account, account closed/opened, account is closed already, account reopoened, deposit - balance updated, 
	 * deposit - amount cant be 0 or negative, withdraw - balance updated, withdraw - insufficient fund
	 * Might need to tweak, the errors should be the ones associated with opening an account.
	 * @param tokens the tokens
	 * @param dob    the dob
	 * @param d      the d, instead of date it should be balance
	 * @param t      the t, instead of time it should be 
	 * @param ts     the ts, instead of timeslot it should be 
	 * @param l      the l, instead of location it should be 
	 */
	//dob,
	private void openCheckInput(String[] tokens, Date dob, Profile profile, String type, double initialDeposit) {
		
		
		if (!dob.isValid()) {
			System.out.println("Date of birth invalid.");
			return;
		}
		if (dob.compareTo(today) != LESSER) {
			System.out.println("Invalid date of birth, it is a future date.");
			return;
		}
		if (this.type.contains("Money Market") && initialDeposit < 2500) {
			System.out.println("Minimum of $2500 to open a MoneyMarket account.");
			return;
		}
		if(!initialDeposit >= 0) {
			System.out.println("Initial deposit cannot be 0 or negative.")
		}
		if (!) {
			System.out.println(
					"Invalid appointment time! Must enter a time between 9:00 and 16:45 with a 15-minute interval.");
			return;
		}
		if (l == Location.INVALID) {
			System.out.println("Invalid location!");
			return;
		}
		openAddAccount(tokens, dob, profile, l);
	}

	/**
	 * This is the openAddAccount method, which checks to see if we can add an account to the database, and does so if we can.
	 * 
	 * @param tokens the tokens
	 * @param dob    the dob
	 * @param ts     the ts
	 * @param l      the l
	 */
	private void openAddAccount(String[] tokens, Date dob, Timeslot ts, Location l) {
		Profile profile = new Profile(tokens[B_COMMAND_FNAME_TOKEN_INDEX], tokens[B_COMMAND_LNAME_TOKEN_INDEX], dob);
		Account account = new Account(profile, ts, l);
		int check = AccountDatabase.checkAdd(account);
		if (check == AccountDatabase.CHECK_ADD_OK) {
			this.account.add(account);
			System.out.println("Account opened.");
		} else if (check == AccountDatabase.CHECK_ADD_CASE_ONE) {
			System.out.println(holder + "same account (type) is in the database."); //have to add case for missing data
		}
		/*
		else if (check == Account.CHECK_ADD_CASE_TWO) {
			System.out.println("Time slot has been taken at this location.");
		} else if (check == Account.CHECK_ADD_CASE_THREE) {
			System.out.println("Same patient cannot book an appointment with the same date.");
		}
		*/
	}
	
	/**
	 * 
	 */
	private void checkDeposit(String[] tokens, double initialDeposit) {
		
	}
	
	/**
	 * 
	 */
	private void checkWithdrawal(String[] tokens, double balance) {
		
	}

	/**
	 * This is the closeAccount method.
	 * 
	 * @param tokens Object of type String[]
	 */
	private void closeAccount(String[] tokens) {
		//instead of dob, date, and timeslot it should be holder (contains fname, lname, dob), closed, and balance
		Date dob = new Date(tokens[C_COMMAND_DOB_TOKEN_INDEX]);
		Date d = new Date(tokens[C_COMMAND_D_TOKEN_INDEX]);
		Time t = new Time(tokens[C_COMMAND_T_TOKEN_INDEX]);
		Timeslot ts = new Timeslot(d, t);
		Location l = Util.stringToLocation(tokens[C_COMMAND_L_TOKEN_INDEX].toUpperCase());
		Profile profile = new Profile(tokens[C_COMMAND_FNAME_TOKEN_INDEX], tokens[C_COMMAND_LNAME_TOKEN_INDEX], dob);
		Account account = new Account(profile, ts, l);
		if (account.checkRemove(account)) {
			this.account.close(account);
			System.out.println("Account closed.");
		} else {
			System.out.println("Account is closed already.");
		}
	}

	/**
	 * This is the cp(UB) method.
	 * 
	 * @param tokens the tokens.
	 */
	private void cp(String[] tokens) {
		Date dob = new Date(tokens[UB_COMMAND_DOB_TOKEN_INDEX]);
		Profile p = new Profile(tokens[UB_COMMAND_FNAME_TOKEN_INDEX], tokens[UB_COMMAND_LNAME_TOKEN_INDEX], dob);
		AccountDatabase a = new AccountDatabase(p, null, null);
		account.close(a);
		System.out.println("All appointments for " + p.toString() + " have been cancelled.");
	}
	
	//have to write method for checking to see if input is valid/invalid, especially campuscode
}

}
