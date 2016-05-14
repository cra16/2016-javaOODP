import java.util.ArrayList;

public class Audience {
	private String name;
	private String phoneNum;
	private String userID;
	private ArrayList<Ticket> tickets;
	
	public Audience(String name, String phoneNum, String userID, ArrayList<Ticket> tickets){
		this.name = name;
		this.phoneNum = phoneNum;
		this.userID = userID;
		this.tickets = tickets;
	}
	
	public void addTicket()
	{
		
	}
	public void modifyTicket()
	{
		
	}
	
	public void cancelTicket()
	{
		
	}
	
	public void showTicket()
	{
		
	}
	
	//mutator and accessor
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phoneNum;
	}
	public void setPhonenumber(String phonenumber) {
		this.phoneNum = phonenumber;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
}
