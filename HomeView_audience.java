import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView_audience extends HomeView //implements ActionListener
{    
	 OrderView order;
	 LoginView login;
	 
    public void drawBottomButton(JPanel homepanel){
    	// BUTTONS: 예매내역
        JButton orderList = new JButton("예매 내역");
        JButton logout = new JButton("logout");
        
        orderList.setBounds(0,510,175,50);
        logout.setBounds(175,510,175,50);
        
        orderList.setFont(new java.awt.Font("Gulim", 0, 16));
        logout.setFont(new java.awt.Font("Gulim", 0, 16));
        
        homepanel.add(orderList);
        homepanel.add(logout);

        orderList.addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
        {
            public void actionPerformed(ActionEvent e) {
                order = new OrderView(); // Main Form to show after the Login Form.
                dispose();
            }
        });
        
        logout.addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
        {
            public void actionPerformed(ActionEvent e) {
            	DBHelper.getInstance().setDBHelper(null);
            	login = new LoginView();
            	dispose();
            }
        });
    }
}