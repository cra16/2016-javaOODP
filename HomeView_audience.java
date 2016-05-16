import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView_audience extends JFrame //implements ActionListener
{
    Container contentPane;
    DBHelper dBHelper = DBHelper.getInstance();
    JButton[] perform;
    
    HomeView_audience()
    {
        contentPane=this.getContentPane();
        JPanel homepanel = new JPanel();
        setBounds(0,0,700,700);
        this.setVisible(true);
        this.setLayout( null);
        
        if(dBHelper.getPerforms().size() > 0){
	        perform = new JButton[dBHelper.getPerforms().size()];
	        for(int i=0;i<dBHelper.getPerforms().size();i++){
	        	perform[i] = new JButton(dBHelper.getPerforms().get(i));
	        	perform[i].setBounds(0,50*i,350,50);
	        	perform[i].setFont(new java.awt.Font("Gulim", 0, 16));
	        	homepanel.add(perform[i]);
	        	perform[i].addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
	        	        {
	        	            public void actionPerformed(ActionEvent e) {
	        	            	Object o = e.getSource();
	        	            	Performance p = null;
	        	            	for(int i=0; i<dBHelper.getPerforms().size();i++)
	        	            	{
	        	            		if(o==perform[i])
	        	            		{
	        	            			p=DBHelper.getInstance().getPerformance(perform[i].getText());
	        	            			break;
	        	            		}
	        	            		else
	        	            			p=null;
	        	            	}
	        	            	new BuyTicketView(p); // Main Form to show after the Login Form.

	        	                dispose();
	        	            }
	        	        });
	        }
        }

        // BUTTONS: 예매내역
        JButton orderList = new JButton("예매 내역");
        orderList.setBounds(0,550,350,50);
        orderList.setFont(new java.awt.Font("Gulim", 0, 16));
        homepanel.add(orderList);

        orderList.addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
        {
            public void actionPerformed(ActionEvent e) {
                new OrderView().setVisible(true); // Main Form to show after the Login Form.
                dispose();
            }
        });
        
        // frame setting
        homepanel.setVisible(true);
        homepanel.setLayout(null);
        setSize(350,600);
        this.setContentPane(homepanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}