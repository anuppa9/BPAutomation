package modules;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtendReports;

public class TestListners extends Base implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtendReports.getReportObject();
	
	public void onFinish(ITestContext arg0) {
		extent.flush();
	}
	
	public void onStart(ITestContext arg0) {
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}
	
	public void onTestFailure(ITestResult arg0) {
		String testMethodName = arg0.getName().toString().trim();
		test.fail(arg0.getThrowable());
		test.log(Status.FAIL, "Test Failed");
		System.out.println("FAILED- "+testMethodName);
	}

	public void onTestSkipped(ITestResult arg0) {
		
	}

	public void onTestStart(ITestResult arg0) {
		test = extent.createTest(arg0.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult arg0) {
		String testMethodName = arg0.getName().toString().trim();
		test.log(Status.PASS, "Test Passed");
		System.out.println("PASSED- "+testMethodName);
	}

}
