package statement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

public class FileActionUtile {

	public static Map<String,List<String>> map = new HashMap<>();
	
	public static void  fileInput(File file) {
		InputStream inFile =null;
	   try {
		inFile = new FileInputStream (file);
//		byte [] b = new byte[inFile.available()];
//		int l = 0;
	String str = "";
//		if((l=inFile.read(b)) >0) {
//			str = new String (b,0,l);
//		}
//		System.out.println(str);
		DefaultStyledDocument dc = new DefaultStyledDocument();
		new RTFEditorKit().read(inFile, dc, 0);
		str=new String(dc.getText(0, dc.getLength()).getBytes("ISO8859-1"), "GBK");
		map.put(file.getName(), Arrays.asList(str.split("\n")));
		System.out.println(map.size());
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (BadLocationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			inFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
