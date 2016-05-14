import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class DBHelper {
	private static DBHelper DBHelper;
	private Connection con;
	private Statement stmt;
	private ResultSet result;
	private Host host;
	private Audience audience;
	private String query;
	private ArrayList<String> performs;
	
	public DBHelper(String id, String pw, int type){
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost","root", "dasorr");
			stmt = con.createStatement();
			stmt.executeQuery("use oodp;");
			
			if(type == 0){
				query = "select * from host where user_id = "+id+"passwd = "+pw;
				result = stmt.executeQuery(query);
				String user_id = result.getString(1);
				String name = result.getString(3);
				String phoneNum = result.getString(4);
				
				query = "select performanceName from performance where hostName = "+name;
				result = stmt.executeQuery(query);
				ArrayList<String> performanceList = null;
				while(result.next()){
					performanceList.add(result.getString(1));
				}
				host = new Host(name, phoneNum, user_id, performanceList);
			}else if(type ==1){
				query = "select * from audience where user_id = "+id+"passwd = "+pw;
				result = stmt.executeQuery(query);
				String user_id = result.getString(1);
				String name = result.getString(3);
				String phoneNum = result.getString(4);
				
				query = "select * from ticket where audienceName = "+name;
				result = stmt.executeQuery(query);
				ArrayList<Ticket> tickets = null;
				while(result.next()){
					tickets.add(new Ticket(result.getString(1), result.getDate(2), result.getTime(3)));
				}
				
				audience = new Audience(name, phoneNum, user_id, tickets);
			}
			
			query = "select performanceName from performance";
			result = stmt.executeQuery(query);
			while(result.next()){
				performs.add(result.getString(1));
			}
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
	}
	
	public static DBHelper getInstance(String id, String pw, int type)
	{
		if(DBHelper == null)
		{
			DBHelper = new DBHelper(id, pw, type);
		}
		return DBHelper;
	}
	
	public Performance getPerformance(String performanceName){
		Performance performance = null;
		
		try{
			query = "select * from performance where performanceName = " + performanceName;
			result = stmt.executeQuery(query);
			String hostName = result.getString("hostNam");
			int placeNum = result.getInt("placeNum");
			int cost = result.getInt("cost");
			String description = result.getString("description");
			
			query = "select user_id, phoneNum from host where name = " + hostName;
			result = stmt.executeQuery(query);
			String user_id = result.getString("user_id");
			String phoneNum = result.getString("phoneNum");
			
			query = "select performanceName from performance where hostName = " + hostName;
			result = stmt.executeQuery(query);
			ArrayList<String> performanceList = null;
			while(result.next()){
				performanceList.add(result.getString("performanceName"));
			}
			Host localHost = new Host(hostName, phoneNum, user_id, performanceList);
			
			query = "select * from schedule where performanceName = " + performanceName;
			result = stmt.executeQuery(query);
			Date firstDay = result.getDate("firstDay");
			int duration = result.getInt("duration");
			Time[] time = new Time[duration];
			for(int i=0;i<duration;i++){
				time[i] = result.getTime(i+4);
			}
			Schedule schedule = new Schedule(performanceName, firstDay, duration, time);
			
			performance = new Performance(placeNum, localHost, schedule, performanceName, cost, description);
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
	
		return performance;
	}
}