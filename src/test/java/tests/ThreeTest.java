package tests;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base {
	public WebDriver driver;

	
	@Test
	public void threeTestLogin() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		System.out.println("threetest");
	//	Assert.assertTrue(false);
	}
	
	@AfterMethod
	public void closeThree()
	{
		driver.quit();
		
	}

}
	
	
