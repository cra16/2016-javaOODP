import java.util.ArrayList;


public class PerformanceFactory extends Factory {



	@Override
	protected Product createProduct(String performance) {
		// TODO Auto-generated method stub
		return new PerformanceProduct(performance);
	}



	



}
