import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {
	public static Object[][] data;
	// public static Xls_Reader excel=null;
	public static Workbook book;
	public static Sheet sheet;
	public static FileInputStream file;
	public static Object[][] readData(String sheetName) {

		try {
			file = new FileInputStream("C:\\Users\\Srinivas goud\\Downloads\\hstestdata.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * if (excel == null) { excel = new
		 * Xls_Reader("C:\\Users\\Srinivas goud\\Downloads\\hstestdata.xlsx"); }
		 * int rows = excel.getRowCount(sheetName);
		 *  int cols = excel.getColumnCount(sheetName);
		 * data = new Object[rows - 1][1];
		 * Hashtable<String, String> table = null;
		 * 
		 * for (int rowNum = 2; rowNum <= rows; rowNum++) {
		 * table=new Hashtable<String, String>();
		 * for (int colNum = 0; colNum < cols; colNum++) {
		 * data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
		 * table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
		 * data[rowNum-2][0] = table;
		 */
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		data = new Object[rows][cols];
		
		for (int rowNum = 0; rowNum < rows; rowNum++) {
			
			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum][colNum] = sheet.getRow(rowNum+1).getCell(colNum).toString();
				
			}
		}
		return data;

	}
}