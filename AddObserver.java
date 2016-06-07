import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class AddObserver implements Observer {

	
	private Subject addControl;
	HomeView_host newhost;
    HomeView_audience newaudience;
    
	public AddObserver(Subject addControl)
	{
		this.addControl=addControl;
		
	   this.addControl.registerObserver(this);
	}
	@Override
	public void update(Performance perform) {
		DBHelper.getInstance().getHost().getPerformanceList().add(perform.getName());
		DBHelper.getInstance().getPerforms().appendPerform(perform);
		JDialog a=new JDialog();
		JOptionPane.showMessageDialog(a, "입력 완료");

	}
	@Override
	public void fail() {
		JDialog a=new JDialog();
		a.add(new JLabel("입력이 실패되었습니다.."));
		a.setSize(300,300);
		a.setVisible(true);

	}
	@Override
	public void update(Performance Perform, Performance previous) {}
}
