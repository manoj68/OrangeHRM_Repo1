package orange.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import orange.base.TestBase;	//import shortcut ctrl+shift+ o button
import orange.pages.AdminTabPage;
import orange.pages.HomePage;
import orange.pages.LoginPage;

public class HomePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	AdminTabPage admintabpage;
	
	public HomePageTest()
	{
		super();	
		//Super keyword first come inside this class and then it will call super class constructor  
		//because we have to initialize properties also before the initialization method 
		//which created in TestBase (i.e.super class)
	}
	  
	@BeforeMethod
	public void setup()
	{
		//As we have used properties objects in initialization method hence we have to call super keyword before
		initialization();	
		
//**	testUtil = new TestUtil();		//this is required whne you are using util method (ex. switchFrame mthod)
		
		//to access loginpage functions and methods we created object of that class. Here class obj ref declared it globally
		loginpage =new LoginPage();	
		
		//To reach at homepage first we need to login hence we are using this
		//And we are getting login detail from properties files
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void HomePageTextTest()
	{
		String homePageTitle = homepage.verifyHomepageText();
	//	Assert.assertEquals(homePageTitle, "Welcome Paul", "**incorrect title found**");	//added error message in case if its failed
		assertTrue(homePageTitle.contains("Welcome"));
	}

	@Test(priority=2)	//(enabled = false) to skip
	public void PIMTabTest()
	{
		homepage.clickonPIMTab();
	}
	
	@Test(priority=3)
	public void MarketplaceTabTest()
	{
		homepage.clickMarketplace();
		String actualText = homepage.verifyMarketplaceText();
		String expectedText = "OrangeHRM Addons";
		Assert.assertEquals(actualText, expectedText, "lollllllll");
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
