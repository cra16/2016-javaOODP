import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView_audience extends JFrame //implements ActionListener
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
    
    HomeView_audience()
    {
        contentPane=this.getContentPane();
        JPanel homepanel = new JPanel();
        setBounds(0,0,700,700);
        this.setVisible(true);
        this.setLayout( null);
        
        while(dBHelper.getPerforms().iterator().hasNext()){
        	int i=0;
        	perform[i] = new JButton(dBHelper.getPerforms().get(i));
        	perform[i].setBounds(0,0,350,50);
        	perform[i].setFont(new java.awt.Font("Gulim", 0, 16));
        	homepanel.add(perform[i]);
        	perform[i].addActionListener(new ActionListener()  // 공연등록 버튼 페이지 경로
        	        {
        	            public void actionPerformed(ActionEvent e) {
        	                new BuyTicketView(); // Main Form to show after the Login Form.
        	                dispose();
        	            }
        	        });
        	i++;
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