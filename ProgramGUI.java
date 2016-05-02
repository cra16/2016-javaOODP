import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;


public class ProgramGUI extends JFrame implements ActionListener
{
	public static JFrame Program;
	public static ProgramGUI programGUI;
	private Host host;
	private Buyer buyer = new Buyer();
	private int currentpage=-1;
	private ArrayList<Performance> performances = new ArrayList<Performance>();
	
	JPanel p1 = new JPanel();
	JButton[] b = new JButton[10];
	Container contentPane;
	JButton cancel = new JButton("뒤로가기");
	JButton add = new JButton("추가");
	JButton update = new JButton("update");
	
	//singleton
	private ProgramGUI()
	{
		host=new Host("임현우","01093045749","darkzero");
		setTitle("title");
		setSize(512,384);
		setLayout(new BorderLayout());
		createMainInformation();
		
	}
	public static ProgramGUI getInstance()
	{
		if(programGUI == null)
		{
			programGUI = new ProgramGUI();
		}
		return programGUI;
		
	}
	
	public ArrayList<Performance> getPerformances() {
		return performances;
	}
	public void setPerformances(ArrayList<Performance> performances) {
		this.performances = performances;
	}
	public static JFrame getJFrame()
	{
		return Program;
	}
	
	public Host getHost() {
		return host;
	}
	public void setHost(Host host) {
		this.host = host;
	}
	
	public ProgramGUI getProgmGUI()
	{
		return this;
	}
	
	public static void main(String[] args)
	{
		Program=ProgramGUI.getInstance();
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
		
		for(int i =0; i<3; i++)
		{	
			
			b[i]= new JButton();
			b[i].setText(button_name[i]);
			b[i].addActionListener(this);
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
		
		JPanel performPanelTop = new performancePanel();
		JPanel performPanelBottom = new JPanel();
		cancel.addActionListener(this);
		add.addActionListener(this);
		
		performPanelBottom.add(add);
		performPanelBottom.add(cancel);
		
		contentPane.add(performPanelTop,BorderLayout.NORTH);
		contentPane.add(performPanelBottom,BorderLayout.SOUTH);
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
		JPanel performPanelTop = new JPanel();
		JPanel performPanelBottom = new JPanel();
		contentPane.removeAll();
		cancel.removeActionListener(this);
		update.removeActionListener(this);
		add.removeActionListener(this);


		for(int j =0; j<3; j++)
		{
			c[j]= new JButton();
			c[j].setText(Integer.toString('x'));
			c[j].addActionListener(this);
			performPanelTop.add(c[j],BorderLayout.NORTH);
			
		}
		
		
		cancel.addActionListener(this);
		update.addActionListener(this);
		add.addActionListener(this);
		
		performPanelBottom.add(cancel);
		performPanelBottom.add(add);
		
		
		
		String[] header = {"티켓이름","티켓번호","좌석번호"};
		String[][] contents = {{"몰라","1","1"},{"알수","2","2"},{"가 없네","3","3"}};
		JTable table = TicketTable.createTable(contents, header);
		
		
		contentPane.add(performPanelTop,BorderLayout.NORTH);
		contentPane.add(table,BorderLayout.CENTER);
		contentPane.add(performPanelBottom,BorderLayout.SOUTH);
		
		
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
				return;
			}
			else if(o==b[2])
			{
				createBuyFrame();
				return;
			}
			else if(o==add &&currentpage==1)
			{
				AddPerformance.addPerformacne();
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
				AddPerformance.addPerformacne();
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
				AddPerformance.addPerformacne();
				
			}
			else if(o==cancel&&currentpage==3)
			{
				p1.removeAll();
				createMainInformation();
				return;
			}
			else if(o==add &&currentpage==1)
			{
				AddPerformance.addPerformacne();
				createPerformanceInformation();
			}
			else if(o==cancel&&currentpage==1)
			{
				p1.removeAll();
				createMainInformation();
				return;
			}
		}
}
