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
	private ArrayList<String> performs;
	//private Factory perFactory = new PerformanceFactory();
	//private ArrayList<Product> performance = new ArrayList<Product>();
	
	private DBHelper(String id, String pw, int type){
		String user_id = null;
		String name = null;
		String phoneNum = null;
		performs = new ArrayList<String>();
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost","root", "dasorr");
			stmt = con.createStatement();
			stmt.executeQuery("use oodp;");
		
			if(type == 2){
				query = "select * from host where user_id = '"+id+"' and passwd = '"+pw+"'";
				result = stmt.executeQuery(query);
				
				if(!result.wasNull()){
					while(result.next()){
						user_id = result.getString("user_id");
						name = result.getString("name");
						phoneNum = result.getString("phoneNum");
					}
					
					query = "select performanceName from performance where hostName = '"+name+"'";
					result = stmt.executeQuery(query);
					ArrayList<String> performanceList = null;
					while(result.next()){
						performanceList.add(result.getString(1));
					}
					host = new Host(name, phoneNum, user_id, performanceList);
				}else {
					System.out.println("로그인 실패");
				}
			}else if(type == 1){
				query = "select * from audience where user_id = '"+id+"' and passwd = '"+pw+"'";
				result = stmt.executeQuery(query);
				
				if(!result.wasNull()){
					while(result.next()){
						user_id = result.getString(1);
						name = result.getString(3);
						phoneNum = result.getString(4);
					}
					
					query = "select * from ticket where audienceName = '"+name+"'";
					result = stmt.executeQuery(query);
					ArrayList<Ticket> tickets = null;
					while(result.next()){
						tickets.add(new Ticket(result.getString(1), result.getDate(2), result.getTime(3)));
					}
					audience = new Audience(name, phoneNum, user_id, tickets);
				}else {
					System.out.println("로그인 실패");
				}
			}
			
			query = "select performanceName from performance";
			result = stmt.executeQuery(query);
			while(result.next()){
				performs.add(result.getString("performanceName"));
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
				hostName = result.getString("hostNam");
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
			ArrayList<String> performanceList = null;
			while(result.next()){
				performanceList.add(result.getString("performanceName"));
			}
			Host localHost = new Host(hostName, phoneNum, user_id, performanceList);
			
			query = "select * from schedule where performanceName = '" + performanceName + "'";
			result = stmt.executeQuery(query);
			result.next();
			firstDay = result.getDate("firstDay");
			duration = result.getInt("duration");
			time = new Time[7];
			for(int i=0;i<7;i++){
				if(i<duration)time[i] = result.getTime(i+4);
				else time[i] = null;
			}
			Schedule schedule = new Schedule(performanceName, firstDay, duration, time);
			
			performance = new Performance(placeNum, localHost, schedule, performanceName, cost, description);
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
	
		return performance;
	}

	public void addPerformance(Performance perform){
		performs.add(perform.getName());
		try{
			query = "insert into performance values('"+perform.getName()+"','"+perform.getHost().getName()+"',"+perform.getPlaceNum()+","+perform.getCost()+",'"+perform.getDescription()+"')";
			stmt.executeQuery(query);
			query = "insert into schedule values('"+perform.getName()+"',"+perform.getSchedule().getFirstDay()+","+perform.getSchedule().getDuration();
			for(int i=0;i<7;i++){
				query = query +","+ perform.getSchedule().getTime()[i];
			}
			query = query + ")";
			stmt.executeQuery(query);
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
	}
	
	public void updatePerformance(String performName, Performance perform){
		int index = performs.indexOf(performName);
		performs.set(index, perform.getName());
		try{
			query = "update performance set ";
			query = query + "performanceName='"+perform.getName()+"', ";
			query = query + "hostName='"+perform.getHost().getName()+"', ";
			query = query + "placeNum="+perform.getPlaceNum()+", ";
			query = query + "cost="+perform.getCost()+", ";
			query = query + "description='"+perform.getDescription()+"' ";
			query = query + "where performanceName='"+performName+"'";
			stmt.executeQuery(query);
			query = "update schedule set ";
			query = query + "performanceName='"+perform.getName()+"', ";
			query = query + "firstDay="+perform.getSchedule().getFirstDay()+", ";
			query = query + "duration="+perform.getSchedule().getDuration();
			for(int i=0;i<7;i++){
				query = query +", time"+i+"="+perform.getSchedule().getTime()[i];
			}
			query = query + " where performanceName='"+performName+"'";
			stmt.executeQuery(query);
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
	}
	
	public void deletePerformance(String perform){
		int index = performs.indexOf(perform);
		performs.remove(index);
		try{
			query = "delete from performance where performanceName='"+perform+"'";
			stmt.executeQuery(query);
			query = "delete from schedule where performanceName='"+perform+"'";
			stmt.executeQuery(query);
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
	}
	
	public void reserveTicket(String performName, Date date, Time time, String audienceName){
		try{
			query = "insert into ticket values('"+performName+"',"+date+","+time+",'"+audienceName+"')";
			stmt.executeQuery(query);
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
	}
	
	public void cancelTicket(String performName, Date date, Time time, String audienceName){
		try{
			query = "delete from ticket where performanceName='"+performName+"' and date="+date+" and time"+time+" and audienceName='"+audienceName+"'";
			stmt.executeQuery(query);
		}catch(SQLException sqex){
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
	}
	
	public int getCurrentNum(String performName, Date date, Time time){
		int num = 0;
		try{
			query = "select count(*) from ticket where performanceName='"+performName+"' and date="+date+" and time"+time;
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

	public ArrayList<String> getPerforms() {
		return performs;
	}

	public void setPerforms(ArrayList<String> performs) {
		this.performs = performs;
	}


	
	
	
}