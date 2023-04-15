package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Base class to Initialize Driver(Browser)

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop=new Properties(); //create a object for the properties class to access the data file
		//set the path of the data file using fileinputstream class and  Create a object
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\data.properties"); 
		prop.load(fis); //loading file
		String browser=prop.getProperty("browser"); //get the value from the data file using prop object
		if(browser.equals("chrome")) {
			driver= new ChromeDriver(); 
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();			
		}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	public String takeScreenshot(String testName,WebDriver driver) throws IOException
	{
	File sourcefile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destinationFile=System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
	FileUtils.copyFile(sourcefile, new File(destinationFile));
	return destinationFile;
	}
	
}
