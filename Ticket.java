import java.sql.*;

public class Ticket {
	private Date date;
	private Time time;
	private String performanceName;
	
	public Ticket(String performanceName, Date date, Time time){
		this.performanceName = performanceName;
		this.date = date;
		this.time = time;
	}
}
