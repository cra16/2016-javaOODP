import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomeView_host extends HomeView //implements ActionListener
{    
	MyPerformView newperformView;
	AddPerform1_View addView;
	LoginView login;
	
    public void drawBottomButton(JPanel homepanel){
    	// BUTTONS: 공연등록, 내공연
        JButton addPerform = new JButton("공연 등록");
        JButton myPerform = new JButton("내 공연");
        JButton logout = new JButton("logout");

        addPerform.setBounds(0,510,115,50);
        myPerform.setBounds(115,510,115,50);
        logout.setBounds(230,510,115,50);
        addPerform.setFont(new java.awt.Font("Gulim", 0, 16));
        myPerform.setFont(new java.awt.Font("Gulim", 0, 16));
        logout.setFont(new java.awt.Font("Gulim", 0, 16));
        
        homepanel.add(addPerform);
        homepanel.add(myPerform);
        homepanel.add(logout);

        addPerform.addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
        {
            public void actionPerformed(ActionEvent e) {
            	addView = new AddPerform1_View(); // Main Form to show after the Login Form.
            	 DBHelper.getInstance().getAddorigin().setView(addView);
                 DBHelper.getInstance().getAddmemento().addAddMemento(DBHelper.getInstance().getAddorigin().createAddMemento());
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