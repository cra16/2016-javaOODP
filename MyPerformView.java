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
    private HomeView_host newhost;
    private UpdatePerform1_View updatePerform1;
    MyPerformView performView;
    MyPerformView(ArrayList<Product> performList){
    	
    	contentPane=this.getContentPane();
        setBounds(0,0,700,700);
        this.setVisible(true);
        this.setLayout( null);
        JPanel mypanel = new JPanel(new FlowLayout(1,50,5));
        JLabel[] labelName = new JLabel[performList.size()];
        JButton[] updateBtn = new JButton[performList.size()];
        JButton[] delBtn = new JButton[performList.size()];
        JButton backBtn = new JButton("뒤로가기");
        


        JPanel[] performpanel = new JPanel[performList.size()]; // SAMPLE
        for(int i=0; i<performpanel.length;i++)
	    {
	        FlowLayout fl = new FlowLayout(3,50,5);
	        labelName[i]= new JLabel(performList.get(i).getProductName());
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
	            	for(int i=0; i<performList.size();i++)
	            	{
	            		if(updateBtn[i]==e.getSource())
	            		{
	            			index=i;
	            			break;
	            		}
	            	}
	               updatePerform1= new UpdatePerform1_View(performList.get(index).getPerformance()); // Main Form to show after the Login Form.
	                dispose();
	            }
	        });
	        delBtn[i].addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		int index=0;
	        		for(int i=0; i<performList.size();i++)
	        		{
	        			if(delBtn[i]==e.getSource())
	        			{
	        				index=i;
	        				break;
	        				
	        			}
	        			
	        		}
	        		dispose();
	        		new DeletePerformController().eventDelete(performList.get(index), index);
	        	
        			performView= new MyPerformView(performList);
	        	}
	        });
	        
	        mypanel.add(performpanel[i]);
	    }
     

       
        backBtn.setFont(new java.awt.Font("Gulim", 0, 14));
        backBtn.setBounds(0,510,350,50);
        backBtn.addActionListener(new ActionListener(){
            
        	public void actionPerformed(ActionEvent e)
        	{
        		dispose();
        		newhost = new HomeView_host();
        	}
        	
        });
        mypanel.add(backBtn);

        // frame setting
        mypanel.setVisible(true);
        setSize(350,600);

        this.setContentPane(mypanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


}
