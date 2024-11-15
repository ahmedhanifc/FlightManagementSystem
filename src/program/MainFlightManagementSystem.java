package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainFlightManagementSystem {

	public static void main(String[] args) {
		// I need an Airplane in my Flight Management System
		FlightManagement.addAirplanes(new Airplane("Boeing", "747", 11));
		FlightManagement.addAirplanes(new Airplane("Airbus", "A380",10));
		
		FlightManagement.addPilot("PK3031", new Pilot("Ahmed", "2003-03-05","PK3031",Nationality.PAKISTANI, CrewRole.PILOT, LicenseType.COMMERCIAL_PILOT_LICENSE));
		FlightManagement.addPilot("PK3032", new Pilot("Hafsa", "2003-08-19","PK3032",Nationality.PAKISTANI, CrewRole.COPILOT,LicenseType.COMMERCIAL_PILOT_LICENSE));

		FlightManagement.removeAirplanes("A380");
//		FlightManagement.removePilot("PK3031");
		
		FlightManagement.addCrewMember("PK3033", new CrewMember("AB12", "2000-01-01", "PK3033", Nationality.QATARI, CrewRole.FLIGHT_ATTENDANT));
		FlightManagement.addCrewMember("PK3034", new CrewMember("AB13", "2000-01-02", "PK3034", Nationality.AMERICAN, CrewRole.FLIGHT_ATTENDANT));
		
        FlightManagement.createFlight("QR789", AirportCity.DOHA, AirportCity.LAHORE, "2024-12-17", "21:00", "2024-12-18", "03:00");
        FlightManagement.createFlight(new Flight[] {
        		new Flight("BA204", AirportCity.LONDON, AirportCity.DUBAI, "2023-12-16", "09:30", "2023-12-16", "18:15"),
        		new Flight("SQ305", AirportCity.SINGAPORE, AirportCity.LONDON, "2023-12-23", "09:25", "2023-12-23", "17:30"),
        		new Flight("AF123", AirportCity.PARIS, AirportCity.LOS_ANGELES, "2023-12-21", "15:45", "2023-12-21", "23:30"),
        		new Flight("BA204", AirportCity.DUBAI, AirportCity.ALGIERS, "2023-12-18", "14:00", "2023-12-18", "18:30") //testing duplicate Flight Numbers
        });
        
        // I first should assign a airplane to a flight man, can't have a flight without an airplane.
        FlightManagement.assignAirplanesToFlight("747", "QR789");;
        
        // Possibly can also perform checks if the pilot is capable of travelling in that airplane
        
        FlightManagement.assignPilotToFlight("PK3032", "QR789");
        FlightManagement.assignCoPilotToFlight("PK3031", "QR789");
        
        FlightManagement.assignCrewMembersToFlight("PK3033", "QR789");
        FlightManagement.assignCrewMembersToFlight("PK3034", "QR789");
        
        //
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer1 = new Customer("Ali Khan", "1985-02-15", "A1234567", Nationality.PAKISTANI, MealPreference.STANDARD);
        Customer customer2 = new Customer("Sara Ahmed", "1990-07-24", "B2345678", Nationality.AMERICAN, MealPreference.VEGAN);
        Customer customer3 = new Customer("James Smith", "1978-03-11", "C3456789", Nationality.BRITISH, MealPreference.SPECIAL);
        Customer customer4 = new Customer("Maria Garcia", "1995-09-05", "D4567890", Nationality.SPANISH, MealPreference.STANDARD);
        Customer customer5 = new Customer("Chen Wei", "1988-11-30", "E5678901", Nationality.CHINESE, MealPreference.VEGAN);
        Customer customer6 = new Customer("Aisha Malik", "1992-01-20", "F6789012", Nationality.QATARI, MealPreference.SPECIAL);
        Customer customer7 = new Customer("John Doe", "1983-05-10", "G7890123", Nationality.CANADIAN, MealPreference.STANDARD);
        Customer customer8 = new Customer("Fatima Noor", "1996-12-25", "H8901234", Nationality.UAE, MealPreference.STANDARD);
        Customer customer9 = new Customer("Luis Perez", "1981-08-17", "I9012345", Nationality.MEXICAN, MealPreference.VEGAN);
        Customer customer10 = new Customer("Sakura Tanaka", "1993-04-08", "J0123456", Nationality.JAPANESE, MealPreference.SPECIAL);

        // Adding customers to the list
        customers.addAll(Arrays.asList(customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8, customer9, customer10));
        
        FlightManagement.bookFlight(customers, FlightManagement.getFlights().get("QR789"));
        System.out.println("----------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        while(true) {
        	System.out.println("\n1) Display Available Flights");
        	System.out.println("2) Book Available Flights");
        	System.out.println("3) View Booked Flight");
        	System.out.println("4) Cancel Booked Flight");
        	System.out.println("5) Exit");
        	System.out.printf("Enter Your Choice: ");
        	int choice = scanner.nextInt();
        	
        	
        	if(choice == 1) {
        		System.out.print("Enter your Origin City. Format: SAO_PAULO (if spaces) LAHORE (if no spaces): ");
        		AirportCity origin = getCityInput();
        		System.out.print("Enter your Destination City. Format: SAO_PAULO (if spaces) LAHORE (if no spaces): ");
        		AirportCity destination = getCityInput();
        		FlightManagement.displayFlights(origin, destination);
        	}
        	else if (choice == 2) {
        		System.out.print("Enter Flight Number that you'd like to Book: ");
        		String flightNumber = scanner.next();
        		Flight flight = FlightManagement.getFlights().get(flightNumber);
        		if(flight==null) {
        			System.out.println("Invalid Flight Entry");
        			continue;
        		}
        		System.out.println("There are "+flight.getAirplane().getCapacity() + " seats available.");

        		System.out.println("How many tickets would you like to Book? ");
        		int numberSeats = scanner.nextInt();
        		
        		System.out.println("Please Enter your Personal Information: ");
        		
        		for(int i =0; i< numberSeats; i++) {
        			customers.add(createCustomer());
        		}
        		FlightManagement.bookFlight(customers,flight);
        		
        	}
        	else if (choice == 3) {
        		System.out.print("Enter your Passport Number to see all flights you have booked: ");
        		String passportNumber = scanner.next();
        		Customer customer = FlightManagement.getCustomers().get(passportNumber);
        		if(customer == null) {
        			System.out.println("Customer Not Found");
        			continue;
        		}
        		if(customer.getBookings().isEmpty()) {
        			System.out.println("You have no Bookings");
        			continue;
        		}
        		for(Integer d:customer.getBookings().keySet()) {
        			Booking booking = customer.getBookings().get(d);
        			System.out.println(booking.getBookingNumber() + " " + booking.getFlight().getDepartureDate() + " " + booking.getFlight().getArrivateDate() );
        		}
        	}
        	else if (choice == 4) {
        		System.out.print("Enter your Passport Number to see all flights you have booked: ");
        		String passportNumber = scanner.next();
        		Customer customer = FlightManagement.getCustomers().get(passportNumber);
        		if(customer == null) {
        			System.out.println("Customer Not Found");
        			continue;
        		}
        		if(customer.getBookings().isEmpty()) {
        			System.out.println("You have no Bookings to cancel");
        			continue;
        		}
        		System.out.println("Enter Booking Number to Cancel");
        		for(Integer d:customer.getBookings().keySet()) {
        			Booking booking = customer.getBookings().get(d);
        			System.out.println("Booking Number: " + booking.getBookingNumber() + " " + booking.getFlight().getDepartureDate() + " " + booking.getFlight().getArrivateDate() );
        		}
        		
        		Integer bookingNumber = scanner.nextInt();
        		if(customer.getBookings().containsKey(bookingNumber)) {
        			customer.getBookings().get(bookingNumber).getFlight().getAirplane().incrementCapacity();
        			customer.getBookings().remove(bookingNumber);
        			System.out.println("Booking successfully Removed");
        		}
        		else {
        			System.out.println("Invalid Booking Number");
        		}
        		
        	}
        	else if(choice == 5){
        		break;
        	}
        	else {
        		System.out.println("Invalid Entry Bro");
        	}
        	        	
        }

        scanner.close();
	}
	
	public static AirportCity getCityInput() {
        Scanner scanner = new Scanner(System.in);
    	while(true) {
        	String city = scanner.nextLine();
    		try {
    			return AirportCity.valueOf(city);
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println("You entered an Invalid City");
            	System.out.print("Enter your Origin City. Format: SAO_PAULO (if spaces) LAHORE (if no spaces): ");
    		}    		
    	}
    	
	}
	
	public static Customer createCustomer() {
        Scanner scanner = new Scanner(System.in);
        String passportNumber;
        
		while(true) {
			System.out.print("Passport Number: ");
			passportNumber = scanner.next();
			if(!FlightManagement.getCustomers().containsKey(passportNumber)) break;
			System.out.println("Duplicate Passport Number");
		}
		System.out.print("Name: ");
		String name = scanner.nextLine();
		
		scanner.next();
		System.out.print("DOB: ");
		String dob = scanner.next();
		
		Nationality nationality;
		while(true) {
			System.out.print("Nationality: (Example: PAKISTANI) - Must be all capital ");
			try {
				String input = scanner.next();
				nationality = Nationality.valueOf(input);
				break;
			}
			catch(IllegalArgumentException e) {
				System.out.println("Illegal Entry");
			}
		}
		MealPreference mealPreference;
		while(true) {
			System.out.print("Meal Prefence (STANDARD,VEGAN, SPECIAL): ");
			try {
				String input = scanner.next();
				mealPreference = MealPreference.valueOf(input);
				System.out.println();
				break;
			}
			catch(IllegalArgumentException e) {
				System.out.println("Illegal Entry");
			}
		}
		Customer customer = new Customer(name, dob, passportNumber, nationality, mealPreference);
		FlightManagement.getCustomers().put(passportNumber, customer);
		return customer;
	}

}
