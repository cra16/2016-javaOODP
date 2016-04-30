import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class performancePanel extends JPanel implements ActionListener{

	
	JButton[] performance = new JButton[8];
	Performance[] perObject;
	JButton update=new JButton("update");
	JButton delete=new JButton("삭제");
	
	private JDialog dialog = new JDialog();
	JLabel plabel = new JLabel();
	JLabel hlabel = new JLabel();
	JLabel slabel = new JLabel();
	JLabel nlabel = new JLabel();
	private JTextField Pplace = new JTextField(10);
	private JTextField Phost = new JTextField(10);
	private JTextField Pseat = new JTextField (10);
	private JTextField Pname = new JTextField (10);
	
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	
	
	private JButton ok= new JButton("ok");
	private JButton cancel = new JButton("cancel");
	
	
	JLabel pLabel = new JLabel("장소 :");
	JLabel hLabel = new JLabel("주최지:");
	JLabel sLabel = new JLabel("좌석수 :");
	JLabel nLabel = new JLabel("공연이름 :");
	JDialog Info= new JDialog(ProgramGUI.getJFrame(),"A",true);
	
	
	
	public performancePanel(Performance[] object,int count)
	{
		perObject = object;

		for(int i=0; i<count;i++)
		{
			performance[i]=new JButton(perObject[i].getName());
			performance[i].addActionListener(this);
			this.add(performance[i]);
			
		}
	}

	public void create()
	{
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) { 
		Object o = e.getSource();
		
		
		if(performance[0] == o)
		{
			update.removeActionListener(this);
			delete.removeActionListener(this);
			
			System.out.print("ffff");
			Info.setSize(200,200);
			Info.setLayout(new FlowLayout());
			
			plabel.setText("장소 : " +perObject[0].getPlace());
			hlabel.setText("주최자 : " +perObject[0].getPlace());
			nlabel.setText("공연이름 : " +perObject[0].getName());
			
			Info.add(plabel);
			Info.add(hlabel);
			Info.add(nlabel);
			
			update.addActionListener(this);
			delete.addActionListener(this);
			
			Info.add(update);
			Info.add(delete);
			Info.setVisible(true);
		
		}
		else if(update==o)
		{
			
			ok.removeActionListener(this);
			cancel.removeActionListener(this);
			
			panel.add(pLabel);
			panel.add(Pplace);
			panel.add(hLabel);
			panel.add(Phost);
			panel2.add(sLabel);
			panel2.add(Pseat);
			panel2.add(nLabel);
			panel2.add(Pname);
			
			System.out.println("DDD");
			
			ok.addActionListener(this);
			cancel.addActionListener(this);
			dialog.setSize(500,400);
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
			perObject[0].setName(Pname.getText());
			perObject[0].setPlace(Pplace.getText());
			perObject[0].setHost(Phost.getText());
			ProgramGUI.getInstance().createPerformanceInformation();
			dialog.setVisible(false);
			
			
		}
	}
}
