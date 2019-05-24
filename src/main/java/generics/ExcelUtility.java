package generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {

	public static String getCellData(String sheetname, int rowno, int cellno) throws IOException
	{

	File src= new File( ".resource\testData.xlsx");
	FileInputStream file=new FileInputStream(src);
	XSSFWorkbook work=new XSSFWorkbook(file);
	XSSFSheet sheet1=work.getSheet(sheetname);
	XSSFRow row=sheet1.getRow(rowno);
	XSSFCell cell=row.getCell(cellno);
	String data=cell.getStringCellValue();
	String c = data.toString();
	if (c != null && c.toString().length() > 0 )
	{
		data = c.toString();
	}
else
{
	data = "  ";
}
	
	System.out.println(" Data from excel " +data);
	return data;
	}

public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
    //below line is just to append the date format with the screenshot name to avoid duplicate names		
    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
TakesScreenshot ts = (TakesScreenshot) driver;
File source = ts.getScreenshotAs(OutputType.FILE);
    //after execution, you could see a folder "FailedTestsScreenshots" under src folder
String destination = System.getProperty("user.dir") + "\\screenshots\\"+screenshotName+".png";
File finalDestination = new File(destination);
FileUtils.copyFile(source, finalDestination);
    //Returns the captured file path
return destination;
}

}