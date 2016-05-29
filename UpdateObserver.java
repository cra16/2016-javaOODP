import javax.swing.JDialog;
import javax.swing.JLabel;


public class UpdateObserver implements Observer {

	private Subject updateControl;
	
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
		while(DBHelper.getInstance().getPerforms().iterator().hasNext()){
			if(previous == (Performance)DBHelper.getInstance().getPerforms().iterator().next())
				break;
			index++;
		}
		DBHelper.getInstance().getPerforms().setPerformAt(index, Perform);
		DBHelper.getInstance().getHost().getPerformanceList().set(index, Perform.getName());
		JDialog a=new JDialog();
		System.out.println("입력 완료");
		a.add(new JLabel("입력이 완료 되었습니다."));
		a.setSize(300,300);
		a.setVisible(true);
	}

}
