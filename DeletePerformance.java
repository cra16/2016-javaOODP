import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DeletePerformance {
	private ArrayList<Performance> performances = ProgramGUI.getInstance().getPerformances();
	
	
	public void eventUpdatePerformance(int currentIndex,int month, int day, String time,int cost){
		
		performances.remove(currentIndex);
	}
}
