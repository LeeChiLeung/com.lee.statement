package statement;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
/**
 * 控制台输出重定向到 桌面文本框
 * @author lee
 *
 */
public class PrintOutStream extends OutputStream {
	private  JTextArea destination;
	
	public PrintOutStream(JTextArea destination) {
		this.destination = destination;
	}
	
	
	
	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
		write(new byte[] {(byte)b},0,1);
	    
	}
	@Override
	public void write(byte[] bytes,int offset,int length) {
		final String text = new String(bytes, offset, length);
		SwingUtilities.invokeLater(()->{destination.append(text);});
	}


	
       
	

}
