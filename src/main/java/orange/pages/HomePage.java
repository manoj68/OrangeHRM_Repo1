package orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import orange.base.TestBase;

public class HomePage extends TestBase
{

	@FindBy(id="welcome") 
	WebElement welcomeText;
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement PIM_tab_btn;
	
	@FindBy(id="MP_link")
	WebElement marketplaceBtn;
	
	@FindBy(xpath="//h1[@id='menu']")
	WebElement HRM_addons_text;
	
	//	Initializing the Page Objects	
	
//****Note= instead of inheriting base class to this class we can directly pass the WebDriver driver paramters to this constructor
	public HomePage()
	{
		PageFactory.initElements(driver, this);	//here this means current class objects, And all the elements will be initialize with the driver
		//also instead of this we can write as "LoginPage.class"
	}
	
	//Actions
	
	public String verifyHomepageText()
	{
		return welcomeText.getText();
	}
	
	public void clickonPIMTab()
	{
		PIM_tab_btn.click();
	}
	
	public void clickMarketplace()
	{
		marketplaceBtn.click();
	}
	
	public String verifyMarketplaceText()
	{
		return HRM_addons_text.getText();
	}

}
