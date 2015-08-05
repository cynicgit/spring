package ip.ssm.stringutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	@SuppressWarnings("resource")
	public static List<Map<String,Object>> excleReadXlsx(List<String> list,InputStream in){
		Map<String,Object> map = null;
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		try {
			//创建Excel，读取文件内容
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			
			//获取第一个工作表workbook.getSheet("Sheet0");
			//HSSFSheet sheet = workbook.getSheet("Sheet0");
			//读取默认第一个工作表sheet
			XSSFSheet sheet = workbook.getSheetAt(0);
			int firstRowNum = 1;//从第二行开始读数据
			//获取sheet中最后一行行号
			int lastRowNum = sheet.getLastRowNum();
			for (int i = firstRowNum; i <=lastRowNum; i++) {
				map = new HashMap<String,Object>();
				XSSFRow row = sheet.getRow(i);
				//获取当前行最后单元格列号
				int lastCellNum = row.getLastCellNum();
				if(list.size()<lastCellNum)
					lastCellNum = list.size();
				for (int j = 0; j < lastCellNum; j++) {
					XSSFCell cell = row.getCell(j);
					Object s = getCellValue(cell);
						map.put(list.get(j), s) ;
				}
				listMap.add(map);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listMap;
	}
	
	@SuppressWarnings("resource")
	public static List<Map<String,Object>> excleReadXls(List<String> list,InputStream in){
		Map<String,Object> map = null;
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		try {
			//创建Excel，读取文件内容
			HSSFWorkbook workbook = new HSSFWorkbook(in);
			
			//获取第一个工作表workbook.getSheet("Sheet0");
			//HSSFSheet sheet = workbook.getSheet("Sheet0");
			//读取默认第一个工作表sheet
			HSSFSheet sheet = workbook.getSheetAt(0);
			int firstRowNum = 1;//从第二行开始读数据
			//获取sheet中最后一行行号
			int lastRowNum = sheet.getLastRowNum();
			for (int i = firstRowNum; i <=lastRowNum; i++) {
				map = new HashMap<String,Object>();
				HSSFRow row = sheet.getRow(i);
				//获取当前行最后单元格列号
				int lastCellNum = row.getLastCellNum();
				if(list.size()<lastCellNum)
					lastCellNum = list.size();
				for (int j = 0; j < lastCellNum; j++) {
					HSSFCell cell = row.getCell(j);
					Object s = getCellValue(cell);
						map.put(list.get(j), s) ;
				}
				listMap.add(map);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listMap;
	}
	
	private static Object getCellValue(Cell cell){  
	    Object value = null; 
	    int cellType = 6;
	    if(cell!=null)
	        cellType = cell.getCellType();  
	    switch(cellType){  
	    case XSSFCell.CELL_TYPE_BLANK:  
	    	
	        break;  
	    case XSSFCell.CELL_TYPE_BOOLEAN:  
	        value = cell.getBooleanCellValue();  
	        break;  
	    case XSSFCell.CELL_TYPE_ERROR:  
	        value = cell.getErrorCellValue();  
	        break;  
	    case XSSFCell.CELL_TYPE_FORMULA:  
	        value = cell.getCellFormula();  
	        break;  
	    case XSSFCell.CELL_TYPE_NUMERIC:  
	        value = cell.getNumericCellValue();  
	        break;  
	    case XSSFCell.CELL_TYPE_STRING:  
	        value = cell.getStringCellValue(); 
	        break;
	    case 6:  
	        value = null; 
	        break;  
	    }  
	    return value;  
	}  
	
	
	
	
}
