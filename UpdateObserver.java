import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class UpdateObserver implements Observer {

	private Subject updateControl;
	HomeView_host newhost;
    HomeView_audience newaudience;
	public UpdateObserver(Subject updateObserver)
	{
		this.updateControl=updateObserver;
		
		updateControl.registerObserver(this);
	}
	@Override
	public void update(Performance Perform) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fail() {
		// TODO Auto-generated method stub
		JDialog a=new JDialog();
		a.add(new JLabel("입력이 실패되었습니다.."));
		a.setSize(300,300);
		a.setVisible(true);
	}
	@Override
	public void update(Performance Perform, Performance previous) {
		// TODO Auto-generated method stub
		int index = 0;
		Iterator iterator = DBHelper.getInstance().getPerforms().iterator();
		while(iterator.hasNext()){
			Performance perform = (Performance)iterator.next();
			if(previous.equals(perform))
				break;
			index++;
			
			
		}
		
		DBHelper.getInstance().getPerforms().setPerformAt(index, Perform);
		DBHelper.getInstance().getHost().getPerformanceList().set(index, Perform.getName());
		JDialog a=new JDialog();
		JOptionPane.showMessageDialog(a, "입력 완료");
		
	}

}
