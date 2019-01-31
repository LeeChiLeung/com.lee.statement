package statement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
/***
 * 单击事件转发类
 * @author lee
 *
 */
public class TouchPojo extends MouseAdapter {
	private static TouchAction t = new TouchAction();
    /**
     * 获取鼠标事件
     */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		JButton button = (JButton) e.getSource();
		t.setTouchName(button.getText());
		t.run();
	}
}
