import java.awt.Color;


public class BlueAddPerformDecorator extends AddPerformDecorator {

	public BlueAddPerformDecorator(PageView page) {
		super(page);
		draw();
		// TODO Auto-generated constructor stub
	}
	public void draw()
	{
		
		 add1panel.setBackground(Color.BLUE);
		 add1panel.revalidate();
	      

	}
}
