package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainFlightManagementSystem {

	public static void main(String[] args) {
		// I need an Airplane in my Flight Management System
		FlightManagement.addAirplanes(new Airplane("Boeing", "747", 6));
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
        
        // Now time for people to be able to book the flight
        
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
        		ArrayList<Customer> customers = new ArrayList<Customer>();
        		
        		for(int i =0; i< numberSeats; i++) {
        			customers.add(createCustomer());
        		}
        		System.out.println(customers);
        		FlightManagement.bookFlight(customers,flight);
        		
        	}
        	else if (choice == 3) {
        		
        	}
        	else if (choice == 4) {
        		
        	}
        	else if(choice == 4){
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
		System.out.print("Name: ");
		String name = scanner.nextLine();
		
		System.out.print("DOB: ");
		String dob = scanner.next();
		
		System.out.print("Passport Number: ");
		String passportNumber = scanner.next();
		
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
		return new Customer(name, dob, passportNumber, nationality, mealPreference);
	}

}
