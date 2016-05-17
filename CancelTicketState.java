import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

public interface CancelTicketState {
	public abstract CancelTicketState checkDay(Date date);
	public abstract void makeCancelBtn(JPanel orderpanel, JButton[] cancelBtn, int index, int size);
}
