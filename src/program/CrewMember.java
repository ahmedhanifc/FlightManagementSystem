package program;

public class CrewMember extends Person {
	private CrewRole role;
	private boolean availability;


	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public CrewMember(String name, String dob, String passportNumber, Nationality nationality, CrewRole role) {
		super(name, dob, passportNumber, nationality);
		this.role = role;
		this.availability = true;
	}

	public CrewRole getRole() {
		return role;
	}

	public void setRole(CrewRole role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "Role: " + role + " ,Availability: " +  availability;
		
	}
	

}
