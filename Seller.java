import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Seller implements ActionListener {

	private String name;
	private String phonenumber;
	private String userID;
	private Performance[] performance=new Performance[4];
	
	
	private JDialog dialog = new JDialog();
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	JLabel pLabel = new JLabel("장소 :");
	JLabel hLabel = new JLabel("주최지:");
	JLabel sLabel = new JLabel("좌석수 :");
	JLabel nLabel = new JLabel("공연이름 :");
	
	private JTextField Pplace = new JTextField(10);
	private JTextField Phost = new JTextField(10);
	private JTextField Pseat = new JTextField (10);
	private JTextField Pname = new JTextField (10);
	private JButton ok= new JButton("ok");
	private JButton cancel = new JButton("cancel");
	
	private int pcount=0;
	
	public Seller(String name, String phonenumber,String userID)
	{
		this.name =name;
		this.phonenumber = phonenumber;
		this.userID= userID;
	}
	
	
	public void addPerformacne()
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
	
	public void eventAddPerformance(String place, String host, int seat, String name)
	{
		performance[pcount] = new Performance(place,host,seat,name);
		pcount++;

	
	}
	
	public void modifyPerformance()
	{
		
	}
	public void eventModifyPerformance(String name,String pername, int seat, String placename)
	{
		
		for(int i=0; i<pcount; i++)
		{
			if(performance[i].getName().equals(name))
			{
				performance[i].setName(pername);
				performance[i].setPlace(placename);
				
			}		
		}
	}
	public void showPerformance()
	{
		
	}
	public void cancelPerformance()
	{
		
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Performance[] getPerformance() {
		return performance;
	}
	public void setPerformance(Performance[] performance) {
		this.performance = performance;
	}
	public int getPcount() {
		return pcount;
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o==ok)
		{
			eventAddPerformance(Pplace.getText(),Phost.getText(), Integer.parseInt(Pseat.getText()),Pname.getText() );
			ProgramGUI.getInstance().createPerformanceInformation();
			dialog.setVisible(false);

		}
		else if(o==cancel)
		{
			eventModifyPerformance(Pplace.getText(),Phost.getText(), Integer.parseInt(Pseat.getText()),Pname.getText() );
			ProgramGUI.getInstance().createPerformanceInformation();
			dialog.setVisible(false);
		}
		// TODO Auto-generated method stub
		
	}
	
}
