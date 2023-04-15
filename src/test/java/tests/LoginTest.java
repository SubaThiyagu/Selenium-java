package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.LoginAccountpage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import resources.Base;
import resources.ExcelReader;

public class LoginTest extends Base{
	public WebDriver driver;
	@BeforeMethod
	public void launchBrowser() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getLoginData")
	public void loginMethod(String uname,String pwd,String expected) throws IOException{
				
		
		LandingPage lp=new LandingPage(driver);
		lp.getMyAcc().click();
		lp.getLogin().click();
		
		LoginAccountpage lap=new LoginAccountpage(driver); 
		lap.getUname().sendKeys(uname);
		lap.getPwd().sendKeys(pwd);
		lap.getLoginBtn().click();
		
		AccountPage ap=new AccountPage(driver);		
		String actual=null;
		try
		{
		if(ap.getEdityouracctinfoelement().isDisplayed())
		{
			actual="success";					
		}
		}
		catch(Exception e)
		{
		 actual="failure";
		}
		Assert.assertEquals(actual, expected);
		
		ap.getSearchText().sendKeys("Samsung");
		ap.getSearchBtn().click();
		
		SearchPage sp=new SearchPage(driver);
		sp.getProductThumb().click();
		
//		ProductPage pp=new ProductPage(driver);
//		pp.getQuantityField().clear();
//		pp.getQuantityField().sendKeys("1");
//		pp.getaddtocart().click();
//		String emsg="You have added Samsung SyncMaster 941BW to your shopping cart!";
//		Assert.assertTrue(emsg.contains(pp.getsuccessMsg().getText()));
//		pp.getviewCartDisplay().click();
//		pp.getViewCartClick().click();
//		pp.getcheckOutButton().click();
//		
//		CheckoutPage cp=new CheckoutPage(driver);
//		cp.getnewClick().click();
//		cp.getfirstNameField().sendKeys("Thiyagu");
//		cp.getlastNameField().sendKeys("Log");
//		cp.getcompanyField().sendKeys("AWT");
//		cp.getaddressField().sendKeys("street");
//		cp.getcityField().sendKeys("kcity");
//		cp.getpostcodeField().sendKeys("34455656");
//		Select select=new Select(cp.getcountryField());
//		select.selectByVisibleText("India");
//		
//		Select state1=new Select(cp.getstateField());
//		state1.selectByVisibleText("Karnataka");
//		
//		cp.getcontinueButton().click();
//		cp.getcontinueButton1().click();
//		cp.getcontinueButton2().click();
//		cp.checkBox().click();
//		cp.getcontinueButton3().click();
//		cp.getconfirmButton().click();
//		Assert.assertTrue(cp.getsuccessMessage().isDisplayed());

		
		
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
		
	}
@DataProvider	
public Object[][] getLoginData() throws IOException
{ 	
	ExcelReader excel= new ExcelReader();
	Object[][] exceldata=excel.excelRead();
	return exceldata;
	
	
}
}
