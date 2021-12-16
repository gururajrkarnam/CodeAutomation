package tests;

import com.excel.lib.util.*;

public class ExcelUtilTest {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("./src/main/java/com/excel/lib/util/SampleExcel.xlsx");
		String sheetName = "login";
		
		String data = reader.getCellData(sheetName, 0, 3);
		System.out.println(data);
		
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("total row count:" +rowCount);
		
	
		reader.setCellData(sheetName, "status", 3, "FAIL");

		
		if(!reader.isSheetExist("Registartion")){
			reader.addSheet("Registration");
		}
	}
	
}
