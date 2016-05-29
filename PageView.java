import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public abstract class PageView extends JFrame{
	protected static PageView page=null;
	protected static JPanel add1panel = null;
	PageView()
	{	
			if(page==null)
			{
				page=this;
				add1panel=new JPanel();
			}
			page.setBounds(0,0,350,600);
	        page.setLayout( null);
	 
	       
	        page.setVisible(true);
	}
	
	
	abstract public void draw();
}
