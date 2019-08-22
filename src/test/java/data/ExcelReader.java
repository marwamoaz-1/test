package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static FileInputStream fis=null;
	public FileInputStream getFileInputStream() throws FileNotFoundException
	{
		String fPath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.xlsx";
		File srcFile=new File(fPath);
		fis=new FileInputStream(srcFile);
		return fis;
		
	}
	
	public Object [][] getExcelData() throws IOException
	{
		fis=getFileInputStream();
		XSSFWorkbook wb=new  XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheetAt(0);
		
		int rows=ws.getLastRowNum()+1;
		int col=4;
		
		String [][] arrayExcelData=new String[rows][col];
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<col;j++)
			{
				XSSFRow row=ws.getRow(i);
				arrayExcelData[i][j]=row.getCell(j).toString();
			}
		}
		
		wb.close();
		return arrayExcelData;
		
	}

}
