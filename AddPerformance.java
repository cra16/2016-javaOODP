import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class AddPerformance implements ActionListener {
	private ArrayList<Product> performances = ProgramGUI.getInstance().getPerformances();
	private Factory perFactory = ProgramGUI.getInstance().getPerFactory();
	
	public void addPerformacne()
	{
		//여긴 나중에 GUI로 따로 뺄거
		}
	
	public void eventAddPerformance(int placeindex,int month, int day, String time,int cost,String PerformanceName)
	{
		
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
		
		
		performances.add(perFactory.createProduct(new Performance(placeindex, ProgramGUI.getInstance().getHost(), PerformanceName, new java.sql.Date(date.getTime()), new java.sql.Time(t.getTime()),cost)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
