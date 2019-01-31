package statement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.rowset.internal.Row;

/**
 * 解析excel
 * @author lee
 *
 */
public class ExcelUtil {

	public static Map<String,List<ExcelResolveModel>> map = new HashedMap<>();
	
	@SuppressWarnings("resource")
	public static void excelResolve(File file) throws IOException {
		String key = file.getName();
		if (file.getName().contains("基础数据")) {
			key = "财务数据";
		}
		if (file.getName().contains("历史保单")) {
			key = "历史保单";
		}
		
		Workbook wb = null;
		org.apache.poi.ss.usermodel.Sheet sheet = null;
		int maxRows = 0;//最大行数
		int maxColnum =0;//最大列数
		org.apache.poi.ss.usermodel.Row row = null;
	
		//读取excel
		
		FileInputStream fileStream = new FileInputStream(file);
		
		wb = new XSSFWorkbook(fileStream);//解析 xlsx
		
		sheet=wb.getSheetAt(0);//读取第一个sheet
		
		maxRows = sheet.getPhysicalNumberOfRows();
		//通过读取第一行 获取列数
		row=sheet.getRow(0);
		maxColnum = row.getPhysicalNumberOfCells();
		
		//通过遍历行数 再遍历固定列数获取数据
		
		//分历史表和财务表 两excel读取的列数不一
	    List<ExcelResolveModel> list = new ArrayList<>();
		for (int i = 1 ; i < maxRows; i++) {
			
			row=sheet.getRow(i);
			if (row !=null) {
				if (file.getName().contains("基础数据")) {
					ExcelResolveModel ex = inputFile(row, 2,11,13,23,25,17,21,14,24);
					ex.setExcelFileName(file.getName());
					list.add(ex);
				}
				if (file.getName().contains("历史保单")) {
					ExcelResolveModel ex = inputFile(row, 1,12,17,25,26,14,28,13,15);
					ex.setExcelFileName(file.getName());
					list.add(ex);
				}
			}
			
		}
	
		map.put(key, list);
		
	}
	
	private static ExcelResolveModel inputFile(org.apache.poi.ss.usermodel.Row row,int...nuber) {
		ExcelResolveModel ex = new ExcelResolveModel();
		   // System.out.println(Arrays.toString(nuber));
			ex.setLicensePlate(String.valueOf(row.getCell(nuber[0])));//车牌
            ex.setCompanyName(String.valueOf(row.getCell(nuber[1])));//	公司
		    ex.setDepartment(String.valueOf(row.getCell(nuber[2])));//部门
		    ex.setCompanyFee(getDouble(row.getCell(nuber[3])));//公司手续费 总公司手续费
		    ex.setSubsidy(getDouble(row.getCell(nuber[4])));//补贴费
		    ex.setInsurancePrice(getDouble(row.getCell(nuber[5])));//保费
		    ex.setMechanismSubsidyFee(getDouble(row.getCell(nuber[6])));//跟单手续费 机构手续费
		    ex.setInsuranceType(String.valueOf(row.getCell(nuber[7])));
		    ex.setSubsidyRate(getDouble(row.getCell(nuber[8])));
		   // ex.setDepartment(String.valueOf(row.getCell(7)));//所属部门
		    
		return ex;
		
	}
	
	private static Double getDouble(Cell cell) {
		String result = String.valueOf(cell) ;
		
		
		return cell==null || result ==null || "".equals(result) ?0d:Double.valueOf(String.valueOf(cell));
	}
}
