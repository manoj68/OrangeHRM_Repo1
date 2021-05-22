package orange.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orange.base.TestBase;

public class AdminTabPage extends TestBase
{
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement adminBtn;
	
	@FindBy(id="menu_admin_UserManagement")
	WebElement userMgBtn;
	
	@FindBy(xpath="//table[@id='resultTable']//following-sibling::tbody/tr")
	List<WebElement> allUser;	//no change for find element's method in page factory and just storing it in list
	
	@FindBy(id="searchSystemUser_userType")
	WebElement userRoleBtn;
	
	@FindBy(id="searchBtn") WebElement searchBtn;
	
	@FindBy(xpath="//input[@value='Add']") WebElement addBtn;
	
	@FindBy(id="btnSave") WebElement saveBtn;
	
	////////////////////////
	public AdminTabPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	////////Actions//////////
	
	public void clickOnAdminBtn()
	{		
		adminBtn.click();
	}
	
	public void clickUserMgmntBtn()
	{		
		userMgBtn.click();
	}
	
	public List<WebElement> clickOnAllUser_resultTable()
	{
		return allUser;	//heree we are just passing the location of the table values and no click required.
	}	
	
	public WebElement userRoleDropDown()
	{
		//in select tab we are passing element address hence no click required at this stage
		return userRoleBtn;
	}
	
	public void clickSearchBtn()
	{
		searchBtn.click();
	}
	
	public void clickAddBtn()
	{
		addBtn.click();
	}
	
	public boolean isDisplayedSaveBtn()
	{
		return saveBtn.isDisplayed();
	}
}


