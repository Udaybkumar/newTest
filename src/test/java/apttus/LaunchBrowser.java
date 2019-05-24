package apttus;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generics.BaseClass;
import pages.GmailPage;

public class LaunchBrowser extends BaseClass {

	GmailPage mailIDPage;
	SoftAssert asserts = new SoftAssert();
	@BeforeClass
	public void launcher()
	{
		launchBrowser();
		mailIDPage = new GmailPage();
	}
	@Test (priority = 1)
	public void gettitle()
	{
		String title = driver.getTitle();
		System.out.println(title);	
		
		asserts.assertEquals(title, "Gmail", "Expected and optained results are different");	
	}
	
	@Test (priority = 2)
	public void sendUserName() throws InterruptedException
	{
		mailIDPage.idFieldEntry();
		Thread.sleep(5000);
		String actual = mailIDPage.errorMessageID();
		asserts.assertEquals(actual, "Couldn't find your Google Account", "wrong UserID entered");
		asserts.assertAll();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}