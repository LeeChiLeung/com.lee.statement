package statement;

import java.io.File;
import java.io.IOException;
import java.util.TimerTask;

import javax.swing.JFileChooser;

/**
 * dosk
 * @author lee
 *
 */
public class TouchAction extends TimerTask{

	private String touchName;
	private static OpenFileDir op = new OpenFileDir();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//事件处理
		
	    switch (touchName) {
		case "读取excle":
			System.out.println("读取excle...");
			//调用打开文件夹命令选择文件
			OpenFileDir file = op.openAndSelectFile("选择财务车牌txt", JFileChooser.FILES_ONLY);
			if (file !=null) {
				 File[] list = file.getSelectedFiles();
				    for (int i = 0; i < list.length; i++) {
				    	try {
				    		System.out.println(list[i].getName());
							ExcelUtil.excelResolve(list[i]);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
			System.out.println("读取excle完成...");
			break;
        case "补贴费对比":
        	
        	if (ExcelUtil.map.size()!=0) {
        		new CompareUtils().compareExcel(ExcelUtil.map, touchName);
			}else
				System.out.println("请导入excel");
//        	File filehistory = op.openAndSelectFile("选择历史车牌txt", JFileChooser.FILES_ONLY);
//        	FileActionUtile.fileInput(filehistory);
        	//解析文件
			break;
        case "跟单手续费/机构手续费对比":
        
        	if (ExcelUtil.map.size()!=0) {
        		new CompareUtils().compareExcel(ExcelUtil.map, touchName);
			}else
				System.out.println("请导入excel");
//        	new CompareUtils().inputMap(FileActionUtile.map, touchName);
//        	File filehistory = op.openAndSelectFile("选择历史车牌txt", JFileChooser.FILES_ONLY);
//        	FileActionUtile.fileInput(filehistory);
        	//解析文件
			break;
        case "手续费/总公司手续费对比":
        	
        	if (ExcelUtil.map.size()!=0) {
        		new CompareUtils().compareExcel(ExcelUtil.map, touchName);
			}else
				System.out.println("请导入excel");
        	
//        	new CompareUtils().inputMap(FileActionUtile.map, touchName);
//        	File filehistory = op.openAndSelectFile("选择历史车牌txt", JFileChooser.FILES_ONLY);
//        	FileActionUtile.fileInput(filehistory);
        	//解析文件
			break;
        case "h-->f":
        	if (ExcelUtil.map.size()!=0) {
        		new CompareUtils().compareExcel(ExcelUtil.map, touchName);
			}else
				System.out.println("请导入excel");
			break;
        case "f-->h":
        	if (ExcelUtil.map.size()!=0) {
        		new CompareUtils().compareExcel(ExcelUtil.map, touchName);
			}else
				System.out.println("请导入excel");
			break;
        case "清空导入数据":
        	ExcelUtil.map.clear();
        	System.out.println("清除完成...");
			break;
        case "清空控制台":
        	//ExcelUtil.map.clear();
        	StatementMain.consoleTextArea.setText("");
        	System.out.println("清除完成...");
			break;
        case "退出":
        	System.out.println("退出");
        	System.exit(0);
			break;
		default:
			break;
		}	
		
		
	}
   public void setTouchName(String touchName) {
	this.touchName = touchName;
}
}
