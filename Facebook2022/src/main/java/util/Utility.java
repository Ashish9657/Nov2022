package util;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String screenshot(WebDriver driver,String testID) throws IOException
	{
		Date date = new Date();
		String dateTime=date.toString().replace(":","_")+".jpg";
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File ("E:\\Dest\\Test"+testID+dateTime+".jpg");
		FileHandler.copy(source, dest);
		return testID;
	}
	
	public static String getDataFromExcel(String sheet,int row,int cell) throws IOException, EncryptedDocumentException {
		
		 String data ;
		
		String path="E:\\Manual testing\\Test case formate.xlsx";
		FileInputStream file=new FileInputStream(path);
					
		Workbook value = WorkbookFactory.create(file);
	    	
		try
		{
	     data = value.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		}
		catch(IllegalStateException e)
		{
			double data1=value.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
			long a;
			a=(long)data1;
			
			String s=String.valueOf(a);
			
			return s;
		}
		return data;
		}
	
}
		
		
		
	
	


