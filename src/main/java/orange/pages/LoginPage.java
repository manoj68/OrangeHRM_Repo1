package orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orange.base.TestBase;

public class LoginPage extends TestBase
{
	//Page Factory
	
		@FindBy(id="txtUsername")
		WebElement username;
		
		@FindBy(id="txtPassword")
		WebElement password;
		
		@FindBy(id="btnLogin")
		WebElement loginBtn;
		
		//	Initializing the Page Objects	
		public LoginPage()
		{
			PageFactory.initElements(driver, this);	//here this means current class objects, And all the elements will be initialize with the driver
			//also instead of this we can write as "LoginPage.class"
		}
		
		//Actions
		public String validateLoginPageTitle()
		{
			return driver.getTitle();
		}
		
		public HomePage login(String un, String pwd)
		{
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			return new HomePage();	//after login it will go the homepage hence we are returning HomePage class
		}

}
