package statement;

import javax.swing.JScrollPane;

public class ConsoleJScrollPane extends JScrollPane  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ConsoleJScrollPane(ConsoleTextArea c,int x, int y, int width, int height) {
		super(c);
		this.setBounds(x, y, width, height);
	}
	
}
