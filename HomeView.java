import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomeView extends JFrame //implements ActionListener
{
    Container contentPane;
    String [] header = {"공연", "날짜"};
    Object[][] data =               // SAMPLE입니다!!
            {
                    {"공연", "날짜"},
                    {"곡성", "5/23"},
                    {"하이루", "1/2"},
                    {"즉새두", "2/3"},
            };
    DBHelper dBHelper = DBHelper.getInstance();
    JButton[] perform;

    HomeView()
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
	        	            	Performance p=null;
	        	            	for(int i=0; i<dBHelper.getPerforms().size();i++)
	        	            	{
	        	            		if(o==perform[i]){
	        	            			p=DBHelper.getInstance().getPerformance(perform[i].getText());
	        	            		}
	        	            	}
	        	            	
	        	                new  BuyTicketView(p); // Main Form to show after the Login Form.
	        	                dispose();
	        	            }
	        	        });
	        }
        }

        // BUTTONS: 공연등록, 내공연
        JButton addPerform = new JButton("공연 등록");
        JButton myPerform = new JButton("내 공연");

        addPerform.setBounds(0,550,175,50);
        myPerform.setBounds(175,550,175,50);
        addPerform.setFont(new java.awt.Font("Gulim", 0, 16));
        myPerform.setFont(new java.awt.Font("Gulim", 0, 16));

        homepanel.add(addPerform);
        homepanel.add(myPerform);

        addPerform.addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
        {
            public void actionPerformed(ActionEvent e) {
                new AddPerform1_View().setVisible(true); // Main Form to show after the Login Form.
                dispose();
            }
        });
        myPerform.addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
        {
            public void actionPerformed(ActionEvent e) {
            	
                new MyPerformView(null).setVisible(true); // Main Form to show after the Login Form.
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