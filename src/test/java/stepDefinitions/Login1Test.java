package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginAccountpage;
import resources.Base;


public class Login1Test extends Base{
	WebDriver driver;
	LoginAccountpage lap;

    @Given("^open any Browser$")
    public void open_any_browser() throws Throwable {
    	driver=initializeDriver();		
    }
    
    @And("^Navigate to Login Page$")
    public void navigate_to_login_page() throws Throwable {
    	driver.get(prop.getProperty("url"));
    	 LandingPage lp=new LandingPage(driver);
    	 lp.getMyAcc().click();
    	 lp.getLogin().click();
    }

    @When("^User enter username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void user_enter_username_as_something_and_password_as_something(String uname, String pwd) throws Throwable {
        lap=new LoginAccountpage(driver); 
		lap.getUname().sendKeys(uname);
		lap.getPwd().sendKeys(pwd);
        
    }
    
    @And("^User clicks on login button$")
    public void user_clicks_on_login_button() throws Throwable {
       lap.getLoginBtn().click();
    }

    @Then("^User is able to successfully login$")
    public void user_is_able_to_successfully_login() throws Throwable {
    	AccountPage ap=new AccountPage(driver);
    	Assert.assertTrue(ap.getEdityouracctinfoelement().isDisplayed());
    }

    @After
    public void closeBrowser()
    {
    	driver.quit();
    }
}