import java.util.ArrayList;


public class DeletePerformController implements Subject {

	
	private ArrayList<Observer> observer=new ArrayList<Observer>();
	private Performance p=null;
	
	
	DeletePerformController()
	{
		new DeleteObserver(this);
	}
	public void eventDelete(Product perform, int index)
	{
		boolean a =DBHelper.getInstance().deletePerformance(perform);
		p=perform.getPerformance();
		this.notifyObservers(a);
	}
	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifyObservers(boolean bool) {
		// TODO Auto-generated method stub
		Observer temp;
		for(int i=0; i<observer.size();i++)
		{
			temp = observer.get(i);
			if(bool==true)
				temp.update(p);
			else
				temp.fail();
		}
	}


}
