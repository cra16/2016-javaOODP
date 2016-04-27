import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;


public class ProgramGUI extends JFrame implements ActionListener
{
	public static JFrame Program;
	JPanel p1 = new JPanel();
	JButton[] b = new JButton[10];
	Container contentPane;
	JButton cancel = new JButton("�ڷΰ���");
	public ProgramGUI()
	{
		setTitle("title");
		setSize(1024,768);
		setLayout(new BorderLayout());
		createMainInformation();
		
	}
	
	public static JFrame getJFrame()
	{
		return Program;
	}
	
	public static void main(String[] args)
	{
		Program=new ProgramGUI();
	}
	
	
	public void createMainInformation()
	{
		p1.removeAll();
	
		
		contentPane= this.getContentPane();
		contentPane.setBackground(Color.BLUE);
			
		
		p1.setBackground(Color.RED);
		
		String[] button_name = {"��������","Ƽ������","Ƽ�Ͽ���"};
		
		for(int i =0; i<3; i++)
		{	
			
			b[i]= new JButton();
			b[i].setText(button_name[i]);
			b[i].addActionListener(this);
			p1.add(b[i]);
			
		}
		
		contentPane.removeAll();
		contentPane.add(p1);
		contentPane.revalidate();
		this.repaint();
		setVisible(true);		
	}
	
	public void createPerformanceInformation()
	{
		p1.removeAll();
		JPanel temppanel = new JPanel();
		
		cancel.addActionListener(this);
		
		temppanel.add(cancel);
		contentPane.add(temppanel,BorderLayout.NORTH);
		contentPane.revalidate();
		repaint();
	}
	
	public void createBuyFrame()
	{
		contentPane.removeAll();
		contentPane.add(new buyPanel());
		contentPane.revalidate();
		this.repaint();
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		//state pattern
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
			else if(o==cancel)
			{
				createMainInformation();
				return;
			}
		}
	
	
	public void createTicketInformation()
	{
		JButton[] c = new JButton[10];
		JPanel temppanel = new JPanel();


		for(int j =0; j<3; j++)
		{
			c[j]= new JButton();
			c[j].setText(Integer.toString('��'));
			c[j].addActionListener(this);
			temppanel.add(c[j],BorderLayout.NORTH);
			
		}
		
		
		cancel.addActionListener(this);
		temppanel.add(cancel,BorderLayout.EAST);
		
		
		
		String[] header = {"Ƽ���̸�","Ƽ�Ϲ�ȣ","�¼���ȣ"};
		String[][] contents = {{"����","1","1"},{"�˼�","2","2"},{"�� ����","3","3"}};
		JTable table = TicketTable.createTable(contents, header);
		
		contentPane.removeAll();
		contentPane.add(temppanel,BorderLayout.NORTH);
		contentPane.add(table,BorderLayout.CENTER);
		
		
		
		contentPane.revalidate(); 
		
		
		this.repaint();
	}
}
