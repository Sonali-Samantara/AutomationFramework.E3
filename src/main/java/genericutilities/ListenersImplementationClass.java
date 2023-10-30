package genericutilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TestNG
 * 
 */

public class ListenersImplementationClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"=== test script execution started ===");

		//create a test script
		test=report.createTest(testScriptName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"=== Passed ===");

		//log the success
		test.log(Status.PASS,testScriptName+"===Passed===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		//ScreenShot
		//Exception for failure	

		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"=== Failed ===");

		//Exception for failure
		System.out.println(result.getThrowable());

		//log for failure
		test.log(Status.FAIL, testScriptName+" == Fail ==");
		test.log(Status.INFO, result.getThrowable());


		//ScreenShot
		String screenShotName=testScriptName+ new javaUtility().getSystemDate1(); //new keyword is creating a new object

		WebDriverUtility w=new WebDriverUtility();
		try {
			
			String path = w.captureScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"=== Skipped ===");

		//Exception for failure
		System.out.println(result.getThrowable());

		//log for Skip
		test.log(Status.SKIP, testScriptName+" == skipped ==");
		test.log(Status.INFO, result.getThrowable());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("==== Suite Execution Started ====");

		//Basic report configurtaion
		ExtentSparkReporter html=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new javaUtility().getSystemDate1()+".html");
		//folder name   //report name
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("Vtiger execution Report");

	    report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Sonali");


	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("==== Suite Execution Finished ====");

		//report generation
		report.flush();

	}



}
