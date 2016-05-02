import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class performancePanel extends JPanel implements ActionListener{
	JButton[] performance;
	private ArrayList<Performance> performances;
	JButton update=new JButton("update");
	JButton delete=new JButton("삭제");
	
	private JDialog dialog = new JDialog();
	
	//for information
	JLabel plabel = new JLabel();
	JLabel hlabel = new JLabel();
	JLabel slabel = new JLabel();
	JLabel nlabel = new JLabel();
	
	//for update
	private JTextField performancePlace = new JTextField(10);
	private JTextField performanceName = new JTextField(10);
	
	//identify line
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	private JButton ok= new JButton("ok");
	private JButton cancel = new JButton("cancel");
	
	JLabel pLabel = new JLabel("장소 : ");
	JLabel nLabel = new JLabel("공연이름 :");
	
	JDialog Info= new JDialog(ProgramGUI.getJFrame(),"A",true);
	
	
	public performancePanel()
	{
		int i = 0;
		
		performances = ProgramGUI.getInstance().getPerformances();

		for(Performance perform : performances)
		{
			performance[i] = new JButton(perform.getName());
			performance[i].addActionListener(this);
			this.add(performance[i]);
			i++;
		}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) { 
		Object o = e.getSource();
		
		
		if(performances.get(0) == o)
		{
			update.removeActionListener(this);
			delete.removeActionListener(this);
			
			Info.setSize(200,200);
			Info.setLayout(new FlowLayout());
			
			plabel.setText("장소 : " +performances.get(0).getPlaceName());
			hlabel.setText("주최자 : " +ProgramGUI.getInstance().getHost().getName());
			slabel.setText("잔여 좌석수 : " + (performances.get(0).getMaxSeat() - performances.get(0).getCurrentNum()));
			nlabel.setText("공연이름 : " +performances.get(0).getName());
			
			Info.add(plabel);
			Info.add(hlabel);
			Info.add(slabel);
			Info.add(nlabel);
			
			update.addActionListener(this);
			delete.addActionListener(this);
			
			Info.add(update);
			Info.add(delete);
			Info.setVisible(true);
		
		}
		else if(update == o)
		{
			ok.removeActionListener(this);
			cancel.removeActionListener(this);
			
			panel.add(pLabel);
			panel.add(performancePlace);
			panel2.add(nLabel);
			panel2.add(performanceName);
			
			ok.addActionListener(this);
			cancel.addActionListener(this);
			dialog.setSize(300,300);
			panel3.add(ok);	
			panel3.add(cancel);
			dialog.setLayout(new FlowLayout(FlowLayout.LEFT,10,15));
			dialog.add(panel);
			dialog.add(panel2);
			dialog.add(panel3);
			Info.setVisible(false);
			dialog.setVisible(true);
		}
		
		else if(ok==o)
		{
			performances.add(new Performance(0, ProgramGUI.getInstance().getHost(), performanceName.getText(), new java.sql.Date(2016-5-20), new java.sql.Time(210000)));
			ProgramGUI.getInstance().createPerformanceInformation();
			dialog.setVisible(false);
		}
	}
}
