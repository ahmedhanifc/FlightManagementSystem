package program;

import java.util.Objects;

public class Airplane {
	private String manufacturer;
	private String model;
	private int capacity;	
	private boolean availability;
	public Airplane(String manufacturer,String model, int capacity) {
		super();
		this.model = model;
		this.manufacturer = manufacturer;
		this.capacity = capacity;
		this.availability = true;
	}
	public String getModel() {
		return model;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getCapacity() {
		return capacity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(manufacturer, model);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airplane other = (Airplane) obj;
		return Objects.equals(manufacturer, other.manufacturer) && Objects.equals(model, other.model);
	}
	@Override
	public String toString() {
		return "Airplane [manufacturer=" + manufacturer + ", model=" + model + ", capacity=" + capacity
				+ ", availability=" + availability + "]";
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	

}
