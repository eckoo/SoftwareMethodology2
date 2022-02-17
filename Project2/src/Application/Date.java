package Application;

import java.util.Calendar;

/**
 *  Date holds the logic for getting and setting variables in the Date class.
 *
 *  @author Kiernan King and Ahmed Alghazwi
 */
public class Date implements Comparable<Date> {	//copied from Project1, per instructions in document, have to go back and import it tho
	private int year;
	private int month;
	private int day;

	private static final int JANUARY = 1;
	private static final int FEBRUARY = 2;
	private static final int MARCH = 3;
	private static final int MAY = 5;
	private static final int JULY = 7;
	private static final int AUGUST = 8;
	private static final int OCTOBER = 10;
	private static final int DECEMBER = 12;
	private static final int SHORT_MONTH = 30;
	private static final int LONG_MONTH = 31;
	private static final int SHORT_FEBRUARY = 28;
	private static final int LONG_FEBRUARY = 29;

	private static final int QUADRENNIAL = 4;
	private static final int CENTENNIAL = 100;
	private static final int QUATERCENTENNIAL = 400;

	private static final int INVALID_YEAR = 0;
	private static final int MIN_DAY = 0;
	private static final int NUMBER_OF_TOKENS = 3;
	private static final int MONTH_TOKEN_INDEX = 0;
	private static final int DAY_TOKEN_INDEX = 1;
	private static final int YEAR_TOKEN_INDEX = 2;
	
	private static final int CALENDAR_API_CORRECTION_OFFSET = 1;
	
	private static final int GREATER = 1;
	private static final int LESSER = -1;
	private static final int EQUALS = 0;
	
	private static final int DIVISIBLE_ZERO = 0;

	/**
	 * This is the date constructor.
	 * 
	 * @param date The date
	 */
	public Date(String date) {
		int[] tokens = Util.tokenizeIntegers(date, '/');
		if (tokens == null) {
			year = INVALID_YEAR;
		} else if (tokens.length != NUMBER_OF_TOKENS) {
			year = INVALID_YEAR;
		} else {
			month = tokens[MONTH_TOKEN_INDEX];
			day = tokens[DAY_TOKEN_INDEX];
			year = tokens[YEAR_TOKEN_INDEX];
			check();
		}
	}

	/**
	 * This is the date constructor.
	 */
	public Date() {
		Calendar c = Calendar.getInstance();
		this.year = c.get(Calendar.YEAR);
		this.month = c.get(Calendar.MONTH) + CALENDAR_API_CORRECTION_OFFSET;
		this.day = c.get(Calendar.DAY_OF_MONTH);
		check();
	}

	/**
	 * This is the thisYear method
	 * 
	 * @return true if this year.
	 */
	public boolean thisYear() {
		return this.year <= new Date().year;
	}

	/**
	 * This is the isValid method
	 * 
	 * @return true if is valid.
	 */
	public boolean isValid() {
		return year != INVALID_YEAR;
	}

	/**
	 * This is the toString method.
	 * 
	 * @return the string.
	 */
	@Override
	public String toString() {
		return this.month + "/" + this.day + "/" + this.year;
	}

	/**
	 * This is the equals method.
	 * 
	 * @param obj the object.
	 * @return true if equals.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Date) {
			Date date = (Date) obj;
			if (this.year != date.year) {
				return false;
			}
			if (this.month != date.month) {
				return false;
			}
			if (this.day != date.day) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * compareTo compares our date objects to see whether or not they are valid.
	 * 
	 * @param date the another object.
	 * @return what the contract of compareTo is supposed to output.
	 */
	@Override
	public int compareTo(Date date) {
		if (this.year < date.year) {
			return LESSER;
		}
		if (this.year > date.year) {
			return GREATER;
		}
		if (this.month < date.month) {
			return LESSER;
		}
		if (this.month > date.month) {
			return GREATER;
		}
		if (this.day < date.day) {
			return LESSER;
		}
		if (this.day > date.day) {
			return GREATER;
		}
		return EQUALS;
	}

	/**
	 * This is the check method.
	 */
	private void check() {
		int minDay = MIN_DAY;
		if (month < JANUARY || month > DECEMBER) {
			year = INVALID_YEAR;
			return;
		}
		int maxDay = SHORT_MONTH;
		switch (month) {
		case JANUARY:
		case MARCH:
		case MAY:
		case JULY:
		case AUGUST:
		case OCTOBER:
		case DECEMBER:
			maxDay = LONG_MONTH;
			break;
		}
		if (month == FEBRUARY) {
			maxDay = leap(year) ? LONG_FEBRUARY : SHORT_FEBRUARY;
		}
		year = (day >= minDay && day <= maxDay) ? year : INVALID_YEAR;
	}

	/**
	 * This is the leap method
	 * 
	 * @param year The year
	 * @return true if leap
	 */
	private static boolean leap(int year) {
		if (year % QUADRENNIAL != DIVISIBLE_ZERO) {
			return false;
		}
		if (year % CENTENNIAL != DIVISIBLE_ZERO) {
			return true;
		}
		return (year % QUATERCENTENNIAL == DIVISIBLE_ZERO);
	}

	/**
	 * This is the test main method.
	 *
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		boolean pass = true;
		pass = pass && new Date("10/24/2010").isValid();
		pass = pass && new Date("2/8/1997").isValid();
		pass = pass && !new Date("3/34/2041").isValid();
		pass = pass && !new Date("-1/32/2004").isValid();
		pass = pass && new Date("4/10/2023").isValid();
		pass = pass && new Date("1/30/1994").isValid();
		pass = pass && new Date("2/18/1991").isValid();
		pass = pass && new Date("11/22/2038").isValid();
		pass = pass && new Date("7/18/2002").isValid();
		pass = pass && new Date("9/18/2032").isValid();
		pass = pass && !new Date("2/32/1995").isValid();
		pass = pass && !new Date("-1/17/2037").isValid();
		pass = pass && new Date("5/13/1975").isValid();
		pass = pass && new Date("2/10/1985").isValid();
		pass = pass && !new Date("2/33/2005").isValid();
		pass = pass && new Date("1/11/2041").isValid();
		pass = pass && !new Date("9/34/1962").isValid();
		pass = pass && new Date("8/1/2027").isValid();
		pass = pass && !new Date("-2/3/1957").isValid();
		pass = pass && !new Date("0/22/1987").isValid();
		main2(pass);
	}

	private static void main2(boolean pass) {
		pass = pass && new Date("10/20/2037").isValid();
		pass = pass && !new Date("0/32/2008").isValid();
		pass = pass && !new Date("5/33/2001").isValid();
		pass = pass && new Date("5/27/1968").isValid();
		pass = pass && new Date("8/1/2007").isValid();
		pass = pass && !new Date("-1/17/2030").isValid();
		pass = pass && new Date("7/22/1985").isValid();
		pass = pass && new Date("9/24/2023").isValid();
		pass = pass && new Date("9/24/1955").isValid();
		pass = pass && !new Date("3/-4/1993").isValid();
		pass = pass && new Date("7/23/1973").isValid();
		pass = pass && !new Date("8/-2/1964").isValid();
		pass = pass && !new Date("9/0/2007").isValid();
		pass = pass && !new Date("8/0/2021").isValid();
		pass = pass && new Date("5/22/1969").isValid();
		pass = pass && new Date("3/12/2017").isValid();
		pass = pass && new Date("10/5/2038").isValid();
		pass = pass && new Date("10/16/1975").isValid();
		pass = pass && new Date("4/1/2047").isValid();
		pass = pass && !new Date("-3/26/1991").isValid();
		main3(pass);
	}

	private static void main3(boolean pass) {
		pass = pass && new Date("11/5/2021").isValid();
		pass = pass && !new Date("-2/-1/2015").isValid();
		pass = pass && !new Date("-1/27/2034").isValid();
		pass = pass && !new Date("0/28/2000").isValid();
		pass = pass && new Date("2/16/1999").isValid();
		pass = pass && new Date("2/17/1960").isValid();
		pass = pass && !new Date("6/32/2044").isValid();
		pass = pass && new Date("8/18/1961").isValid();
		pass = pass && new Date("10/31/2027").isValid();
		pass = pass && new Date("2/16/2021").isValid();
		pass = pass && new Date("10/28/2036").isValid();
		pass = pass && !new Date("5/33/2007").isValid();
		pass = pass && !new Date("5/-5/1966").isValid();
		pass = pass && !new Date("2/0/2025").isValid();
		pass = pass && new Date("11/30/1958").isValid();
		pass = pass && new Date("5/25/2025").isValid();
		pass = pass && !new Date("-2/13/1991").isValid();
		pass = pass && new Date("5/16/1982").isValid();
		pass = pass && new Date("1/14/2017").isValid();
		pass = pass && !new Date("9/-4/2041").isValid();
		main4(pass);
	}

	private static void main4(boolean pass) {
		pass = pass && new Date("3/13/2027").isValid();
		pass = pass && !new Date("1/-2/1951").isValid();
		pass = pass && !new Date("-1/15/2039").isValid();
		pass = pass && new Date("9/30/2023").isValid();
		pass = pass && new Date("8/28/1963").isValid();
		pass = pass && new Date("2/29/1952").isValid();
		pass = pass && new Date("10/30/1984").isValid();
		pass = pass && new Date("6/23/2032").isValid();
		pass = pass && !new Date("-3/-5/1988").isValid();
		pass = pass && !new Date("5/-3/1966").isValid();
		pass = pass && new Date("11/17/2004").isValid();
		pass = pass && new Date("6/17/1978").isValid();
		pass = pass && new Date("1/30/2009").isValid();
		pass = pass && new Date("10/15/2040").isValid();
		pass = pass && new Date("7/27/1967").isValid();
		pass = pass && !new Date("7/-2/2022").isValid();
		pass = pass && !new Date("-1/-5/1964").isValid();
		pass = pass && new Date("9/20/1976").isValid();
		pass = pass && new Date("5/28/1955").isValid();
		pass = pass && !new Date("-1/-5/1998").isValid();
		main5(pass);
	}

	private static void main5(boolean pass) {
		pass = pass && !new Date("-1/20/1996").isValid();
		pass = pass && new Date("6/18/1976").isValid();
		pass = pass && !new Date("-1/5/2022").isValid();
		pass = pass && new Date("1/11/1985").isValid();
		pass = pass && new Date("5/4/2044").isValid();
		pass = pass && new Date("10/10/2038").isValid();
		pass = pass && new Date("3/2/2046").isValid();
		pass = pass && new Date("1/24/1974").isValid();
		pass = pass && !new Date("10/-2/1993").isValid();
		pass = pass && new Date("3/9/2042").isValid();
		pass = pass && new Date("11/10/2005").isValid();
		pass = pass && !new Date("-2/12/1996").isValid();
		pass = pass && !new Date("-1/32/2034").isValid();
		pass = pass && new Date("6/17/1984").isValid();
		pass = pass && !new Date("10/0/1950").isValid();
		pass = pass && new Date("8/15/2002").isValid();
		pass = pass && !new Date("0/14/2036").isValid();
		pass = pass && new Date("3/27/2001").isValid();
		pass = pass && new Date("11/12/2035").isValid();
		pass = pass && !new Date("10/-3/1966").isValid();
		main6(pass);
	}

	private static void main6(boolean pass) {
		pass = pass && new Date("9/3/1965").isValid();
		pass = pass && new Date("8/11/1991").isValid();
		pass = pass && new Date("10/28/1962").isValid();
		pass = pass && !new Date("-3/23/1968").isValid();
		pass = pass && !new Date("0/26/2049").isValid();
		pass = pass && !new Date("11/32/2010").isValid();
		pass = pass && new Date("2/12/1986").isValid();
		pass = pass && new Date("7/11/2025").isValid();
		pass = pass && new Date("11/26/2036").isValid();
		pass = pass && !new Date("-3/6/1985").isValid();
		pass = pass && new Date("6/22/1990").isValid();
		pass = pass && !new Date("0/2/1970").isValid();
		pass = pass && !new Date("-2/7/2017").isValid();
		pass = pass && !new Date("10/34/2034").isValid();
		pass = pass && !new Date("5/-4/1973").isValid();
		pass = pass && !new Date("-3/21/1991").isValid();
		pass = pass && !new Date("5/-3/2004").isValid();
		pass = pass && !new Date("0/2/2006").isValid();
		pass = pass && new Date("6/24/1957").isValid();
		pass = pass && !new Date("-1/12/2012").isValid();
		main7(pass);
	}

	private static void main7(boolean pass) {
		pass = pass && !new Date("0/7/2043").isValid();
		pass = pass && new Date("7/31/2009").isValid();
		pass = pass && !new Date("0/29/2030").isValid();
		pass = pass && !new Date("0/12/2019").isValid();
		pass = pass && new Date("3/13/1982").isValid();
		pass = pass && new Date("8/1/1999").isValid();
		pass = pass && new Date("8/15/1964").isValid();
		pass = pass && new Date("3/3/1973").isValid();
		pass = pass && !new Date("2/-4/1971").isValid();
		pass = pass && new Date("3/13/2012").isValid();
		pass = pass && new Date("7/21/1961").isValid();
		pass = pass && new Date("11/2/2012").isValid();
		pass = pass && new Date("3/15/2038").isValid();
		pass = pass && !new Date("10/-3/1950").isValid();
		pass = pass && !new Date("1/32/1997").isValid();
		pass = pass && !new Date("-1/32/2005").isValid();
		pass = pass && !new Date("0/3/1999").isValid();
		pass = pass && !new Date("1/-5/2049").isValid();
		pass = pass && new Date("3/12/1972").isValid();
		pass = pass && new Date("8/6/2011").isValid();
		main8(pass);
	}

	private static void main8(boolean pass) {
		pass = pass && !new Date("0/16/1951").isValid();
		pass = pass && !new Date("4/-4/2027").isValid();
		pass = pass && new Date("5/28/1954").isValid();
		pass = pass && new Date("10/11/2039").isValid();
		pass = pass && !new Date("-3/18/1957").isValid();
		pass = pass && new Date("9/21/1985").isValid();
		pass = pass && !new Date("-3/27/1953").isValid();
		pass = pass && new Date("11/5/2031").isValid();
		pass = pass && !new Date("-2/-1/1989").isValid();
		pass = pass && new Date("11/29/2015").isValid();
		pass = pass && !new Date("-1/-3/1980").isValid();
		pass = pass && new Date("4/17/1963").isValid();
		pass = pass && new Date("6/27/2039").isValid();
		pass = pass && !new Date("-1/15/1996").isValid();
		pass = pass && new Date("1/20/2028").isValid();
		pass = pass && !new Date("2/32/1979").isValid();
		pass = pass && !new Date("8/-1/1990").isValid();
		pass = pass && new Date("9/2/2046").isValid();
		pass = pass && !new Date("0/-1/1952").isValid();
		pass = pass && !new Date("9/0/2007").isValid();
		main9(pass);
	}

	private static void main9(boolean pass) {
		pass = pass && new Date("3/8/2008").isValid();
		pass = pass && new Date("6/16/1970").isValid();
		pass = pass && new Date("9/21/2006").isValid();
		pass = pass && !new Date("9/-4/1980").isValid();
		pass = pass && !new Date("-3/19/2030").isValid();
		pass = pass && new Date("6/7/1979").isValid();
		pass = pass && new Date("2/24/2002").isValid();
		pass = pass && new Date("5/15/1969").isValid();
		pass = pass && new Date("7/14/2021").isValid();
		pass = pass && !new Date("6/-1/2030").isValid();
		pass = pass && !new Date("-2/-2/1988").isValid();
		pass = pass && new Date("9/11/1987").isValid();
		pass = pass && new Date("2/25/2019").isValid();
		pass = pass && !new Date("-2/0/1957").isValid();
		pass = pass && !new Date("9/33/1973").isValid();
		pass = pass && new Date("4/26/1989").isValid();
		pass = pass && new Date("1/19/2005").isValid();
		pass = pass && !new Date("-2/23/1993").isValid();
		pass = pass && new Date("1/22/1983").isValid();
		pass = pass && new Date("8/22/1995").isValid();
		System.out.println(pass);
	}
}