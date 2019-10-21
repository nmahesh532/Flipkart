package abcpack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	XSSFWorkbook wb;
	XSSFSheet s;
	XSSFRow r;
	XSSFCell cell;
	
	ExcelUtils(String path,String sheetname) throws Exception
	{
		FileInputStream fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		s=wb.getSheet(sheetname);
	}
	public String getCellData(int rowindex,int colindex)
	{
		return s.getRow(rowindex).getCell(colindex).getStringCellValue();
	}
	
	public void setCellData(int rowindex,int colindex, String result,String path) throws Exception
	{
		cell=s.getRow(rowindex).getCell(colindex);
		if(cell==null)
		{
			cell=r.createCell(colindex);
			cell.setCellValue(result);
		}
		else
		{
			cell.setCellValue(result);
		}
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
	}
	

}
