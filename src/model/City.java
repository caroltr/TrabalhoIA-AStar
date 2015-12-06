package model;

public class City {

	private String name;
	private double latitude;
	private double longitude;
	
	public City(String name, double latitude, double longitude) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return String.format("%s (%f , %f)", name, latitude, longitude);
	}

	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((City)obj).getName());
	}
}
