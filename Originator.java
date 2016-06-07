
public class Originator {
	PageView view;
	
	public PageView getView()
	{
		return this.view;
	}
	
	public void setView(PageView view)
	{
		this.view= view;
	}
	
	public Memento createAddMemento()
	{
		return new Memento(view);
	}
	
	public void restoreAddMemento(Memento m)
	{
		this.view = m.getView();
	}
	
	

}
