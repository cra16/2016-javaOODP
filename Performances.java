
public class Performances implements Aggregate{
	private Performance[] performs;
	private int last = 0;
	public Performances(int maxsize){
		this.performs = new Performance[maxsize];
	}
	public Performance getPerformAt(int index){
		return performs[index];
	}
	public void setPerformAt(int index, Performance perform){
		performs[index] = perform;
	}
	public void appendPerform(Performance perform){
		this.performs[last] = perform;
		last++;
	}
	public int getLength(){
		return last;
	}
	public Iterator iterator(){
		return new PerformsIterator(this);
	}
}
