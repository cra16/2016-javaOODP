import java.sql.*;

public class Ticket {
	private String audienceName;
	private Date date;
	private Time time;
	private String performanceName;
	
	
	public Ticket(String performanceName, Date date, Time time, String audienceName){
		this.performanceName = performanceName;
		this.date = date;
		this.time = time;
		this.audienceName = audienceName;
	}

	public String getAudienceName() {
		return audienceName;
	}

	public Date getDate() {
		return date;
	}

	public Time getTime() {
		return time;
	}

	public String getPerformanceName() {
		return performanceName;
	}
}

