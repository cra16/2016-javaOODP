import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView_audience extends HomeView //implements ActionListener
{    
    public void drawBottomButton(JPanel homepanel){
    	// BUTTONS: 예매내역
        JButton orderList = new JButton("예매 내역");
        orderList.setBounds(0,510,350,50);
        orderList.setFont(new java.awt.Font("Gulim", 0, 16));
        homepanel.add(orderList);

        orderList.addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
        {
            public void actionPerformed(ActionEvent e) {
                new OrderView().setVisible(true); // Main Form to show after the Login Form.
                dispose();
            }
        });
    }
}