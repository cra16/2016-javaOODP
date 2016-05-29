import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;


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
		// TODO Auto-generated method stub
		DBHelper.getInstance().getHost().getPerformanceList().add(perform.getName());
		DBHelper.getInstance().getPerforms().appendPerform(perform);
		JDialog a=new JDialog();
		a.add(new JLabel("입력이 완료 되었습니다."));
		a.setSize(300,300);
		a.setVisible(true);
		a.addWindowListener(new WindowAdapter()
		{
			 public void windowClosing(WindowEvent e)
			  {
				 if(DBHelper.getInstance().getHost() !=null)
	                {
	                	 newhost =new HomeView_host();
	                }
	                else if(DBHelper.getInstance().getAudience()!=null)
	                {
	                	 newaudience = new HomeView_audience();
	                }
			  }
		}
		);
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
		
	}

}
