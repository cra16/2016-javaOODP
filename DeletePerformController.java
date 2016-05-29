import java.util.ArrayList;


public class DeletePerformController implements Subject {

	
	private ArrayList<Observer> observer=new ArrayList<Observer>();
	private Performance p=null;
	
	
	DeletePerformController()
	{
		new DeleteObserver(this);
	}
	public void eventDelete(Performance perform, int index)
	{
		boolean a = DBHelper.getInstance().deletePerformance(perform);
		p = perform;
		this.notifyObservers(a);
	}
	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observer.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		int i=observer.size();
		if(i>=0)
		observer.remove(o);
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
