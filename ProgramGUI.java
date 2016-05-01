import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;


public class ProgramGUI extends JFrame implements ActionListener
{
	public static JFrame Program;
	public static ProgramGUI programGUI;
	private Seller[] seller= new Seller[4];
	private Buyer[] buyer = new Buyer[4];
	private int currentpage=-1;
	
	
	JPanel p1 = new JPanel();
	JButton[] b = new JButton[10];
	Container contentPane;
	JButton cancel = new JButton("뒤로가기");
	JButton add = new JButton("추가");
	JButton update = new JButton("update");
	
	int user=0;
	
	JButton login = new JButton("Login");
	JRadioButton checkbuyer = new JRadioButton("buyer",false);
	JRadioButton checkseller = new JRadioButton("seller",false);
	ButtonGroup btngroup = new ButtonGroup();
	
	JDialog logindialog= new JDialog();
	
	//singleton
	private ProgramGUI()
	{
		seller[0]=new Seller("임현우","01093045749","darkzero");
		setTitle("title");
		setSize(1024,768);
		setLayout(new BorderLayout());
		this.setVisible(false);
		
		createLogin();
	}
	public static ProgramGUI getInstance()
	{
		if(programGUI == null)
		{
			programGUI = new ProgramGUI();
		}
		return programGUI;
		
	}
	

	
	public static JFrame getJFrame()
	{
		return Program;
	}
	
	public ProgramGUI getProgmGUI()
	{
		return this;
	}
	
	public static void main(String[] args)
	{
		Program=ProgramGUI.getInstance();
	}
	
	
	public void createLogin()
	{
		logindialog.setLayout(new FlowLayout());
		contentPane = logindialog.getContentPane();
		logindialog.setSize(200,200);
		btngroup.add(checkbuyer);
		btngroup.add(checkseller);
		
		login.addActionListener(this);
		
		contentPane.add(checkbuyer);
		contentPane.add(checkseller);
		contentPane.add(login);
		
		
		logindialog.setVisible(true);
		
	}
	
	public void createMainInformation()
	{
		currentpage=0;
		
		if(contentPane!=null)
			contentPane.removeAll();
		contentPane= this.getContentPane();
		contentPane.setBackground(Color.BLUE);
			
		
		p1.setBackground(Color.RED);
		
		String[] button_name = {"공연정보","티켓정보","티켓예약"};
		int[] checkuser = {1,2,2};
		for(int i =0; i<3; i++)
		{	
			
			b[i]= new JButton();
			b[i].setText(button_name[i]);
			b[i].addActionListener(this);
			
			if(user==checkuser[i])
				p1.add(b[i]);
			
		}
		
		contentPane.removeAll();
		contentPane.add(p1);
		
		this.repaint();
		setVisible(true);		
	}
	
	public void createPerformanceInformation()
	{
		currentpage=1;
		
		contentPane.removeAll();
		cancel.removeActionListener(this);
		update.removeActionListener(this);
		add.removeActionListener(this);
		
		JPanel temppanel = new performancePanel(seller[0].getPerformance(),seller[0].getPcount());
		JPanel temppanel2=new JPanel();
		cancel.addActionListener(this);
		update.addActionListener(this);
		add.addActionListener(this);
		
		temppanel2.add(add);
		temppanel2.add(update);
		temppanel2.add(cancel);
		
		
		
		contentPane.add(temppanel,BorderLayout.NORTH);
		contentPane.add(temppanel2,BorderLayout.SOUTH);
		contentPane.revalidate();
		repaint();
	}
	
	public void createBuyFrame()
	{
		currentpage=2;
		JPanel bpanel = new buyPanel();
		contentPane.removeAll();
		contentPane.add(bpanel);
		
		cancel.addActionListener(this);
		
		bpanel.add(cancel);
		
		contentPane.revalidate();
		this.repaint();
	}
	
	

	
	
	public void createTicketInformation()
	{
		currentpage=3;
		JButton[] c = new JButton[10];
		JPanel temppanel = new JPanel();
		JPanel temppanel2 = new JPanel();
		contentPane.removeAll();
		cancel.removeActionListener(this);
		update.removeActionListener(this);
		add.removeActionListener(this);


		for(int j =0; j<3; j++)
		{
			c[j]= new JButton();
			c[j].setText(Integer.toString('x'));
			c[j].addActionListener(this);
			temppanel.add(c[j],BorderLayout.NORTH);
			
		}
		
		
		cancel.addActionListener(this);
		update.addActionListener(this);
		add.addActionListener(this);
		
		temppanel2.add(cancel);
		temppanel2.add(update);
		temppanel2.add(add);
		
		
		
		String[] header = {"티켓이름","티켓번호","좌석번호"};
		String[][] contents = {{"몰라","1","1"},{"알수","2","2"},{"가 없네","3","3"}};
		JTable table = TicketTable.createTable(contents, header);
		
		
		contentPane.add(temppanel,BorderLayout.NORTH);
		contentPane.add(table,BorderLayout.CENTER);
		contentPane.add(temppanel2,BorderLayout.SOUTH);
		
		
		contentPane.revalidate(); 
		
		
		this.repaint();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		//state pattern??
			if(o==b[0])
			{
				createPerformanceInformation();
			}
			else if(o==b[1])
			{	
				createTicketInformation();
				System.out.println("GGGG");
				return;
			}
			else if(o==b[2])
			{
				createBuyFrame();
				return;
			}
			else if(o==add &&currentpage==1)
			{

				seller[0].addPerformacne();
				createPerformanceInformation();
			}
			else if(o==update &&currentpage==1)
			{
				
			
				seller[0].modifyPerformance();
				createPerformanceInformation();
			}
			else if(o==cancel&&currentpage==1)
			{
				p1.removeAll();
				createMainInformation();
				return;
			}
			
			else if(o==add &&currentpage==2)
			{
				seller[0].addPerformacne();
				createPerformanceInformation();
			}
			else if(o==update &&currentpage==2)
			{
				seller[0].modifyPerformance();
				createPerformanceInformation();
			}
			else if(o==cancel&&currentpage==2)
			{
				p1.removeAll();
				createMainInformation();
				return;
			}
			
			
			else if(o==add &&currentpage==3)
			{
				seller[0].addPerformacne();
				
			}
			else if(o==update &&currentpage==3)
			{
				seller[0].modifyPerformance();
				createPerformanceInformation();
			}
			else if(o==cancel&&currentpage==3)
			{
				p1.removeAll();
				createMainInformation();
				return;
			}
			else if(o==add &&currentpage==1)
			{
				seller[0].addPerformacne();
				createPerformanceInformation();
			}
			else if(o==update &&currentpage==1)
			{
				seller[0].modifyPerformance();
				createPerformanceInformation();
			}
			else if(o==cancel&&currentpage==1)
			{
				p1.removeAll();
				createMainInformation();
				return;
			}
			
			else if(o==login)
			{
				if(checkbuyer.isSelected() == true)
				{
					user = 1;
					logindialog.setVisible(false);
					createMainInformation();
				}
				else if(checkseller.isSelected() == true)
				{
					user=2;
					logindialog.setVisible(false);
					createMainInformation();
				}
				
			
			}
		}
}
