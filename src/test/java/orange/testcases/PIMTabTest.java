package orange.testcases;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import orange.base.TestBase;
import orange.pages.AdminTabPage;
import orange.pages.HomePage;
import orange.pages.LoginPage;
import orange.pages.PIMTab;
import orange.utility.TestUtil;

public class PIMTabTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	AdminTabPage admintabpage;
	PIMTab pim;
	
	String sheetName = "Sheet2";
	
	public PIMTabTest()
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
	
		pim = new PIMTab(driver);	//
	}
	
//	@Test(priority=1)
	public void employeeSearchTest()
	{
		homepage.clickonPIMTab();
	
		pim.clickOnEmpList();
		Select obj = new Select(pim.clickOnEmpStatus());
		obj.selectByValue("3");
		pim.clickSearchButton();	
	}

	//using excel file and utility methods, we are creating this data provider
	@DataProvider(name="EmpExcelData")
	public Object[][] getEmployeeData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);	//sheetname declared globally in this class
		return data;
	}
	
	@Test(priority=2, dataProvider="EmpExcelData")
	public void addNewEmployeeTest(String firstname, String middlename, String lastname)
	{
		homepage.clickonPIMTab();
		pim.clickAddEmployeeBtn();
		pim.addEmployee(firstname, middlename, lastname);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
