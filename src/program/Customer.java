package program;

public class Customer extends Person {
	private int flightsUndertaken;
	private MealPreference mealPreference;

	public MealPreference getMealPreference() {
		return mealPreference;
	}

	public void setMealPreference(MealPreference mealPreference) {
		this.mealPreference = mealPreference;
	}

	public Customer(String name, String dob, String passportNumber, Nationality nationality,
			MealPreference mealPreference) {
		super(name, dob, passportNumber, nationality);
		this.mealPreference = mealPreference;
	}

	public int getFlightsUndertaken() {
		return flightsUndertaken;
	}

	public void setFlightsUndertaken(int flightsUndertaken) {
		this.flightsUndertaken = flightsUndertaken;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "Flights Undertaken: " + this.getFlightsUndertaken() + " Meal Preference: " + this.getMealPreference();
	}
	
}
