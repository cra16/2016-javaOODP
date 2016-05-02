import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DeletePerformance implements ActionListener{
	private JDialog dialog = new JDialog();
	
	private JPanel panel1= new JPanel();
	private JPanel panel2= new JPanel();
	JButton delete = new JButton();
	JButton cancel = new JButton();
	private int currentIndex;
	private ArrayList<Performance> performances = ProgramGUI.getInstance().getPerformances();
	
	public JDialog deletePerformance(int currentIndex)
	{
		this.currentIndex= currentIndex;
		JLabel label = new JLabel("이 공연을 삭제 하시겠습니까?");
		
		delete.addActionListener(this);
		cancel.addActionListener(this);
		
		panel1.add(label);
		panel2.add(delete);
		panel2.add(cancel);
		
		
		
		dialog.add(panel1);
		dialog.add(panel2);
		return dialog;
		
	}
	public void eventDeletePerformance(int currentIndex){
		
		performances.remove(currentIndex);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object o = e.getSource();
		
		if(o==delete)
		{
			eventDeletePerformance(currentIndex);
			ProgramGUI.getInstance().createPerformanceInformation();
			dialog.setVisible(false);
		}
		else if(o==cancel)
		{
			dialog.setVisible(false);

		}
			
		
	}
}
