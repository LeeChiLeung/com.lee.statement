package statement;

import javax.swing.JFrame;
//主要的窗口类
public class DosktopPojo extends JFrame {

	
	public DosktopPojo() {
		// TODO Auto-generated constructor stub
	}
	
	public DosktopPojo(int x,int y,int w,int h,String title) {
		// TODO Auto-generated constructor stub
		setTitle(title);
		setLocation(x, y);
		setSize(w, h);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);//固定缩放
	}
	
}
