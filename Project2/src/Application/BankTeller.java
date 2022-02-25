package Application;

import java.util.Scanner;

/**
 * BankTeller holds the logic for getting and setting variables in the BankTeller class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class BankTeller {
	
	/**
	 * Creates a variable for interfacing with the account database.
	 */
	private AccountDatabase accountDatabase;

	/**
	 * This is COMMAND_TOKEN_INDEX
	 */
	private static final int COMMAND_TOKEN_INDEX = 0;

	/**
	 * This is Q_COMMAND_TOKEN_COUNT
	 */
	private static final int Q_COMMAND_TOKEN_COUNT = 1;

	/**
	 * This is O_COMMAND_MINIMAL_TOKEN_COUNT
	 */
	private static final int O_COMMAND_MINIMAL_TOKEN_COUNT = 6;
	/**
	 * This is O_COMMAND_MAXIMAL_TOKEN_COUNT
	 */
	private static final int O_COMMAND_MAXIMAL_TOKEN_COUNT = 7;
	/**
	 * This is C_COMMAND_TOKEN_COUNT
	 */
	private static final int C_COMMAND_TOKEN_COUNT = 5;
	/**
	 * This is D_COMMAND_TOKEN_COUNT
	 */
	private static final int D_COMMAND_TOKEN_COUNT = 6;
	/**
	 * This is W_COMMAND_TOKEN_COUNT
	 */
	private static final int W_COMMAND_TOKEN_COUNT = 6;
	/**
	 * This is P_COMMAND_TOKEN_COUNT
	 */
	private static final int P_COMMAND_TOKEN_COUNT = 1;
	/**
	 * This is PT_COMMAND_TOKEN_COUNT
	 */
	private static final int PT_COMMAND_TOKEN_COUNT = 1;
	/**
	 * This is PI_COMMAND_TOKEN_COUNT
	 */
	private static final int PI_COMMAND_TOKEN_COUNT = 1;
	/**
	 * This is UB_COMMAND_TOKEN_COUNT
	 */
	private static final int UB_COMMAND_TOKEN_COUNT = 1;
	/**
	 * This is O_COMMAND_ACCOUNT_TYPE_INDEX
	 */
	private static final int O_COMMAND_ACCOUNT_TYPE_INDEX = 1;
	/**
	 * This is O_COMMAND_FNAME_TOKEN_INDEX
	 */
	private static final int O_COMMAND_FNAME_TOKEN_INDEX = 2;
	/**
	 * This is O_COMMAND_LNAME_TOKEN_INDEX
	 */
	private static final int O_COMMAND_LNAME_TOKEN_INDEX = 3;
	/**
	 * This is O_COMMAND_DOB_TOKEN_INDEX
	 */
	private static final int O_COMMAND_DOB_TOKEN_INDEX = 4;
	/**
	 * This is O_COMMAND_DEPOSIT_TOKEN_INDEX
	 */
	private static final int O_COMMAND_DEPOSIT_TOKEN_INDEX = 5;
	/**
	 * This is O_COMMAND_CAMPUS_CODE_TOKEN_INDEX
	 */
	private static final int O_COMMAND_CAMPUS_CODE_TOKEN_INDEX = 6;
	/**
	 * This is O_COMMAND_SAVING_CODE_TOKEN_INDEX
	 */
	private static final int O_COMMAND_SAVING_CODE_TOKEN_INDEX = 6;
	/**
	 * This is LESSER
	 */
	private static final int LESSER = -1;
	/**
	 * This is INVALID_CAMPUS_CODE
	 */
	private static final int INVALID_CAMPUS_CODE = -1;
	/**
	 * This is INVALID_SAVING_CODE
	 */
	private static final int INVALID_SAVING_CODE = -1;
	/**
	 * This is SAVING_CODE_NON_LOYAL
	 */
	private static final int SAVING_CODE_NON_LOYAL = 0;
	/**
	 * This is SAVING_CODE_LOYAL
	 */
	private static final int SAVING_CODE_LOYAL = 1;
	/**
	 * This is C_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX
	 */
	private static final int C_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX = 1;
	/**
	 * This is C_COMMAND_FNAME_TOKEN_INDEX
	 */
	private static final int C_COMMAND_FNAME_TOKEN_INDEX = 2;
	/**
	 * This is C_COMMAND_LNAME_TOKEN_INDEX
	 */
	private static final int C_COMMAND_LNAME_TOKEN_INDEX = 3;
	/**
	 * This is C_COMMAND_DOB_TOKEN_INDEX
	 */
	private static final int C_COMMAND_DOB_TOKEN_INDEX = 4;
	/**
	 * This is D_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX
	 */
	private static final int D_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX = 1;
	/**
	 * This is D_COMMAND_FNAME_TOKEN_INDEX
	 */
	private static final int D_COMMAND_FNAME_TOKEN_INDEX = 2;
	/**
	 * This is D_COMMAND_LNAME_TOKEN_INDEX
	 */
	private static final int D_COMMAND_LNAME_TOKEN_INDEX = 3;
	/**
	 * This is D_COMMAND_DOB_TOKEN_INDEX
	 */
	private static final int D_COMMAND_DOB_TOKEN_INDEX = 4;
	/**
	 * This is D_COMMAND_AMOUNT_TOKEN_INDEX
	 */
	private static final int D_COMMAND_AMOUNT_TOKEN_INDEX = 5;
	/**
	 * This is W_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX
	 */
	private static final int W_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX = 1;
	/**
	 * This is W_COMMAND_FNAME_TOKEN_INDEX
	 */
	private static final int W_COMMAND_FNAME_TOKEN_INDEX = 2;
	/**
	 * This is W_COMMAND_LNAME_TOKEN_INDEX
	 */
	private static final int W_COMMAND_LNAME_TOKEN_INDEX = 3;
	/**
	 * This is W_COMMAND_DOB_TOKEN_INDEX
	 */
	private static final int W_COMMAND_DOB_TOKEN_INDEX = 4;
	/**
	 * This is W_COMMAND_AMOUNT_TOKEN_INDEX
	 */
	private static final int W_COMMAND_AMOUNT_TOKEN_INDEX = 5;
	/**
	 * This is NO_TOKENS
	 */
	private static final int NO_TOKENS = 0;
	/**
	 * This is ZERO_AMOUNT
	 */
	private static final double ZERO_AMOUNT = 0;

	/**
	 * This is the BankTeller constructor.
	 */
	public BankTeller() {
		this.accountDatabase = new AccountDatabase();
	}

	/**
	 * This is the main method.
	 * @param args Object of type String[].
	 */
	public static void main(String[] args) {
		new BankTeller().run();
	}

	/**
	 * This is the run method.
	 */
	private void run() {
		System.out.println("Bank Teller is running.");
		System.out.println();
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String line = Util.readLine(scanner).replace('\t', ' ');
			String[] tokens = Util.tokenize(line, ' ');
			if (handleTokens(tokens)) {
				break;
			}
		}
		scanner.close();
	}

	/**
	 * This is the handleTokens method, which handles the user input command.
	 * @param tokens Object of type String[].
	 * @return true if ended, false if no tokens inputted.
	 */
	private boolean handleTokens(String[] tokens) {
		int n = tokens.length;
		if (n == NO_TOKENS) {
			return false;
		}
		if (tokens[COMMAND_TOKEN_INDEX].equals("O")) {
			OA(tokens);
		} else if (tokens[COMMAND_TOKEN_INDEX].equals("C")) {
			if (n < C_COMMAND_TOKEN_COUNT) {
				System.out.println("Missing data for closing an account.");
			} else {
				C(tokens);
			}
		} else if ((n == D_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("D"))) {
			D(tokens);
		} else if ((n == W_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("W"))) {
			W(tokens);
		} else if ((n == P_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("P"))) {
			P(tokens);
		} else if ((n == PT_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("PT"))) {
			PT(tokens);
		} else if ((n == PI_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("PI"))) {
			PI(tokens);
		} else if ((n == UB_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("UB"))) {
			UB(tokens);
		} else if ((n == Q_COMMAND_TOKEN_COUNT) && (tokens[COMMAND_TOKEN_INDEX].equals("Q"))) {
			System.out.println("Bank Teller is terminated. ");
			return true;
		} else {
			System.out.println("Invalid command!");
		}
		return false;
	}

	/**
	 * This is the OA method, which checks to see if we can open the account.
	 * @param tokens Object of type String[]
	 */
	private void OA(String[] tokens) {
		if (tokens.length < O_COMMAND_MINIMAL_TOKEN_COUNT) {
			System.out.println("Missing data for opening an account.");
			return;
		}
		String accountType = tokens[O_COMMAND_ACCOUNT_TYPE_INDEX];
		if (accountType.equals("CC") || accountType.equals("S")) {
			if (tokens.length != O_COMMAND_MAXIMAL_TOKEN_COUNT) {
				System.out.println("Missing data for opening an account.");
				return;
			}
		} else {
			if (tokens.length != O_COMMAND_MINIMAL_TOKEN_COUNT) {
				System.out.println("Invalid command!");
				return;
			}
		}
		Date dob = new Date(tokens[O_COMMAND_DOB_TOKEN_INDEX]);
		Date today = new Date();
		if (!dob.isValid()) {
			System.out.println("Date of birth invalid.");
			return;
		}
		OB(tokens, accountType, dob, today);
	}

	/**
	 * This is the OB method, which takes care of additional edge cases for opening an account.
	 * @param tokens Object of type String[], accountType Object of type String, dob Object of type Date, today Object of type Date.
	 */
	private void OB(String[] tokens, String accountType, Date dob, Date today) {
		if (dob.compareTo(today) != LESSER) {
			System.out.println("Date of birth invalid.");
			return;
		}
		String depositString = tokens[O_COMMAND_DEPOSIT_TOKEN_INDEX];
		if (!Util.isDouble(depositString)) {
			System.out.println("Not a valid amount.");
			return;
		}
		double deposit = Double.parseDouble(depositString);
		if (deposit <= ZERO_AMOUNT) {
			System.out.println("Initial deposit cannot be 0 or negative.");
			return;
		}
		int campusCode = INVALID_CAMPUS_CODE;
		int savingCode = INVALID_SAVING_CODE;
		if (accountType.equals("CC")) {
			String campusCodeString = tokens[O_COMMAND_CAMPUS_CODE_TOKEN_INDEX];
			if (!Util.isInteger(campusCodeString)) {
				System.out.println("Invalid campus code.");
				return;
			}
			campusCode = Integer.parseInt(campusCodeString);
			if ((campusCode != CollegeChecking.NEW_BRUNSWICK) && (campusCode != CollegeChecking.NEWARK)
					&& (campusCode != CollegeChecking.CAMDEN)) {
				System.out.println("Invalid campus code.");
				return;
			}
		}
		OC(tokens, accountType, dob, deposit, campusCode, savingCode);
	}

	/**
	 * This is the OC method, which takes care of some additional edge cases for opening an account.
	 * @param tokens Object of type String[], accountType of type String, dob Object of type Date, deposit Object of type double
	 * @param campusCode Object of type int, savingCode Object of type int.
	 */
	private void OC(String[] tokens, String accountType, Date dob, double deposit, int campusCode, int savingCode) {
		if (accountType.equals("S")) {
			String savingCodeString = tokens[O_COMMAND_SAVING_CODE_TOKEN_INDEX];
			if (!Util.isInteger(savingCodeString)) {
				System.out.println("Invalid saving code.");
				return;
			}
			savingCode = Integer.parseInt(savingCodeString);
			if ((savingCode != SAVING_CODE_NON_LOYAL) && (savingCode != SAVING_CODE_LOYAL)) {
				System.out.println("Invalid saving code.");
				return;
			}
		}
		if (accountType.equals("MM") && (deposit < MoneyMarket.MINIMAL_LOYAL_BALANCE)) {
			System.out.println("Minimum of $2500 to open a MoneyMarket account.");
			return;
		}
		Profile profile = new Profile(tokens[O_COMMAND_FNAME_TOKEN_INDEX], tokens[O_COMMAND_LNAME_TOKEN_INDEX], dob);
		Account account = createAccount(accountType, profile, campusCode, savingCode);
		int check = accountDatabase.checkOpen(account);
		if (check == AccountDatabase.OPEN_OK) {
			accountDatabase.open(account);
			account.deposit(deposit);
			System.out.println("Account opened.");
		} else if (check == AccountDatabase.OPEN_REOPEN_OK) {
			account = accountDatabase.getAccount(account);
			account.closed = false;
			if (accountType.equals("CC")) {
				((CollegeChecking) account).campusCode = campusCode;
			}
			if (accountType.equals("MM") && deposit > MoneyMarket.MINIMAL_LOYAL_BALANCE) {
				((MoneyMarket) account).loyal = true;
			}
			account.deposit(deposit);
			System.out.println("Account reopened.");
		} else {
			System.out.println(profile.toString() + " same account(type) is in the database.");
		}
	}

	/**
	 * This is the C method, which deals with closing an account.
	 * @param tokens Object of type String[].
	 */
	private void C(String[] tokens) {
		String accountType = tokens[C_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX];
		Date dob = new Date(tokens[C_COMMAND_DOB_TOKEN_INDEX]);
		Profile profile = new Profile(tokens[C_COMMAND_FNAME_TOKEN_INDEX], tokens[C_COMMAND_LNAME_TOKEN_INDEX], dob);
		Account account = createAccount(accountType, profile, INVALID_CAMPUS_CODE, INVALID_SAVING_CODE);
		if (this.accountDatabase.close(account)) {
			System.out.println("Account closed.");
		} else {
			System.out.println("Account is closed already.");
		}
	}

	/**
	 * This is the D method, which deals with depositing into a given account.
	 * @param tokens Object of type String[].
	 */
	private void D(String[] tokens) {
		String accountType = tokens[D_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX];
		Date dob = new Date(tokens[D_COMMAND_DOB_TOKEN_INDEX]);
		String fname = tokens[D_COMMAND_FNAME_TOKEN_INDEX];
		String lname = tokens[D_COMMAND_LNAME_TOKEN_INDEX];
		String amountString = tokens[D_COMMAND_AMOUNT_TOKEN_INDEX];
		if (!Util.isDouble(amountString)) {
			System.out.println("Not a valid amount.");
			return;
		}
		double amount = Double.parseDouble(amountString);
		if (amount <= ZERO_AMOUNT) {
			System.out.println("Deposit - amount cannot be 0 or negative.");
			return;
		}
		Profile profile = new Profile(fname, lname, dob);
		Account account = createAccount(accountType, profile, INVALID_CAMPUS_CODE, INVALID_SAVING_CODE);
		account.deposit(amount);
		if (this.accountDatabase.getAccount(account) == null) {
			System.out.println(fname + " " + lname + " " + dob + " "
					+ account.getType().replace("Money Market Savings", "Money Market") + " is not in the database.");
		} else {
			this.accountDatabase.deposit(account);
			System.out.println("Deposit - balance updated.");
		}
	}

	/**
	 * This is the W method, which deals with withdrawing from a certain account.
	 * @param tokens Object of type String[].
	 */
	private void W(String[] tokens) {
		String accountType = tokens[W_COMMAND_ACCOUNT_TYPE_TOKEN_INDEX];
		Date dob = new Date(tokens[W_COMMAND_DOB_TOKEN_INDEX]);
		String fname = tokens[W_COMMAND_FNAME_TOKEN_INDEX];
		String lname = tokens[W_COMMAND_LNAME_TOKEN_INDEX];
		String amountString = tokens[W_COMMAND_AMOUNT_TOKEN_INDEX];
		if (!Util.isDouble(amountString)) {
			System.out.println("Not a valid amount.");
			return;
		}
		double amount = Double.parseDouble(amountString);
		if (amount <= ZERO_AMOUNT) {
			System.out.println("Withdraw - amount cannot be 0 or negative.");
			return;
		}
		Profile profile = new Profile(fname, lname, dob);
		Account account = createAccount(accountType, profile, INVALID_CAMPUS_CODE, INVALID_SAVING_CODE);
		account.deposit(amount);
		if (this.accountDatabase.getAccount(account) == null) {
			System.out.println(fname + " " + lname + " " + dob + " "
					+ account.getType().replace("Money Market Savings", "Money Market") + " is not in the database.");
		} else {
			if (this.accountDatabase.withdraw(account)) {
				System.out.println("Withdraw - balance updated.");
			} else {
				System.out.println("Withdraw - insufficient fund.");
			}
		}
	}

	/**
	 * This is the P method, which deals with displaying all the accounts in the database in the current order.
	 * @param tokens Object of type String[].
	 */
	private void P(String[] tokens) {
		this.accountDatabase.print();
	}

	/**
	 * This is the PT method, which deals with displaying all the accounts in the database, ordered by account type..
	 * @param tokens Object of type String[].
	 */
	private void PT(String[] tokens) {
		this.accountDatabase.printByAccountType();
	}

	/**
	 * This is the PI method, which deals with displaying all the account in the database, with calculated fees and monthly interests.
	 * @param tokens Object of type String[].
	 */
	private void PI(String[] tokens) {
		this.accountDatabase.printFeeAndInterest();
	}

	/**
	 * This is the UB method, which deals displaying all the accounts in the database with updated balances. 
	 * @param tokens Object of type String[].
	 */
	private void UB(String[] tokens) {
		this.accountDatabase.updateBalance();
	}

	/**
	 * This is the createAccount method, which designates what type of account will be made.
	 * @param accountType Object of type String, profile Object of type Profile, campusCode Object of type int, savingCode Object of type int.
	 * @return the account.
	 */
	private Account createAccount(String accountType, Profile profile, int campusCode, int savingCode) {
		Account account = null;
		if (accountType.equals("C")) {
			account = new Checking(profile);
		} else if (accountType.equals("CC")) {
			account = new CollegeChecking(profile, campusCode);
		} else if (accountType.equals("S")) {
			account = new Savings(profile, savingCode == SAVING_CODE_LOYAL);
		} else if (accountType.equals("MM")) {
			account = new MoneyMarket(profile);
		}
		return account;
	}
}
