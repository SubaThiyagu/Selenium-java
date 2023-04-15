package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Account']")
	WebElement accBreadCrumb;
	
	@FindBy(xpath="//a[contains(text(),'Edit your account information')]")
	WebElement edityouracctinfoelement;
	
	@FindBy(xpath="//input[contains(@class,'form-control input-lg')]")
	WebElement searchText;
	@FindBy(xpath="//button[contains(@class,'btn btn-default btn-lg')]")
	WebElement searchBtn;
	
	
	public WebElement getSearchText() {
		return searchText;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getEdityouracctinfoelement() {
		return edityouracctinfoelement;
	}


	public WebElement getAccBreadCrumb() {
		return accBreadCrumb;
	}

	

}
