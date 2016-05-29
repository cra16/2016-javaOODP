import java.awt.Color;

import javax.swing.JPanel;

public class OrangeBackgroundDecorator extends BackgroundDecorator {

	public OrangeBackgroundDecorator(PageView page) {
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
		panel.setBackground(Color.ORANGE);
	}
}
