import javax.swing.JPanel;

public abstract class BackgroundDecorator extends PageView{
	protected PageView page;
	protected BackgroundDecorator(PageView page){
		this.page = page;
	}
}
