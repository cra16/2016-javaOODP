import java.util.ArrayList;


public abstract class Factory {

	public final Product create(Performance performance)
	{
		Product p = createProduct(performance);

		return p;
		
		
	}
	
	protected abstract Product createProduct(Performance performance);
	
	
}
