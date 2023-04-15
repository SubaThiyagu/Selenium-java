package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {
	public WebDriver driver;
	ExtentReports extentReport= ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread=new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		extentTest=extentReport.createTest(result.getName()+"Execution started");
		extentTestThread.set(extentTest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTestThread.get().log(Status.PASS,result.getName()+"got passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.fail(result.getThrowable());
		String testMethodName=result.getName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
		String screenschotPath=	takeScreenshot( testMethodName, driver);
		extentTestThread.get().addScreenCaptureFromPath(screenschotPath,testMethodName);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
	extentReport.flush();
	}

}
