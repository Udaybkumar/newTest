package generics;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	public static WebDriver driver;
	public String browser()
	{
		return "Chrome";
	}
	
	public WebDriver initiateDriver()
	{
		if(browser().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser().equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./resource/IEdriver.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
	
	public void launchBrowser()
	{
		initiateDriver().get("https://www.gmail.com/");
	}
}
