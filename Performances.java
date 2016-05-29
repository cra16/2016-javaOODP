import java.util.ArrayList;

public class Performances implements Aggregate{
	private ArrayList<Performance> performs;
	private int last = 0;
	public Performances(){
		performs = new ArrayList<Performance>();
	}
	public Performance getPerformAt(int index){
		return performs.get(index);
	}
	public void setPerformAt(int index, Performance perform){
		performs.set(index, perform);
	}
	public void appendPerform(Performance perform){
		performs.add(perform);
		last++;
	}
	public void deletePerform(int index){
		performs.remove(index);
		last--;
	}
	public int getLength(){
		return last;
	}
	public Iterator iterator(){
		return new PerformsIterator(this);
	}
}
