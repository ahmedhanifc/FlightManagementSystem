package program;

public class Pilot extends CrewMember {
	private LicenseType licenseType;
	private double flightHours;
	
	

	public Pilot(String name, String dob, String passportNumber, Nationality nationality, CrewRole role,
			LicenseType licenseType) {
		super(name, dob, passportNumber, nationality, role);
		this.licenseType = licenseType;
	}
	public Pilot(String name, String dob, String passportNumber, Nationality nationality, CrewRole role,
			LicenseType licenseType, double flightHours) {
		super(name, dob, passportNumber, nationality, role);
		this.licenseType = licenseType;
		this.flightHours = flightHours;
	}
	public double getFlightHours() {
		return flightHours;
	}
	public LicenseType getLicenseType() {
		return licenseType;
	}
	public void setFlightHours(double flightHours) {
		this.flightHours = flightHours;
	}
	public void setLicenseType(LicenseType licenseType) {
		this.licenseType = licenseType;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " License Type" + this.licenseType +  " Flight Hours, " + this.getFlightHours();
	}
	
	

}
