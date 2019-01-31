package statement;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class OpenFileDir extends JFileChooser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OpenFileDir openAndSelectFile(String title,int jf) {
		FileSystemView fv = FileSystemView.getFileSystemView();
		this.setCurrentDirectory(fv.getHomeDirectory());
		this.setDialogTitle(title);
		this.setApproveButtonText("确认");
		this.setFileSelectionMode(jf);//打开文件的类型
		this.setMultiSelectionEnabled(true);//多选
		
		int result = showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			return this;
		}
		return null;
		
	}
	
}
