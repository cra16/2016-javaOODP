import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class UpdatePerformance{
	//private ArrayList<Product> performances = ProgramGUI.getInstance().getPerformances();
	//private Factory perFactory = ProgramGUI.getInstance().getPerFactory();
	
	public void updatePerformance()
	{
		//���⵵ GUI�� ���λ��� �ϴ� �������س���

	}

	public void eventUpdatePerformance(int currentIndex,int month, int day, String time,int cost,int placeNum,String PerformanceName){
		
		Calendar temp=Calendar.getInstance();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date d = null;
		Date date=new Date();
		temp.set(temp.get(Calendar.YEAR), month, day);
		
		date=new Date(temp.getTimeInMillis());
			
		
		Date t = null;
		
		SimpleDateFormat transFormat2= new SimpleDateFormat("HH:MM:SS");
		
		try {
			t=transFormat2.parse(time+":"+"00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Time[] time2= new Time[4];

	//	performances.set(currentIndex,perFactory.createProduct(new Performance(placeNum, DBHelper.getInstance().getHost(),
	//			new Schedule(PerformanceName,new java.sql.Date(date.getDate()),1,time2),PerformanceName
	//			,cost,"1")));
	}
	
}
