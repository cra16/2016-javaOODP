
public class PerformanceProduct extends Product {

	Performance performance;
	
	public PerformanceProduct(Performance performance) {
		this.performance=performance;
	}

	@Override
	public Performance getChooseProduct() {
		return performance;
		
	}
}
