package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReports {
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		String path= System.getProperty("user.dir")+"/reports/ExtentReport.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Regression Automation Test Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Cybage");
		return extent;
		
	}

}
