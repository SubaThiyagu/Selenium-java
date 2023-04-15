package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public String[][] excelRead() throws IOException
	{
	FileInputStream fis=new FileInputStream("C:\\Users\\subas\\OneDrive\\Desktop\\TestData.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet=wb.getSheet("Sheet1");
	int rowcount=sheet.getPhysicalNumberOfRows();
	XSSFRow row=sheet.getRow(0);
	int cellCount=row.getPhysicalNumberOfCells();
	String[][] data=new String[rowcount-1][cellCount-1];
	String value=null;
	XSSFCell cell;
	for(int i=1;i<rowcount;i++)
	{
		for(int j=1;j<cellCount;j++)
		{
			cell=sheet.getRow(i).getCell(j);
			if(cell.getCellType()==CellType.STRING)
			{
				value=cell.getStringCellValue();
			}
			if(cell.getCellType()== CellType.NUMERIC)
			{
				double CellValue=cell.getNumericCellValue();
				value=NumberToTextConverter.toText(CellValue);
			}
			data[i-1][j-1]=value;
		
		}
		
	}
	
	return data;
	
	}	
	

}
