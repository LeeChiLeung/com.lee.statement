package statement;

import java.awt.Color;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;

/**
 * 账单筛选族类
 * @author lee
 *
 */
public class StatementMain {
    private static TouchPojo t = new TouchPojo();
    public static ConsoleTextArea consoleTextArea = new ConsoleTextArea();
    private static PrintOutStream pr = new PrintOutStream(consoleTextArea);
  
	public static void main(String[] args) {
		new StatementMain().start();
		System.setOut(new PrintStream(pr));
	}

	private void start() {
		
		DosktopPojo dosk = new DosktopPojo(500, 300, 800, 450, "对账");
		
		List<TouchCase> button = Arrays.asList(
		new TouchCase(30, 20, 200, 40, "读取excle", t),
		new TouchCase(30, 60, 100, 40, "f-->h", t),
		new TouchCase(130, 60, 100, 40, "h-->f", t),
		new TouchCase(30, 100, 200, 50, "补贴费对比", t),
		new TouchCase(30, 150, 200, 50, "跟单手续费/机构手续费对比", t),
		new TouchCase(30, 200, 200, 50, "手续费/总公司手续费对比", t),
	
		new TouchCase(30, 250, 200, 50, "清空导入数据", t),
		new TouchCase(30, 300, 200, 50, "清空控制台", t),
		new TouchCase(30, 350, 200, 50, "退出", t)
		);
		
		for (Iterator iterator = button.iterator(); iterator.hasNext();) {
			TouchCase touchCase = (TouchCase) iterator.next();
			dosk.add(touchCase);
		}
		consoleTextArea.append("对账控制台...\r\n");
		dosk.add(new UIJTextField("Design by Lee", Color.gray,700, 390, 200, 50));
		dosk.add(new ConsoleJScrollPane(consoleTextArea, 250, 20, 520, 380));
	}
}
