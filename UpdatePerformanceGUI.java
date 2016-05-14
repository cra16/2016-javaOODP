import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class UpdatePerformanceGUI extends JDialog implements ActionListener {
	private JDialog dialog = new JDialog();
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();
	
	JLabel pLabel = new JLabel("��� :");
	JLabel nLabel = new JLabel("�����̸� :");
	JLabel timeLabel =new JLabel("�ð� :");
	JLabel dateLabel = new JLabel("��¥ :");
	JLabel costLabel = new JLabel("���� : ");
	
	private JComboBox<String> performancePlace = new JComboBox<String>();
	private JComboBox<Integer> dayBox= new JComboBox<Integer>();
	private JComboBox<String>monthBox= new JComboBox<String>();
	private JComboBox<String>timeBox = new JComboBox<String>();
	private JTextField performanceName = new JTextField(10);
	
	private JTextField costTextfield = new JTextField(10);
	private JButton ok = new JButton("ok");
	private JButton cancel = new JButton("cancel");
	
	int currentIndex=0;
	
	String[] timestamp = {"15:00", "16:00", "17:00", "18:00","19:00","20:00","21:00","22:00"} ;
	int[] timedata = {150000,160000,170000,180000,190000,200000,210000,220000};
	String[] monthstamp = {"January","February","March","April","May","June","July","August","September","October","November","Desember"};
	int[] monthdata = {1,2,3,4,5,6,7,8,9,10,11,12};
	int[] daydata = new int[31];

	
	public UpdatePerformanceGUI(ArrayList<Product> performances){
		//���⵵ GUI�� ���λ��� �ϴ� �������س���
		Place place = new Place();//place��������̶�

		int placeindex =0;
		int dayindex=0;
		int monthindex=0;
		int timeindex=0;
		Product update_perform = performances.get(currentIndex);
		for(int i=0; i<31; i++)
		{
		
			daydata[i] = i+1;
		}
				
		for(int i=0; i<3; i++)
		{
			performancePlace.addItem(place.getPlaceName(i));
//			if(place.getPlaceName(i).equals(update_perform.getChooseProduct().getPlaceName()))//����̸��� �ߺ��ƴ϶�� ���������� �̷����� �Ƹ� �ٸ������ ������
//				placeindex=i;
		}
				
		for(int i=0; i<31; i++)
		{
			dayBox.addItem(daydata[i]);
//			if(daydata[i]==update_perform.getChooseProduct().getSchedule().getDate().getDate())
//				dayindex=i;
		}
		for(int i=0; i<12;i++)
		{
			monthBox.addItem(monthstamp[i]);
//			if(monthstamp[i].equals(String.valueOf(update_perform.getChooseProduct().getSchedule().getDate().getMonth()+1)))
//				monthindex=i;
				
		}
		for(int i=0; i<timestamp.length; i++)
		{
			timeBox.addItem(timestamp[i]);
//			if(timestamp[i].equals(update_perform.getChooseProduct().getSchedule().getTime().getHours()+":"+update_perform.getChooseProduct().getSchedule().getTime().getMinutes()))
//				timeindex= i;
		}
		performancePlace.setSelectedIndex(placeindex);
		dayBox.setSelectedIndex(dayindex);
		monthBox.setSelectedIndex(monthindex);
		timeBox.setSelectedIndex(timeindex);
		
		panel.add(pLabel);
		panel.add(performancePlace);
		panel2.add(nLabel);
		panel2.add(performanceName);
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		this.setSize(500,400);
		panel3.add(dateLabel);
		panel3.add(monthBox);
		panel3.add(dayBox);
		
		panel4.add(timeLabel);
		panel4.add(timeBox);
		panel4.add(costLabel);
		panel4.add(costTextfield);
		
		panel5.add(ok);
		panel5.add(cancel);
		this.setLayout(new FlowLayout(FlowLayout.LEFT,10,15));
		this.add(panel);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if(o==ok)
		{
			UpdatePerformance update = new UpdatePerformance();
			System.out.println("GGG");
			update.eventUpdatePerformance(currentIndex,monthdata[monthBox.getSelectedIndex()],daydata[dayBox.getSelectedIndex()],timestamp[timeBox.getSelectedIndex()],Integer.parseInt(costTextfield.getText()),performancePlace.getSelectedIndex(),performanceName.getText());
//			ProgramGUI.getInstance().createPerformanceInformation();
			this.dispose();
			
		}
		else if(o==cancel)
		{
			System.out.println("cancel �۵�");
//			ProgramGUI.getInstance().createPerformanceInformation();
			this.dispose();
		}
	}
}
