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

	public void setTime(Time[] time) {
		this.time = time;
	}

	public Date getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(Date firstDay) {
		this.firstDay = firstDay;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getPerformanceName() {
		return performanceName;
	}

	public void setPerformanceName(String performanceName) {
		this.performanceName = performanceName;
	}
	
	
}
