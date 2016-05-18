import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PossibleState extends JFrame implements CancelTicketState{
	private static PossibleState singleton = new PossibleState();
	private PossibleState(){};
	public static CancelTicketState getInstance(){
		return singleton;
	}
	
	public CancelTicketState checkDay(Date date){
		if(date.before(new Date()))
			return ImpossibleState.getInstance();
		else 
			return singleton;
	}
	
	public void makeCancelBtn(JPanel orderpanel, JButton[] cancelBtn, int index, int size){
		cancelBtn[index] = new JButton("예매취소");
        cancelBtn[index].setBounds(240,50*index,90,50);
        cancelBtn[index].setFont(new java.awt.Font("Gulim", 0, 15));

        orderpanel.add(cancelBtn[index]);
        
        cancelBtn[index].addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
                {
                    public void actionPerformed(ActionEvent e) {
                    	int index=0;
    	            	for(int i=0; i<size;i++)
    	            	{
    	            		if(cancelBtn[i]==e.getSource())
    	            		{
    	            			index=i;
    	            			break;
    	            		}
    	            	}
                    	DBHelper.getInstance().cancelTicket(DBHelper.getInstance().getAudience().getTickets().get(index));
                        OrderView newOrderView=new OrderView(); // Main Form to show after the Login Form.
                        dispose();
                    }
                });
	}
}
