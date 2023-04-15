package utilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import resources.Base;

public class ExtentReporter {
	
	public static ExtentReports extentReporter;
	

	public static ExtentReports getExtentReport(){
	
		String path=System.getProperty("user.dir")+"\\reports\\extentReports.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Framework report");
		reporter.config().setReportName("Test Results");
		
		ExtentReports extentReporter=new ExtentReports();
		extentReporter.attachReporter(reporter);
		extentReporter.setSystemInfo("Operating System","Windows11");
		extentReporter.setSystemInfo("Java Version", "java 11");
		extentReporter.setSystemInfo("Tested By", "Subashini");
		
		return extentReporter;
		
	}

}
