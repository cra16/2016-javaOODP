
public class Performance {

	private Schedule schedule=new Schedule(); 
	private String place;
	private String host;
	private Seat[] seat;
	private int cost;
	private String name;
	private Ticket[] ticket=new Ticket[200];
	private int ticketcount=0;
	
	
	public Performance(String place , String host, int seatcount, String name)
	{
		this.place=place;
		this.host=host;
		this.seat = new Seat[seatcount];
		this.name = name;
		this.schedule.insertDate("17:00","2015-1-1");
	}
	
	public void createTicket()
	{
		
		
		
		ticket[ticketcount]= new Ticket(this);
		
	}
	public void evaluateGrade()
	{
		
	}
	public void showGrade()
	{
		
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Seat[] getSeat() {
		return seat;
	}

	public void setSeat(Seat[] seat) {
		this.seat = seat;
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
