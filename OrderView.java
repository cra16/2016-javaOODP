/*
* 홈페이지에서 (Audience가) '예매내역' 접속 시 뜨는 예매내역 페이지.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class OrderView extends JFrame //implements ActionListener
{
    Container contentPane;
    DBHelper dBHelper = DBHelper.getInstance();
    
    String [] header = {"공연", "날짜"};
    Object[][] data =               // SAMPLE입니다!!
            {
                    {"공연", "날짜"},
                    {"곡성", "5/23"},
                    {"하이루", "1/2"},
                    {"즉새두", "2/3"},
            };

    OrderView()
    {
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
        		
		        perform[i] = new JLabel(tickets.get(i).getPerformanceName()+"  "+tickets.get(i).getDate()+" -- "+tickets.get(i).getTime());
		        perform[i].setBounds(0,50*i,240,50);
		        perform[i].setBorder(BorderFactory.createLineBorder(Color.lightGray));
		        perform[i].setHorizontalAlignment(JLabel.CENTER);
		        perform[i].setFont(new java.awt.Font("Gulim", 0, 15));
		
		        cancelBtn[i] = new JButton("예매취소");
		        cancelBtn[i].setBounds(250,50*i,100,50);
		        cancelBtn[i].setFont(new java.awt.Font("Gulim", 0, 15));
		
		        orderpanel.add(perform[i]);
		        orderpanel.add(cancelBtn[i]);
		        cancelBtn[i].addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
		                {
		                    public void actionPerformed(ActionEvent e) {
		                        new HomeView_audience().setVisible(true); // Main Form to show after the Login Form.
		                        dispose();
		                    }
		                });
        	}
        }
        // BUTTONS: 공연등록, 내공연
        JButton  closeBtn = new JButton("뒤로가기");
        closeBtn.setBounds(250,550,100,50);
        closeBtn.setFont(new java.awt.Font("Gulim", 0, 15));
        orderpanel.add(closeBtn);

        closeBtn.addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
        {
            public void actionPerformed(ActionEvent e) {
                new HomeView_audience().setVisible(true); // Main Form to show after the Login Form.
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