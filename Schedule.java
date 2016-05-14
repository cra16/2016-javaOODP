import java.sql.*;

public class Schedule {
	private Time[] time;


	private Date firstDay;
	private int duration;
	private String performanceName;
	
	public Schedule(String performanceName, Date firstDay, int duration, Time[] time)
	{
		this.performanceName = performanceName;
		this.firstDay = firstDay;
		this.time = time;
		this.duration = duration;
	}
	
	public Time[] getTime() {
		return time;
	}
	
	public Date getFirstDay()
	{
		return this.firstDay;
	}
	public int getDuration()
	{
		return duration;
		
	}
	
}
