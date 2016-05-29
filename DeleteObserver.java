import javax.swing.JDialog;
import javax.swing.JLabel;


public class DeleteObserver implements Observer{

	
	private Subject deleteControl;
	
	public DeleteObserver(Subject deleteControl)
	{
		this.deleteControl=deleteControl;
		
	   this.deleteControl.registerObserver(this);
	}

	@Override
	public void update(Performance Perform) {
		// TODO Auto-generated method stub
		int index = DBHelper.getInstance().getPerforms().indexOf(Perform);
		DBHelper.getInstance().getHost().getPerformanceList().remove(index);
		JDialog a=new JDialog();
		a.add(new JLabel("입력이 완료 되었습니다."));
		a.setSize(300,300);
		a.setVisible(true);
	}

	@Override
	public void update(Performance Perform, Performance previous) {
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

}
