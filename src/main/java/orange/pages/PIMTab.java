package orange.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orange.base.TestBase;

public class PIMTab
{

	@FindBy(id="menu_pim_viewEmployeeList")
	WebElement Emp_list_btn;
	
	@FindBy(id="empsearch_employee_status")
	WebElement Emp_status;
	
	@FindBy(name="_search")
	WebElement search_btn;
	
	@FindBy(id="btnAdd") WebElement AddBtn;
	
	@FindBy(name="firstName") WebElement FirstName;
	
	@FindBy(name="middleName") WebElement MiddleName;
	
	@FindBy(name="lastName") WebElement LastName;
	
	@FindBy(id="btnSave") WebElement SaveBtn;
	
	//	Initializing the Page Objects	
	public PIMTab(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	//here this means current class objects, And all the elements will be initialize with the driver
		//also instead of this we can write as "LoginPage.class"
	}
	
	//Actions
	
	public void clickOnEmpList()
	{
		Emp_list_btn.click();
		System.out.println("Clicked successfuly.........");
	}
	
	public WebElement clickOnEmpStatus()
	{
//		Emp_status.click();
		return Emp_status;	//returning only webelement address as we have to use this fro multiple elements function
	}
	
	public void clickSearchButton()
	{
		search_btn.click();
	}

	public void clickAddEmployeeBtn()
	{
		AddBtn.click();
	}
	
	//adding test data from excel
	public void addEmployee(String fname, String mname, String lname)
	{
		FirstName.sendKeys(fname);
		MiddleName.sendKeys(mname);
		LastName.sendKeys(lname);
		SaveBtn.click();
	}
	
	
}
