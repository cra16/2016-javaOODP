
public class PerformsIterator implements Iterator{
	private Performances performs;
	private int index;
	
	public PerformsIterator(Performances performs){
		this.performs = performs;
		this.index = 0;
	}
	
	public boolean hasNext(){
		if(index < performs.getLength()){
			return true;
		}else
			return false;
	}
	
	public Object next(){
		Performance perform = performs.getPerformAt(index);
		index++;
		return perform;
	}
}
