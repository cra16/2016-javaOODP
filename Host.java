import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Host{
	private String name;
	private String phoneNum;
	private String userID;
	private ArrayList<String> performanceList;
	
	public Host(String name, String phoneNum,String userID, ArrayList<String> performanceList)
	{
		this.name = name;
		this.phoneNum = phoneNum;
		this.userID = userID;
		this.performanceList = performanceList;
	}
	
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
