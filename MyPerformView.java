import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MyPerformView extends JFrame {

    Container contentPane;
    String [] header = {"공연", "날짜"};
    Object[][] data =               // SAMPLE입니다!!
            {
                    {"공연", "날짜"},
                    {"곡성", "5/23"},
                    {"하이루", "1/2"},
                    {"즉새두", "2/3"},
            };


    MyPerformView(ArrayList<String> performName){
    	
    	contentPane=this.getContentPane();
        setBounds(0,0,700,700);
        this.setVisible(true);
        this.setLayout( null);
        Performance[] perform = new Performance[performName.size()];
        for(int i=0; i<performName.size(); i++)
        {
        	perform[i]=DBHelper.getInstance().getPerformance(performName.get(i));
        }
        JPanel mypanel = new JPanel(new FlowLayout(1,50,5));
        JLabel[] labelName = new JLabel[performName.size()];
        JButton[] updateBtn = new JButton[performName.size()];
        JButton[] delBtn = new JButton[performName.size()];
        JButton backBtn = new JButton("뒤로가기");
        


        JPanel[] performpanel = new JPanel[performName.size()]; // SAMPLE
        for(int i=0; i<performpanel.length;i++)
	    {
	        FlowLayout fl = new FlowLayout(3,50,5);
	        labelName[i]= new JLabel(perform[i].getName());
	        updateBtn[i]= new JButton("수정");
	        delBtn[i]= new JButton("삭제");
	        performpanel[i] = new JPanel();
	        performpanel[i].setLayout(fl);
	        performpanel[i].add(labelName[i]);           // mypanel 하나에 공연/삭제버튼/수정버튼 포함.
	        performpanel[i].add(updateBtn[i]);
	        performpanel[i].add(delBtn[i]);
	        
	        delBtn[i].setHorizontalAlignment(SwingConstants.CENTER);
	        delBtn[i].setFont(new java.awt.Font("Gulim", 0, 14));
	        updateBtn[i].setFont(new java.awt.Font("Gulim", 0, 14));
	        labelName[i].setFont(new java.awt.Font("Gulim", 0, 14));
	        
	        updateBtn[i].addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e) {
	            	int index=0;
	            	for(int i=0; i<performName.size();i++)
	            	{
	            		if(updateBtn[i]==e.getSource())
	            		{
	            			index=i;
	            			break;
	            		}
	            	}
	                new UpdatePerform1_View(perform[index]).setVisible(true); // Main Form to show after the Login Form.
	                dispose();
	            }
	        });
	        
	        mypanel.add(performpanel[i]);
	    }
     

       
        
        backBtn.setBounds(240,420,70,50);
        backBtn.addActionListener(new ActionListener(){
            
        	public void actionPerformed(ActionEvent e)
        	{
        		dispose();
        		new HomeView();
        	}
        	
        });
        mypanel.add(backBtn);
        
        
        
        
        


        





        // frame setting
        mypanel.setVisible(true);
        mypanel.setVisible(true);
        setSize(350,600);

        this.setContentPane(mypanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


}
