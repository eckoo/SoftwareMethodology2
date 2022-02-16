package Application;

public class Profile {
	private String fname;
	private String lname;
	private Date dob;
	
	private static final int EQUALS = 0;
	
	/**
	 * This is the Profile constructor method.
	 * 
	 * @param fname, lname Object of type String, dob Object of type Date.
	 */
	public Profile(String fname, String lname, Date dob) {
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
	}
	
	/**
	 * The equals method determines if the profile inputted equals the profile in the system.
	 *
	 * @param obj Object of type Object.
	 * @return true if patient's equal, false if not.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Profile) {
			Profile profile = (Profile) obj;
			if (!this.fname.equals(profile.fname)) {
				return false;
			}
			if (!this.lname.equals(profile.lname)) {
				return false;
			}
			if (!this.dob.equals(profile.dob)) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * This is the toString method.
	 * 
	 * @return the string representation of the profile.
	 */
	@Override
	public String toString() {
		return fname + " " + lname + ", DOB: " + dob.toString();
	}

	/**
	 * This is the compareTo method.
	 * 
	 * @param profile Object of type Profile.
	 * @return what the contract of compareTo is supposed to output.
	 */
	public int compareTo(Profile profile) {
		int lastNameCompare = this.lname.compareTo(profile.lname);
		if (lastNameCompare != EQUALS) {
			return lastNameCompare;
		}
		int firstNameCompare = this.fname.compareTo(profile.fname);
		if (firstNameCompare != EQUALS) {
			return firstNameCompare;
		}
		return this.dob.compareTo(profile.dob);
	}
}
