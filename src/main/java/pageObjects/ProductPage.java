package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement quantity;
	@FindBy(xpath="//button[@type='button' and @id='button-cart']")
	WebElement atcBtn;
	@FindBy(xpath="//div[contains(@class,\"alert-success\")]//a[text()=\"Samsung SyncMaster 941BW\"]")
	WebElement smsg;
	@FindBy(xpath="//button[contains(@class,'btn-inverse')]")
	WebElement viewCartDispBtn;
	@FindBy(xpath="//p[contains(@class,'text-right')]//strong[text()=' View Cart']")
	WebElement viewCart;
	@FindBy(xpath="//a[contains(text(),'Checkout')]")
	WebElement chkOut;
	
	public WebElement getcheckOutButton()
	{
		return chkOut;
	}
	
	public WebElement getQuantityField()
	{
		return quantity;
	}
	public WebElement getaddtocart()
	{
		return atcBtn;
	}
	
	public WebElement getsuccessMsg()
	{
		return smsg;
	}
	public WebElement getviewCartDisplay()
	{
		return viewCartDispBtn;
	}
	public WebElement getViewCartClick()
	{
		return viewCart;
	}

}
