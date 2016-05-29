import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class DBHelper {
	private static DBHelper DBHelper=null;
	private Connection con;
	private Statement stmt;
	private ResultSet result;
	private Host host;
	private Audience audience;
	private String query;
	private boolean user_validator;
	private Performances performs;
	
	private DBHelper(String id, String pw, int type){
		performs = new Performances();
		 
		String user_id = null;
		String name = null;
		String phoneNum = null;
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost","root", "dasorr");
			stmt = con.createStatement();
			stmt.executeQuery("use oodp;");
		
			if(type == 2){
				query = "select * from host where user_id = '"+id+"' and passwd = '"+pw+"'";
				result = stmt.executeQuery(query);
				
				if(result.next()){
					user_id = result.getString("user_id");
					name = result.getString("name");
					phoneNum = result.getString("phoneNum");
					
					query = "select performanceName from performance where hostName = '"+name+"'";
					result = stmt.executeQuery(query);
					ArrayList<String> performanceList = new ArrayList<String>();
					while(result.next()){
						performanceList.add(result.getString("performanceName"));
					}
					host = new Host(name, phoneNum, user_id, performanceList);
					user_validator = true;
				}else {
					user_validator = false;
				}
			}else if(type == 1){
				query = "select * from audience where user_id = '"+id+"' and passwd = '"+pw+"'";
				result = stmt.executeQuery(query);
				
				if(result.next()){
					user_id = result.getString(1);
					name = result.getString(3);
					phoneNum = result.getString(4);
					
					query = "select * from ticket where audienceName = '"+name+"' order by date, time";
					result = stmt.executeQuery(query);
					ArrayList<Ticket> tickets = new ArrayList<Ticket>();
					while(result.next()){
						tickets.add(new Ticket(result.getString(1), result.getDate(2), result.getTime(3), result.getString(4)));
					}
					audience = new Audience(name, phoneNum, user_id, tickets);
					user_validator = true;
				}else {
					user_validator = false;
				}
			}
			
			query = "select performance.performanceName from performance, schedule where performance.performanceName=schedule.performanceName order by firstDay";
			result = stmt.executeQuery(query);
			result.last();
			String[] performName = new String[result.getRow()];
			result.beforeFirst();
			int count=0;
			while(result.next()){
				performName[count++] = result.getString("performanceName");
			}
			for(int i=0;i<count;i++){
				performs.appendPerform(getPerformance(performName[i]));
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
	public static DBHelper getInstance()
	{
		return DBHelper;
	}
	
	
	public Performance getPerformance(String performanceName){
		Performance performance = null;
		String hostName = null;
		int placeNum = 0;
		int cost = 0;
		String description = null;
		String user_id = null;
		String phoneNum = null;
		Date firstDay = null;
		int duration = 0;
		Time[] time = null;
		
		try{
			query = "select * from performance where performanceName = '" + performanceName + "'";
			result = stmt.executeQuery(query);
			while(result.next()){
				hostName = result.getString("hostName");
				placeNum = result.getInt("placeNum");
				cost = result.getInt("cost");
				description = result.getString("description");
			}
			
			query = "select user_id, phoneNum from host where name = '" + hostName + "'";
			result = stmt.executeQuery(query);
			while(result.next()){
				user_id = result.getString("user_id");
				phoneNum = result.getString("phoneNum");
			}
			
			query = "select performanceName from performance where hostName = '" + hostName + "'";
			result = stmt.executeQuery(query);
			ArrayList<String> performanceList = new ArrayList<String>();
			while(result.next()){
				performanceList.add(result.getString("performanceName"));
			}
			Host localHost = new Host(hostName, phoneNum, user_id, performanceList);
			
			query = "select * from schedule where performanceName = '" + performanceName + "'";
			result = stmt.executeQuery(query);
			while(result.next()){
				firstDay = result.getDate("firstDay");
				duration = result.getInt("duration");
				time = new Time[7];
				for(int i=0;i<7;i++){
					if(i<duration)time[i] = result.getTime(i+4);
					else time[i] = null;
				}
			}
			Schedule schedule = new Schedule(performanceName, firstDay, duration, time);
			
			performance = new Performance(placeNum, localHost, schedule, performanceName, cost, description);
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
	
		return performance;
	}

	public boolean addPerformance(Performance perform){
//		performs.add(perform);
//		host.getPerformanceList().add(perform.getName());
		try{
			query = "insert into performance values('"+perform.getName()+"','"+perform.getHost().getName()+"',"+perform.getPlaceNum()+","+perform.getCost()+",'"+perform.getDescription()+"')";
			stmt.executeUpdate(query);
			query = "insert into schedule values('"+perform.getName()+"',"+"'"+perform.getSchedule().getFirstDay()+"',"+perform.getSchedule().getDuration();
			for(int i=0;i<7;i++){
				if(perform.getSchedule().getTime()[i] == null)
					query += ","+perform.getSchedule().getTime()[i];
				else 
					query += ",'"+perform.getSchedule().getTime()[i]+"'";
			}
			query += ")";
			stmt.executeUpdate(query);
			return true;
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
			return false;
		}
	}
	
	public boolean updatePerformance(Performance previousPerform, Performance perform){
		//int index = performs.indexOf(previousPerform);
		//performs.set(index, perform);
		//host.getPerformanceList().set(index, perform.getName());
		try{
			query = "update performance set ";
			query += "performanceName='"+perform.getName()+"', ";
			query += "hostName='"+perform.getHost().getName()+"', ";
			query += "placeNum="+perform.getPlaceNum()+", ";
			query += "cost="+perform.getCost()+", ";
			query += "description='"+perform.getDescription()+"' ";
			query += "where performanceName='"+previousPerform.getName()+"'";
			stmt.executeUpdate(query);
			query = "update schedule set ";
			query += "performanceName='"+perform.getName()+"', ";
			query += "firstDay='"+perform.getSchedule().getFirstDay()+"', ";
			query += "duration="+perform.getSchedule().getDuration();
			for(int i=0;i<7;i++){
				if(perform.getSchedule().getTime()[i] == null)
					query += ", time"+(i+1)+"="+perform.getSchedule().getTime()[i];
				else 
					query += ", time"+(i+1)+"='"+perform.getSchedule().getTime()[i]+"'";
			}
			query += " where performanceName='"+previousPerform.getName()+"'";
			stmt.executeUpdate(query);
			return true;
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
			return false;
		}
	}
	
	public boolean deletePerformance(Performance perform){
	//	int index = performs.indexOf(perform);
	//	performs.remove(index);
	//	host.getPerformanceList().remove(index);
		try{
			query = "delete from performance where performanceName='"+perform.getProductName()+"'";
			stmt.executeUpdate(query);
			query = "delete from schedule where performanceName='"+perform.getProductName()+"'";
			stmt.executeUpdate(query);
			query = "delete from ticket where performanceName='"+perform.getProductName()+"'";
			stmt.executeUpdate(query);
			return true;
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
			return false;
		}
	}
	
	public void reserveTicket(String performName, Date date, Time time, String audienceName){
		try{
			query = "insert into ticket values('"+performName+"','"+date+"','"+time+"','"+audienceName+"')";
			stmt.executeUpdate(query);
			audience.getTickets().add(new Ticket(performName, date, time, audienceName));
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
			System.out.println("이미 예매함");
		}
	}
	
	public void cancelTicket(Ticket ticket){
		try{
			int index = audience.getTickets().indexOf(ticket);
			audience.getTickets().remove(index);
			
			query = "delete from ticket where performanceName='"+ticket.getPerformanceName()+"' and date='"+ticket.getDate()+"' and time='"+ticket.getTime()+"' and audienceName='"+ticket.getAudienceName()+"'";
			stmt.executeUpdate(query);
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
	}
	
	public int getCurrentNum(String performName, Date date, Time time){
		int num = 0;
		try{
			query = "select count(*) from ticket where performanceName='"+performName+"' and date='"+date+"' and time='"+time+"'";
			result = stmt.executeQuery(query);
			while(result.next()){
				num = result.getInt(1);
			}
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
			return -1;
		}
		
		return num;
	}
	
	public Host getHost() {
		return host;
	}

	public Audience getAudience() {
		return audience;
	}

	public Performances getPerforms() {
		return performs;
	}

	public void setPerforms(Performances performs) {
		this.performs = performs;
	}

	public boolean isUser_validator() {
		return user_validator;
	}

}