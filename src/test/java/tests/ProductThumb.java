package tests;

import java.io.IOException;

import pageObjects.LandingPage;
import pageObjects.LoginAccountpage;
import pageObjects.ProductPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class ProductThumb extends LoginTest {

public WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void addtocart(String uname,String pwd)
	{	
		LandingPage lp=new LandingPage(driver);
		lp.getMyAcc().click();
		lp.getLogin().click();
		
		LoginAccountpage lap=new LoginAccountpage(driver); 
		lap.getUname().sendKeys(uname);
		lap.getPwd().sendKeys(pwd);
		lap.getLoginBtn().click();
		ProductPage pp=new ProductPage(driver);
		//pp.getQuantityField().clear();
		pp.getQuantityField().sendKeys("1");
		pp.getaddtocart().click();
		String emsg="You have added Samsung SyncMaster 941BW to your shopping cart!";
		String emsg1=pp.getsuccessMsg().getText();
		Assert.assertTrue(emsg.contains(emsg1));
		pp.getviewCartDisplay().click();
		pp.getViewCartClick().click();
		
	}
	
	@AfterMethod
	public void closeTwo()
	{
		driver.quit();
		
	}




}