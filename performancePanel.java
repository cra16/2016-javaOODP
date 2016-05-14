/*import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class performancePanel extends JPanel implements ActionListener{
	private ArrayList<Product> performances;
	private Factory perFactory = ProgramGUI.getInstance().getPerFactory();
	JButton[] performance;
	
	
	
	private JDialog dialog = new JDialog();
	
	
	
	//for update
	private JTextField performancePlace = new JTextField(10);
	private JTextField performanceName = new JTextField(10);
	
	//identify line
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	private JButton ok= new JButton("ok");
	private JButton cancel = new JButton("cancel");
	
	JLabel pLabel = new JLabel("��� : ");
	JLabel nLabel = new JLabel("�����̸� :");
	
	
	
	
	public performancePanel()
	{
		int i = 0;
		
		performances = ProgramGUI.getInstance().getPerformances();
		performance = new JButton[performances.size()];
		
		for(Product perform : performances)
		{
			performance[i] = new JButton(perform.getChooseProduct().getName());
			performance[i].addActionListener(this);
			this.add(performance[i]);
			i++;
		}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) { 
		Object o = e.getSource();
		
		for(int i=0; i<performances.size();i++)
		{
			if(performance[i] == o)//���� ������ �� ������ ȭ��
			{
				
				JDialog Info= new PerformanceGUI(performances,i);
				Info.setLayout(new FlowLayout());
				
				Info.setSize(400,200);
				Info.setLayout(new FlowLayout());
				Info.setVisible(true);
			
			
			}
		}
		
		 if(ok==o)
		{
			performances.add(perFactory.createProduct(new Performance(0, ProgramGUI.getInstance().getHost(), performanceName.getText(), new java.sql.Date(2016-5-20), new java.sql.Time(210000),10)));
			ProgramGUI.getInstance().createPerformanceInformation();
			dialog.dispose();
		}
	}
}*/
