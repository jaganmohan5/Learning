package learnData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class LearnExcel {

	public FileInputStream inputStream;
	public static XSSFWorkbook wBook = null;
	public static XSSFSheet wSheet = null;
	public static XSSFCell cell = null;
	public static XSSFRow row = null;
	public String sheetName = "Sheet1", fileName = "Input";

	public String[][] readExcel(String fileName, String sheetName) throws IOException {

		String[][] data = null;
		File file = new File("./data/Input.xlsx");
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		wBook = new XSSFWorkbook(inputStream);
		wSheet = wBook.getSheet(sheetName);

		int rowCount = wSheet.getLastRowNum();
		row = wSheet.getRow(0);
		int colCount = row.getLastCellNum();
		data = new String[rowCount][colCount];
		for(int i = 1; i<=rowCount; i++) {
			row = wSheet.getRow(i);
			for(int j = 0; j<colCount; j++) {
				cell = row.getCell(j);
				String value = cell.getStringCellValue();
				data[i-1][j] = value;
				System.out.print(data[i-1][j]+" ");
			}
			System.out.println();
		}
		return data;
		
	}

	@Test(dataProvider = "Input")
	public void main(String fName, String lName) throws IOException {

		System.out.println(fName+" "+lName);
		
	}
	
	@DataProvider(name = "Input")
	public String[][] getData() throws IOException{
		
		return new LearnExcel().readExcel(fileName, sheetName);
	}

	@SuppressWarnings("resource")
	public void writeExcel() throws IOException {
		int i = 0;
		File file = new File("./data/Input.xlsx");
		FileInputStream inp = new FileInputStream(file);
		XSSFWorkbook wBook = new XSSFWorkbook(inp);
		wSheet = wBook.createSheet("New");
		row = wSheet.createRow(wSheet.getLastRowNum()+1);
		String[][] data = this.getData();
		for (String[] s : data) {
			cell = row.createCell(i++);	
		}
		
	}
	
}
