package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class SearchPage {
WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//div[@class='product-thumb']//img[contains(@alt,'Samsung SyncMaster 941BW')]")
	WebElement pdtThumb;
	
	public WebElement getProductThumb()
	{
	  return pdtThumb;
	}
}
