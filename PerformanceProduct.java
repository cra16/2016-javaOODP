
public class PerformanceProduct extends Product {

	String performance;
	
	public PerformanceProduct(String performance) {
		this.performance=performance;
	}

	@Override
	public String getChooseProduct() {
		return performance;
		
	}
}
