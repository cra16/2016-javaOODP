import java.util.ArrayList;


public class CareMemento {

	private ArrayList<Memento> savedList = new ArrayList<Memento>();
	
	
	public void addAddMemento(Memento m)
	{
		savedList.add(m);
	}
	public void getAddMemento(int index)
	{
		savedList.get(index);
	}
	public void deleteAddMemento()
	{
		savedList.remove(savedList.size()-1);
	}
	public Memento getLastMemento()
	{
		return  savedList.get(savedList.size()-1);
	}
}
