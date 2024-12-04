package testCases;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestExtentReports {
	
	@Test
	public void testExtent() throws IOException
	{
	 ExtentReports extent = new ExtentReports();
	 
	 File file=new File(System.getProperty("user.dir")+"\\ExtentReports\\eReports.html");
	 
	 ExtentSparkReporter spark = new ExtentSparkReporter(file);
	 extent.attachReporter(spark);
	 
	 ExtentTest test=extent.createTest("TestOne"); 
	 test.log(Status.INFO,"The execution started");
	 
	 test.pass("TestOne Passed");
	 
	 //2nd method
	 test.log(Status.PASS, "TestOne got Passed");
	 
	 ExtentTest test1=extent.createTest("TestTwo"); 
	 test1.fail("TestTwo failed");
	 
	 ExtentTest test2=extent.createTest("TestThree"); 
	 test2.skip("TestThree Skipped");
	 
	 extent.flush();
	 
	 Desktop.getDesktop().browse(file.toURI()); //This statement open the report automatically once the execution completed

	}
}
