package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.BaseClass;

public class GmailPage extends BaseClass{

	@FindBy(xpath = "//input[@type='email']") WebElement idField;
	@FindBy(xpath = "//div[@class='GQ8Pzc']") WebElement errorMessage;
	
	public GmailPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void idFieldEntry()
	{
		idField.sendKeys("uday",Keys.RETURN);
	}
	
	public String errorMessageID()
	{
		String error = "";
		try {
			error = errorMessage.getText();
			}
		catch(NoSuchElementException e)
		{
			System.out.println("No element");
			error ="Couldn't find your Google Account";
		}
		return error;
	}
}
