package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='payment_address'and @value='new']")
	WebElement newchk;
	@FindBy(xpath="//input[@id='input-payment-firstname']")
	WebElement fname;
	@FindBy(xpath="//input[@id='input-payment-lastname']")
	WebElement lname;
	@FindBy(xpath="//input[@id='input-payment-company']")
	WebElement company;
	@FindBy(xpath="//input[@id='input-payment-address-1']")
	WebElement address;
	@FindBy(xpath="//input[@id='input-payment-city']")
	WebElement city;
	@FindBy(xpath="//input[@id='input-payment-postcode']")
	WebElement postcode;
	@FindBy(id="input-payment-country")
	WebElement country;
	@FindBy(id="input-payment-zone")
	WebElement state;
	@FindBy(xpath="//input[@id='button-payment-address'and @value='Continue']")
	WebElement contnBtn;
	@FindBy(xpath="//input[@id='button-shipping-address'and @value='Continue']")
	WebElement contnBtn1;
	@FindBy(xpath="//input[@id='button-shipping-method'and @value='Continue']")
	WebElement contnBtn2;
	@FindBy(xpath="//input[@type='checkbox'and @name='agree']")
	WebElement chkBox;
	@FindBy(xpath="//input[@id='button-payment-method'and @value='Continue']")
	WebElement contnBtn3;
	@FindBy(xpath="//input[@id='button-confirm']")
	WebElement confirm;	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Success']")
	WebElement success;
	@FindBy(xpath="//h1[text()='Your order has been placed!']")
	WebElement message;
	@FindBy(xpath="//input[@name='payment_address'and @value='new']")
	WebElement newChkBox;
	
	
	
	
	public WebElement getNew()
	{
	 return newchk;
	}
	public WebElement getfirstNameField()
	{
		return fname;
	}
	public WebElement getlastNameField()
	{
		return lname;
	}
	public WebElement getcompanyField()
	{
		return company;
	}
	public WebElement getaddressField()
	{
		return address;
	}
	public WebElement getcityField()
	{
		return city;
	}
	public WebElement getpostcodeField()
	{
		return postcode;
	}
	public WebElement getcountryField()
	{
		return country;
	}
	public WebElement getstateField()
	{
		return state;
	}
	public WebElement getcontinueButton()
	{
		return contnBtn;
	}
	public WebElement getcontinueButton1()
	{
		return contnBtn1;
	}
	public WebElement getcontinueButton2()
	{
		return contnBtn2;
	}
	public WebElement checkBox()
	{
		return chkBox;
	}
	
	public WebElement getcontinueButton3()
	{
	return contnBtn3;
	}
	public WebElement getconfirmButton()
	{
		return confirm;
	}
	public WebElement getsuccessMessage()
	{
	return success;
	}
	public WebElement getmessage()
	{
		return message;
	}
	public WebElement getnewClick()
	{
	 return newChkBox;
	}
}
