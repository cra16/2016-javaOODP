import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePerform2_View extends JFrame //implements ActionListener
{
    Container contentPane;
    String[] timestamp = {"15:00", "16:00", "17:00", "18:00","19:00","20:00","21:00","22:00"} ;
    int timeNum;
    HomeView_host newhost;
    UpdatePerformController controller =
			new UpdatePerformController();
    UpdatePerform2_View(Performance perform,String performName,int placeNum, int monthNum,int dayNum, int duration, String Text,int cost)
    {
        contentPane=this.getContentPane();
        JPanel add1panel = new JPanel();
        setBounds(80,80,250,500);
        this.setVisible(true);
        this.setLayout( null);


        JLabel title = new JLabel("공연 수정 - [2/2]");
        JLabel subtitle = new JLabel("<날짜별 시간 선택>");
        JButton btn1 = new JButton("완료");
        JButton btn2 = new JButton("취소");

        JLabel label[] = new JLabel[duration+1]; //SAMPLE 1
    	JComboBox drop[] = new JComboBox[duration+1];
        
        for(int i=0; i<duration+1; i++)
        {	
        	label[i] = new JLabel("날짜"+i +": ");
        	System.out.println(perform.getSchedule().getTime()[i]);
        	if(perform.getSchedule().getTime()[i]!=null)
        	{	
        	String[] splitString = perform.getSchedule().getTime()[i].toString().split(":");
        	timeNum = Integer.parseInt(splitString[0])-15;
        	}
        	drop[i] = new JComboBox(timestamp);
        	drop[i].setSelectedIndex(timeNum);
        	label[i].setBounds(30, 110+ (i*40), 70, 40); //SAMPLE 1
        	drop[i].setBounds(110, 110+(i*40), 100, 30);
        	 label[i].setFont(new java.awt.Font("Gulim", 0, 14));
             drop[i].setFont(new java.awt.Font("Gulim", 0, 14));
             
        	add1panel.add(label[i]); //SAMPLE 1
            add1panel.add(drop[i]);
           
        }
        title.setBounds(30, 20, 200, 40);
        subtitle.setBounds(30, 70, 170, 40);
       
        btn1.setBounds(160,420,70,50);
        btn2.setBounds(80,420,70,50);
        title.setFont(new Font("Gulim", Font.BOLD, 15));
        subtitle.setFont(new java.awt.Font("Gulim", 0, 14));
       

        add1panel.add(title);
        add1panel.add(subtitle);
        add1panel.add(btn1);
        add1panel.add(btn2);

        btn1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
            	
            	
            	String[] Time = new String[duration+1];
            		
            	
            	for(int i=0; i<duration+1;i++)
            	{
            		Time[i] = timestamp[drop[i].getSelectedIndex()];
            		
            	}
            	controller.eventUpdatePerformance(perform,performName,placeNum,monthNum, dayNum, Time, duration,Text,cost);
            	newhost =new HomeView_host();
                dispose();
            }
        });
        
        btn2.addActionListener(new ActionListener(){
            
        	public void actionPerformed(ActionEvent e)
        	{
        		dispose();
        	newhost =new HomeView_host();
        	}
        	
        });

        
        // frame setting
        add1panel.setVisible(true);
        add1panel.setLayout(null);
        setSize(350,600);
        this.setContentPane(add1panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}