import java.util.ArrayList;


public class Memento {
	
	private PageView savedView;
	
	Memento(PageView input)
	{
		this.savedView = input;
	}
	
	public PageView getView()
	{
		return this.savedView;
	}
	
	public void setView(PageView input)
	{
		this.savedView = input;
	}
	
	
	
}
