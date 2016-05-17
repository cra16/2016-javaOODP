import java.util.ArrayList;


public abstract class Factory {

	public final Product create(Performance perform)
	{
		Product p = createProduct(perform);
		registerProduct(p);
		return p;
	}
	
	protected abstract Product createProduct(Performance perform);
	protected abstract void registerProduct(Product product);
}
