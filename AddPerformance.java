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

public class AddPerformController implements ActionListener {
	
	
	public AddPerformController()
	{
		
	}
	
	public void addPerformacne()
	{
		
	}
	
	public void eventAddPerformance(String performName, int placeNum,int monthNum,int dayNum,String[] Time, int duration, String Text)
	{
		
		
		
		Calendar temp=Calendar.getInstance();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date d = null;
		Date date=new Date();
		temp.set(temp.get(Calendar.YEAR), monthNum, dayNum);
		
		date=new Date(temp.getTimeInMillis());
			
		
		Date t = null;
		
		SimpleDateFormat transFormat2= new SimpleDateFormat("HH:MM:SS");
		
		
		Time[] time2= new Time[7];
		DBHelper helper= DBHelper.getInstance();
		
		for(int i=0; i<7; i++)
		{
			try {
				if(i<duration+1)
				t=transFormat2.parse(Time[i]+":"+"00");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i<duration+1)
				time2[i] = new java.sql.Time(t.getTime());
			else
				time2[i]=null;
		}

		
		Performance p = new Performance(placeNum,helper.getHost(),
				new Schedule(performName,new java.sql.Date(date.getDate()),duration+1,time2),performName,100,Text);

		helper.addPerformance(p);
		//performances.add(new Performance(placeindex, DBHelper.getInstance().getHost(),
		//		new Schedule(PerformanceName,new java.sql.Date(date.getDate()),1,time2),PerformanceName
		//		,cost,"1"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
