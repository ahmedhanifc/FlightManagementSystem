package program;

import java.util.Objects;

public class Seat {
	private String seatNumber;
	private boolean availability = true;
	private SeatPosition seatPosition;
	public Seat(String seatNumber, SeatPosition seatPosition) {
		super();
		this.seatNumber = seatNumber;
		this.seatPosition = seatPosition;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return Objects.equals(seatNumber, other.seatNumber) && seatPosition == other.seatPosition;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public SeatPosition getSeatPosition() {
		return seatPosition;
	}
	@Override
	public int hashCode() {
		return Objects.hash(seatNumber, seatPosition);
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public void setSeatPosition(SeatPosition seatPosition) {
		this.seatPosition = seatPosition;
	}
	@Override
	public String toString() {
		return "Seat [seatNumber=" + seatNumber + ", availability=" + availability + ", seatPosition=" + seatPosition
				+ "]";
	}
	
	

}
