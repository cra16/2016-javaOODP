import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class buyPanel extends JPanel implements ActionListener{
	
	JButton[] ticketInformation = new JButton[10];
	
	public buyPanel()
	{
		
		
		
		for(int i=0; i<10;i++)
		{
			ticketInformation[i]=new JButton("ǥ" + i);
			ticketInformation[i].addActionListener(this);
			this.add(ticketInformation[i]);
			
		}
		
		
	}
	
	public void create()
	{
	a
		
	}

	@Override
	public void actionPerformed(ActionEvent e) { 
		Object o = e.getSource();
		
		
		if(ticketInformation[0] == o)
		{
			JDialog buyticket = new JDialog(ProgramGUI.getJFrame(),"A",true);
			System.out.print("ffff");
			buyticket.setSize(100,100);
			buyticket.setLayout(new FlowLayout());
			buyticket.add(new JLabel("This is good data",JLabel.CENTER));
			buyticket.add(new JButton("GGGG"));
			
			buyticket.setVisible(true);
			buyticket.dispose();
		}
		
	}
}
