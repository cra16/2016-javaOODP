/*import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ReserveDialog implements ActionListener{
	JButton confirm = new JButton("Ȯ��");
	JButton ok = new JButton("Ȯ��");
	JButton cancel = new JButton("���");
	JDialog buyTicket;
	Seat seat;
	
	public ReserveDialog(Seat seat){
		this.seat = seat;
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		confirm.addActionListener(this);
		
		buyTicket = new JDialog(ProgramGUI.getJFrame(),"A",true);
		
		buyTicket.setSize(180, 100);
		buyTicket.setLayout(new FlowLayout());
	
		if(!seat.isReserved()){
			buyTicket.add(new JLabel("�����Ͻðڽ��ϱ�?",JLabel.CENTER));
			buyTicket.add(confirm);
			buyTicket.add(cancel);
		}else{
			buyTicket.add(new JLabel("�̹� ����� �¼��Դϴ�.",JLabel.CENTER));
			buyTicket.add(ok);
		}
		
		buyTicket.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok || e.getSource() == cancel){
			buyTicket.dispose();
		}else if(e.getSource() == confirm){
			seat.reserve();
			buyTicket.dispose();
		}
	}
}*/