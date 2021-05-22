package orange.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import orange.base.TestBase;
import orange.pages.AdminTabPage;
import orange.pages.HomePage;
import orange.pages.LoginPage;		//import shortcut ctrl+shift+ o button

public class LoginPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	AdminTabPage admintabpage;
	
	public LoginPageTest()
	{
		super();	
//Super keyword first come inside this class and then it will call super class constructor 
//because we have to initialize properties also before the initialization method 
//which created in TestBase (i.e.super class) 
//(Note: TestBase class we have created constructor)
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();	
		//As we have used properties objects in initialization method hence we have to call super keyword before
		
		loginpage =new LoginPage();		
		//to access loginpage functions and methods we created object of that class. Here class obj ref declared it globally
	}
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Successfuly logged in with valid credentials");
		//homepage varible is denoting homepage class reference. 
		//And here login method is returning you the object of homepage class. so we can store this in homepage reference.
		//Also the "login" method which we used here is returning new homepage (check login page code) 
	}
	@Test(priority=3)
	public void logintest_invalid()
	{
		loginpage.login(prop.getProperty("username_invalid"), prop.getProperty("password_invalid"));
		System.out.println("NOT logged in with valid credentials");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
