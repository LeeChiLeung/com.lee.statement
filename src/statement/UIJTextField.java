package statement;

import java.awt.Color;

import javax.swing.JTextField;

public class UIJTextField extends JTextField{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UIJTextField(String text,Color fg,int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);;
       this.setText(text);
       this.setEditable(false);
       this.setBorder(null);
       this.setForeground(fg);
       this.setOpaque(false);
	}
}
