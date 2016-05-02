import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddPerformance implements ActionListener {
	private ArrayList<Performance> performances = ProgramGUI.getInstance().getPerformances();
	
	private JDialog dialog = new JDialog();
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	JLabel pLabel = new JLabel("장소 :");
	JLabel nLabel = new JLabel("공연이름 :");
	
	private JTextField performancePlace = new JTextField(10);
	private JTextField performanceName = new JTextField(10);
	private JButton ok = new JButton("ok");
	private JButton cancel = new JButton("cancel");
	
	public void addPerformacne()
	{
		panel.add(pLabel);
		panel.add(performancePlace);
		panel2.add(nLabel);
		panel2.add(performanceName);
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		dialog.setSize(500,400);
		panel3.add(ok);
		panel3.add(cancel);
		dialog.setLayout(new FlowLayout(FlowLayout.LEFT,10,15));
		dialog.add(panel);
		dialog.add(panel2);
		dialog.add(panel3);
		dialog.setVisible(true);
	}

	public void eventAddPerformance()
	{
		performances.add(new Performance(0, ProgramGUI.getInstance().getHost(), performanceName.getText(), new java.sql.Date(2016-5-20), new java.sql.Time(210000)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		System.out.println("클릭 작동");
		if(o==ok)
		{
			System.out.println("ok 작동");
			eventAddPerformance();
			ProgramGUI.getInstance().createPerformanceInformation();
			dialog.setVisible(false);
		}
		else if(o==cancel)
		{
			System.out.println("cancel 작동");
			ProgramGUI.getInstance().createPerformanceInformation();
			dialog.setVisible(false);
		}
		// TODO Auto-generated method stub
		
	}
}
