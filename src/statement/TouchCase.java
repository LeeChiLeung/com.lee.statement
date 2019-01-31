package statement;

import java.awt.event.MouseAdapter;

import javax.swing.JButton;
//单击事件封装
public class TouchCase extends JButton {

	public TouchCase() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param x 坐标
	 * @param y 坐标
	 * @param w 宽
	 * @param h 高
	 * @param title 按钮名称
	 * @param m 鼠标单击事件
	 */
	public TouchCase(int x,int y,int w,int h,String title,MouseAdapter m) {
		setBounds(x, y, w, h);
		setText(title);
		addMouseListener(m);
		//setContentAreaFilled(false);
	}
}
