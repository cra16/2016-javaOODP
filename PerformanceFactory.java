import java.util.ArrayList;


public class PerformanceFactory extends Factory {
	private ArrayList<Product> performs = new ArrayList<Product>();
	
	@Override
	protected Product createProduct(Performance perform) {
		return perform;
	}

	@Override
	protected void registerProduct(Product product) {
		performs.add(product);
	}

	public ArrayList<Product> getPerforms(){
		return performs;
	}
}
