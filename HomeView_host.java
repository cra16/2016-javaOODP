import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomeView_host extends HomeView //implements ActionListener
{    
	BlueAddPerformDecorator newAdd;
	MyPerformView newperformView;
    public void drawBottomButton(JPanel homepanel){
    	// BUTTONS: 공연등록, 내공연
        JButton addPerform = new JButton("공연 등록");
        JButton myPerform = new JButton("내 공연");

        addPerform.setBounds(0,510,175,50);
        myPerform.setBounds(175,510,175,50);
        addPerform.setFont(new java.awt.Font("Gulim", 0, 16));
        myPerform.setFont(new java.awt.Font("Gulim", 0, 16));

        homepanel.add(addPerform);
        homepanel.add(myPerform);

        addPerform.addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
        {
            public void actionPerformed(ActionEvent e) {
                newAdd = new BlueAddPerformDecorator(new AddPerform1_View()); // Main Form to show after the Login Form.
                dispose();
            }
        });
        myPerform.addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
        {
            public void actionPerformed(ActionEvent e) {
            	
            	newperformView= new MyPerformView(DBHelper.getInstance().getPerforms()); // Main Form to show after the Login Form.
                dispose();
            }
        });
    }
}