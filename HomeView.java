import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class HomeView extends JFrame{
	protected Container contentPane;
    protected DBHelper dBHelper;
    protected JButton[] perform;
    
    public abstract void drawBottomButton(JPanel homepanel);
    HomeView(){
    	draw_HomeView();
    }
    public final void draw_HomeView(){
    	dBHelper = DBHelper.getInstance();
        contentPane=this.getContentPane();
        JPanel homepanel = new JPanel();
        setBounds(0,0,700,700);
        this.setVisible(true);
        this.setLayout( null);
        
        if(dBHelper.getPerforms().size() > 0){
	        perform = new JButton[dBHelper.getPerforms().size()];
	        for(int i=0;i<dBHelper.getPerforms().size();i++){
	        	perform[i] = new JButton(((Performance)dBHelper.getPerforms().get(i)).getName());
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

        drawBottomButton(homepanel);
        
        // frame setting
        homepanel.setVisible(true);
        homepanel.setLayout(null);
        setSize(350,600);
        this.setContentPane(homepanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    };
}
