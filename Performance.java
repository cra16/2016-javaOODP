import java.sql.*;

public class Performance {
	private Place place = new Place();
	private int placeNum;
	private Schedule schedule=new Schedule();
	private Host host;
	private int cost;
	private String name;
	private Ticket[] ticket=new Ticket[200];
	private int ticketcount=0;
	
	public Performance(int placeNum, Host host, String name, Date date, Time time)
	{
		this.placeNum = placeNum;
		this.host = host;
		this.name = name;
		this.schedule.setDate(date);
		this.schedule.setTime(time);
	}
	
	public void createTicket()
	{
		ticket[ticketcount]= new Ticket(this);
	}
	public void showInformation()
	{
		
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public String getPlaceName() {
		return this.place.getPlaceName(this.placeNum);
	}
	
	public int getMaxSeat(){
		return this.place.getMaxSeat(this.placeNum);
	}
	
	public int getCurrentNum(){
		return this.place.getCurrentNum(this.placeNum);
	}
	public void setPlace(int place) {
		this.placeNum = place;
	}

	public String getHost() {
		return host.getName();
	}
	
	public Seat[] getSeat(int placeNum) {
		return this.place.getSeat(placeNum);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ticket[] getTicket() {
		return ticket;
	}

	public void setTicket(Ticket[] ticket) {
		this.ticket = ticket;
	}

	public int getTicketcount() {
		return ticketcount;
	}

	public void setTicketcount(int ticketcount) {
		this.ticketcount = ticketcount;
	}
	
	
	
}
