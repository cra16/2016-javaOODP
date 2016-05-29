import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public abstract class PageView extends JFrame{
	public abstract JPanel getJPanel();
	public abstract void draw();
}
