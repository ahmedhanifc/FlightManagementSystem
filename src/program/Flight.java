package program;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Flight {
	private String flightNumber;
	private AirportCity origin;
	private AirportCity destination;
	private String departureDate;
	private String departureTime;
	private String arrivateDate;
	private String arrivalTime;
	private Airplane airplane;
	
	private HashMap<String, Booking> bookings = new HashMap<String, Booking>();
	private Pilot[] pilots = new Pilot[2];
	private HashSet<CrewMember> crewMembers = new HashSet<CrewMember>();
	

	public Flight(String flightNumber, AirportCity origin, AirportCity destination, String departureDate, String departureTime,
			String arrivateDate, String arrivalTime) {
		super();
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivateDate = arrivateDate;
		this.arrivalTime = arrivalTime;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(flightNumber, other.flightNumber);
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public String getArrivateDate() {
		return arrivateDate;
	}

	public HashMap<String, Booking> getBookings() {
		return bookings;
	}

	public HashSet<CrewMember> getCrewMembers() {
		return crewMembers;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public AirportCity getDestination() {
		return destination;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public AirportCity getOrigin() {
		return origin;
	}

	public Pilot[] getPilots() {
		return pilots;
	}

	@Override
	public int hashCode() {
		return Objects.hash(flightNumber);
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setArrivateDate(String arrivateDate) {
		this.arrivateDate = arrivateDate;
	}

	public void setBookings(HashMap<String, Booking> bookings) {
		this.bookings = bookings;
	}

	public void setCrewMembers(HashSet<CrewMember> crewMembers) {
		this.crewMembers = crewMembers;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void setDestination(AirportCity destination) {
		this.destination = destination;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setOrigin(AirportCity origin) {
		this.origin = origin;
	}

	public void setPilots(Pilot[] pilots) {
		this.pilots = pilots;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", origin=" + origin + ", destination=" + destination
				+ ", departureDate=" + departureDate + ", departureTime=" + departureTime + ", arrivateDate="
				+ arrivateDate + ", arrivalTime=" + arrivalTime + ", airplane=" + airplane + ", bookings=" + bookings
				+ ", pilots=" + Arrays.toString(pilots) + ", crewMembers=" + crewMembers + "]";
	}
	
	
}
