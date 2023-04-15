package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAccountpage {
	WebDriver driver;
	
	public LoginAccountpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
	WebElement Uname;
	@FindBy(xpath="//input[@id=\"input-password\"]")
	WebElement pwd;
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getUname() {
		return Uname;
	}
	
	public WebElement getPwd() {
		return pwd;
	}

	

}
