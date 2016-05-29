import java.awt.Color;

import javax.swing.JPanel;


public class GreenBackgroundDecorator extends BackgroundDecorator {

	public GreenBackgroundDecorator(PageView page) {
		super(page);
		draw();
	}

	@Override
	public JPanel getJPanel() {
		// TODO Auto-generated method stub
		return this.page.getJPanel();
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		JPanel panel = getJPanel();
		panel.setBackground(Color.GREEN);
	}
}
