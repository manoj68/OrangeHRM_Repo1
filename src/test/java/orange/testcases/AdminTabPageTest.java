package orange.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import orange.base.TestBase;
import orange.pages.AdminTabPage;
import orange.pages.HomePage;
import orange.pages.LoginPage;
import orange.utility.TestUtil;

public class AdminTabPageTest extends TestBase 
{
	LoginPage loginpage;
	HomePage homepage;
	AdminTabPage admintabpage;
	TestUtil testUtil;
	
	public AdminTabPageTest()
	{
		super();	
		//Super keyword first come inside this class and then it will call super class constructor  
		//because we have to initialize properties also before the initialization method 
		//which created in TestBase (i.e.super class)
	}
	  
	@BeforeTest
	public void setup()
	{
		//As we have used properties objects in initialization method hence we have to call super keyword before
		initialization();	
		
		testUtil = new TestUtil();		//***this is required whne you are using util method (ex. switchFrame mthod)
		
		//to access loginpage functions and methods we created object of that class. Here class obj ref declared it globally
		loginpage =new LoginPage();	
		
		//To reach at homepage first we need to login hence we are using this
		//And we are getting login detail from properties files
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1, enabled=true)
	public void clickAdminTab() 
	{
		//as we have declared class object globally but we haven't initialized the object hence we are doing that now 	 
		admintabpage= new AdminTabPage(); 
		//to perform following click action the above initialization is mandatory
		admintabpage.clickOnAdminBtn();	
	}
	
	@Test(priority=2)
	public void userCountTest()
	{
		//as we have declared class object globally but we haven't initialized the object hence we are doing that now 
		admintabpage= new AdminTabPage(); 
		admintabpage.clickOnAdminBtn();
		admintabpage.clickUserMgmntBtn();
		List<WebElement> users = admintabpage.clickOnAllUser_resultTable();
		int usercount = users.size();
		System.out.println("Total number of users are : "+usercount);		
	}
	
	@Test(priority=3)
	public void userSearchFilterTest()
	{
		admintabpage = new AdminTabPage();
		admintabpage.clickOnAdminBtn();
		admintabpage.clickUserMgmntBtn();
		
		Select s = new Select (admintabpage.userRoleDropDown());
		s.selectByValue("1");

		admintabpage.clickSearchBtn();
	}
	
	@Test(priority=4)
	public void addBtnEnabledTest()
	{
		admintabpage = new AdminTabPage();
		admintabpage.clickOnAdminBtn();
		admintabpage.clickAddBtn();
		Boolean obj = admintabpage.isDisplayedSaveBtn();
		System.out.println("####Is displated result : " +obj);
	}
	
	//this code is added from different blog and not part of Naveen's framework 
	@AfterMethod
	public void takeScreenshot()
	{
		System.out.println("#####check screenshot after method result");
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();	
	}


}
