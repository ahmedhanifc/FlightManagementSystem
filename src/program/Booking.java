package program;

import java.util.Objects;

public class Booking {
	private int bookingNumber;
	private Customer customer;
	private Seat seat;
	private Flight flight;
	private TicketType ticketType;
	
	public Booking(int bookingNumber, Customer customer, Seat seat, Flight flight, TicketType ticketType) {
		super();
		this.bookingNumber = bookingNumber;
		this.customer = customer;
		this.seat = seat;
		this.flight = flight;
		this.ticketType = ticketType;
	}
	public double getBookingNumber() {
		return bookingNumber;
	}
	public TicketType getTicketType() {
		return ticketType;
	}
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}
	public void setBookingNumber(int bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	@Override
	public String toString() {
		return "Booking [bookingNumber=" + bookingNumber + ", customer=" + customer + ", seat=" + seat + ", flight="
				+ flight + ", ticketType=" + ticketType + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookingNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(bookingNumber, other.bookingNumber);
	}
	
	
	

}
