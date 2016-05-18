/*
* 홈페이지에서 (Audience가) '예매내역' 접속 시 뜨는 예매내역 페이지.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class OrderView extends JFrame //implements ActionListener
{
	private Container contentPane;
    private DBHelper dBHelper;
    private CancelTicketState ticketState = PossibleState.getInstance();
    private HomeView_audience newaudience;
    OrderView()
    {
    	dBHelper = DBHelper.getInstance();
        contentPane=this.getContentPane();
        JPanel orderpanel = new JPanel();
        setBounds(0,0,700,700);
        this.setVisible(true);
        this.setLayout( null);
        
        ArrayList<Ticket> tickets = dBHelper.getAudience().getTickets();
        if(dBHelper.getAudience().getTickets().size() > 0){
        	JLabel[] perform = new JLabel[tickets.size()];
        	JButton[] cancelBtn = new JButton[tickets.size()];
        	for(int i=0;i<tickets.size();i++){
        		String date="";
                String time="";
                String[] splitString =tickets.get(i).getDate().toString().split("-");
                date = splitString[1]+"/"+splitString[2];
                
                splitString = tickets.get(i).getTime().toString().split(":");
            	time = splitString[0]+":"+splitString[1];
            	
		        perform[i] = new JLabel(tickets.get(i).getPerformanceName()+"  "+date+" -- "+time);
		        perform[i].setBounds(0,50*i,240,50);
		        perform[i].setBorder(BorderFactory.createLineBorder(Color.lightGray));
		        perform[i].setHorizontalAlignment(JLabel.CENTER);
		        perform[i].setFont(new java.awt.Font("Gulim", 0, 15));
		        
		        orderpanel.add(perform[i]);
		        
		        System.out.println(tickets.get(i).getDate());
		        ticketState = ticketState.checkDay(tickets.get(i).getDate());
		        ticketState.makeCancelBtn(orderpanel, cancelBtn, i, tickets.size());
        	}
        }
        // BUTTONS: 공연등록, 내공연
        JButton  closeBtn = new JButton("뒤로가기");
        closeBtn.setBounds(0,510,350,50);
        closeBtn.setFont(new java.awt.Font("Gulim", 0, 15));
        orderpanel.add(closeBtn);

        closeBtn.addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
        {
            public void actionPerformed(ActionEvent e) {
                newaudience = new HomeView_audience(); // Main Form to show after the Login Form.
                dispose();
            }
        });

        // frame setting
        orderpanel.setVisible(true);
        orderpanel.setLayout(null);
        setSize(350,600);
        this.setContentPane(orderpanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}