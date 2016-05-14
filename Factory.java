import java.util.ArrayList;


public abstract class Factory {

	public final Product create(String performance)
	{
		Product p = createProduct(performance);

		return p;
		
		
	}
	
	protected abstract Product createProduct(String performance);
	
	
}
