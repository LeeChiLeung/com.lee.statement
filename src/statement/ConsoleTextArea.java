package statement;

import java.awt.Font;

import javax.swing.JTextArea;

public class ConsoleTextArea extends JTextArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ConsoleTextArea() {
		super(null, null, 3, 1);
		this.setLineWrap(true); 
		this.setEditable(false);
		this.setFont( new Font("微软雅黑",0,16));
	}
	

}
