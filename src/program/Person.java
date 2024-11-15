package program;

import java.util.Objects;

public abstract class Person {
	private String name;
	private String dob;
	private String passportNumber;
	private Nationality nationality;

	public Nationality getNationality() {
		return nationality;
	}
	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	public Person(String name, String dob, String passportNumber, Nationality nationality) {
		super();
		this.name = name;
		this.dob = dob;
		this.passportNumber = passportNumber;
		this.nationality = nationality;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	@Override
	public String toString() {
		return "name=" + name + ", dob=" + dob + ", passportNumber=" + passportNumber + ", nationality="
				+ nationality;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dob, name, passportNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(name, other.name)
				&& Objects.equals(passportNumber, other.passportNumber);
	}
	
	

}
