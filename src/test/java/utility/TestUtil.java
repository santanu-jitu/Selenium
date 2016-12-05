package utility;

import base.Page;
import base.TestBase;

public class TestUtil extends TestBase {
	
	
	
	public static Object[][] getData(String sheetName){
		
			
		int rows = Page.excel.getRowCount(sheetName);
		int cols = Page.excel.getColumnCount(sheetName);
		
		System.out.println("total rows are : "+rows);
		System.out.println("total cols are : "+cols);
		
		Object[][] data = new Object[rows-1][cols];
		
		
		for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ //2
			
			for(int colNum=0 ; colNum< cols; colNum++){
				
				
				data[rowNum-2][colNum]=Page.excel.getCellData(sheetName, colNum, rowNum); //-2
			}
		}
		
		
		return data;
		
		
		
		
	}


}
