import java.sql.*;

public class Performance{
	private Place place;
	private int placeNum;
	private Schedule schedule;
	private Host host;
	private int cost;
	private String name;
	private String description;
	
	public Performance(int placeNum, Host host, Schedule schedule, String name, int cost, String description){
		this.placeNum = placeNum;
		this.place = new Place(placeNum);
		this.host = host;
		this.name = name;
		this.schedule = schedule;
		this.cost = cost;
		this.description = description;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public int getPlaceNum() {
		return placeNum;
	}

	public void setPlaceNum(int placeNum) {
		this.placeNum = placeNum;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductName() {
		return this.getName();
	}
}