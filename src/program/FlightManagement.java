package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FlightManagement {
	private static HashSet<Airplane> airplanes = new HashSet<Airplane>();
	private static HashMap<String, Pilot> pilots = new HashMap<String, Pilot>();
	private static HashMap<String, CrewMember> crewMembers = new HashMap<String, CrewMember>();
	private static HashMap<String, Flight> flights = new HashMap<String, Flight>();
	
	public static void addAirplanes(Airplane airplane) {
		if(!Utility.addIfNotExistsCollection(airplanes, airplane)) {
			System.out.printf("%s %s couldn't be added\n",airplane.getManufacturer(),airplane.getModel());
		}
	}
	// START - Add and Remove Airplanes from the System
	public static void addAirplanes(String  model,String manufacturer,int capacity) {
		addAirplanes(new Airplane(manufacturer, model, capacity));
	}
	// Start - Adding and Removing Crew Members
	public static void addCrewMember(String identifier,CrewMember crewMember) {
		if(!Utility.addIfNotExistsMap(crewMembers, identifier, crewMember)) {
			System.out.printf("%s couldn't be added\n", crewMember.getName());
		}
		else {
			System.out.printf("%s has been successfully added to Crew Members List\n", crewMember.getName());

		}
	}
	// START - Add and Remove pilots from the System
	public static void addPilot(String identifier,Pilot pilot) {
		if(!Utility.addIfNotExistsMap(pilots, identifier, pilot)) {
			System.out.printf("%s couldn't be added\n", pilot.getName());
		}
		else {
			System.out.printf("%s has been successfully added to pilots\n", pilot.getName());

		}
	}
	public static void assignAirplanesToFlight(String model, String flightNumber) {
		//this isn't an ideal way to have airplanes, but i'll stick with this for now
		Airplane airplane = Utility.searchCollection(airplanes, model);
		Flight flight = flights.get(flightNumber);
		if(flight == null) return;
		if(airplane==null) return;
		if(!airplane.isAvailability()) return;
		
		flight.setAirplane(airplane);
		airplane.setAvailability(false);
		System.out.printf("%s %s - %d capacity assigned to A flight origin: %s , destination: %s, on %s\n", airplane.getManufacturer(),airplane.getModel(), airplane.getCapacity(),flight.getOrigin(), flight.getDestination(), flight.getDepartureDate());	
	}
	
	public static void assignCoPilotToFlight(String identifier, String flightNumber){
		Flight flight = flights.get(flightNumber);
		Pilot coPilot = pilots.get(identifier);
		boolean isAvailable = isFlightAndCrewAvailable(flight, coPilot);
		if(!isAvailable) return;
		if(flight.getPilots()[1] != null) return;
		
		flight.getPilots()[1] = coPilot;
		coPilot.setAvailability(false);
		System.out.printf("A flight origin: %s , destination: %s, on %s has been assigned to %s as a copilot\n", flight.getOrigin(), flight.getDestination(), flight.getDepartureDate(), coPilot.getName());
	}
	public static void assignCrewMembersToFlight(String identifier, String flightNumber) {
		Flight flight = flights.get(flightNumber);
		CrewMember crewMember = crewMembers.get(identifier);
		boolean isAvailable = isFlightAndCrewAvailable(flight, crewMember);
		if(!isAvailable) return;
		
		flight.getCrewMembers().add(crewMember);
		crewMember.setAvailability(false);
		System.out.printf("Crew Member: %sA has been assigned to flight origin: %s , destination: %s, on %s\n", crewMember.getName(),flight.getOrigin(), flight.getDestination(), flight.getDepartureDate());

	}
	
	public static void assignPilotToFlight(String identifier, String flightNumber){
		Flight flight = flights.get(flightNumber);
		Pilot pilot = pilots.get(identifier);
		
		boolean isAvailable = isFlightAndCrewAvailable(flight, pilot);
		if(!isAvailable) return;
		if(flight.getPilots()[0] != null) return;
		
		flight.getPilots()[0] = pilot;
		pilot.setAvailability(false);
		System.out.printf("A flight origin: %s , destination: %s, on %s has been assigned to %s as a pilot\n", flight.getOrigin(), flight.getDestination(), flight.getDepartureDate(), pilot.getName());
	}
	public static void createFlight(Flight flight) {
		if(!Utility.addIfNotExistsMap(flights, flight.getFlightNumber(), flight)){
			System.out.println("This flight is already booked");
		}
		else {
			System.out.printf("A flight origin: %s , destination: %s, on %s has been created\n", flight.getOrigin(), flight.getDestination(), flight.getDepartureDate());
		}
	}
	
	public static void createFlight(Flight[] flights) {
		if(flights!=null) {
			for(Flight flight:flights) {
				createFlight(flight);			
			}
		}
	}
	
	// Start - Creating and Removing Flights in the System
	public static void createFlight(String flightNumber,AirportCity origin,AirportCity destination,String departureDate, String departureTime, String arrivateDate, String arrivalTime) {
		createFlight(new Flight(flightNumber, origin, destination, departureDate, departureTime, arrivateDate, arrivalTime));
	}
	public static void displayFlights(AirportCity origin, AirportCity destination) {
		int counter = 0;
		for(String s: flights.keySet()) {
			if(flights.get(s).getOrigin().equals(origin) && flights.get(s).getDestination().equals(destination)) {
				System.out.printf("Flight: %s, Departure: %s, Arrival: %s, Seats Available: %d \n",flights.get(s).getFlightNumber(), flights.get(s).getDepartureDate(), flights.get(s).getArrivateDate(), flights.get(s).getAirplane().getCapacity());
				counter ++;
			}
		}
		if(counter == 0) {
			System.out.println("Sorry, we currently don't have any flights available");
		}
	}
	public static HashMap<String, Flight> getFlights() {
		return flights;
	}

	// END - Creating and Removing Flights in the System
	
	// Start - Assigning Crew Members to Flight
	
	public static boolean isFlightAndCrewAvailable(Flight flight, CrewMember crewMember) {
		if(flight==null) return false;
		if(crewMember == null) return false;
		if(!crewMember.isAvailability()) return false;
		if(flight.getAirplane() == null) return false;
		
		return true;
	}

	public static void removeAirplanes(String model) {
		Airplane airplane = Utility.searchCollection(airplanes, model);
		if(airplane !=null && airplanes.contains(airplane)) {
			airplanes.remove(airplane);
			System.out.printf("Airplane: %s Successfully Removed\n",model);

		}
		else {
			System.out.printf("Airplane: %s not found\n",model);
		}
		
	}
	// END - Add and Remove Airplanes from the System
	public static void removeCrewMember(String identifier) {
		if(Utility.removeIfExistsMap(crewMembers, identifier)) {
			System.out.printf("%s Removed From crew Members list\n",identifier);
		}
		else {
			System.out.printf("%s not found in crew Members list\n",identifier);
		}
	}
	// END - Adding and Removing Crew Members
	
	public static void removePilot(String identifier) {
		if(Utility.removeIfExistsMap(pilots, identifier)) {
			System.out.printf("%s Removed From pilot list\n",identifier);
		}
		else {
			System.out.printf("%s not found in pilot list\n",identifier);
		}
	}
	// END - Add and Remove pilots from the System
	public static void setFlights(HashMap<String, Flight> flights) {
		FlightManagement.flights = flights;
	}
	
	public static void unassignPilotFromFlight() {}
	public static void unassigntCoPilotFromFlight() {}

	public static void unnassignCrewMembersToFlight() {}
	
	public static void bookFlights(ArrayList<Customer> customers, Flight flight) {
		if(flight==null) return;
		if(customers.isEmpty()) return;
		if(flight.getAirplane().getCapacity() < customers.size()) return;
		
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		for(Customer customer:customers) {
			double bookingNumber = Math.floor(100000 + Math.random() * 90000);
			new Booking(bookingNumber, customer, new Seat("A4", SeatPosition.WINDOW), flight, TicketType.ECONOMY);
		}
	}
	
		
}
