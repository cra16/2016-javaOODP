import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
				String user_id = result.getString(0);
				String name = result.getString(2);
				String phoneNum = result.getString(3);
				
				query = "select performanceName from performance where hostName = "+name;
				result = stmt.executeQuery(query);
				ArrayList<String> performanceList = null;
				while(result.next()){
					performanceList.add(result.getString(0));
				}
				host = new Host(name, phoneNum, user_id, performanceList);
			}else if(type ==1){
				query = "select * from audience where user_id = "+id+"passwd = "+pw;
				result = stmt.executeQuery(query);
				String user_id = result.getString(0);
				String name = result.getString(2);
				String phoneNum = result.getString(3);
				
				query = "select * from ticket where audienceName = "+name;
				result = stmt.executeQuery(query);
				ArrayList<Ticket> tickets = null;
				while(result.next()){
					tickets.add(new Ticket(result.getString(0), result.getDate(1), result.getTime(2)));
				}
				
				audience = new Audience(name, phoneNum, user_id, tickets);
			}
			
			query = "select performanceName from performance";
			result = stmt.executeQuery(query);
			while(result.next()){
				performs.add(result.getString(0));
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
		query = "select * from performance where performanceName = " + performanceName;
		
		Performance performance = new Performance();
		return performance;
	}
}