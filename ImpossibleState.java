import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImpossibleState extends JFrame implements CancelTicketState{
	private static ImpossibleState singleton = new ImpossibleState();
	private ImpossibleState(){};
	public static CancelTicketState getInstance(){
		return singleton;
	}
	
	public CancelTicketState checkDay(Date date){
		if(date.after(new Date()))
			return PossibleState.getInstance();
		else 
			return singleton;
	}
	
	public void makeCancelBtn(JPanel orderpanel, JButton[] cancelBtn, int index, int size){
		cancelBtn[index] = new JButton("예매취소");
        cancelBtn[index].setBounds(240,50*index,90,50);
        cancelBtn[index].setFont(new java.awt.Font("Gulim", 0, 15));
        cancelBtn[index].setEnabled(false);
        orderpanel.add(cancelBtn[index]);
	}
}
