package utilities;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager {
	ExtentSparkReporter sparkReporter;  //UI of the Report
	ExtentReports extent;  //populate common info in the report
	ExtentTest test; //Creating the test entries  in the reprot and update the status of the methods
	
	String repName;
	@Test
	public void Report()
	{
			
			String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
	
			repName="Test Report- "+timestamp+".html";
		
			extent = new ExtentReports();
		 		 
			sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName); //Specify the location of the report
			sparkReporter.config().setDocumentTitle("Open Cart Automation Report"); //title of the report
			sparkReporter.config().setReportName("The Extent Report Result"); //name of the report
			sparkReporter.config().setTheme(Theme.DARK);
			
			 extent.attachReporter(sparkReporter);
			 extent.setSystemInfo("Application","OpenCart");
			 extent.setSystemInfo("Application","OpenCart");
			 extent.setSystemInfo("Module","Admin");
			 extent.setSystemInfo("User Name",System.getProperty("user.name"));
			 extent.setSystemInfo("Environment","QA");
			 
		/*	 String os=testContext.getCurrentXmlTest().getParameter("os"); // Fetch OS name from XML(Master) File
			 extent.setSystemInfo("operating System", os);
			 String browser=testContext.getCurrentXmlTest().getParameter("browser"); //Fetch Browser name from XML(Master) File
			 extent.setSystemInfo("Browser", browser);
			 List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();
			 if(!includeGroups.isEmpty()) {
				 extent.setSystemInfo("Groups", includeGroups.toString());
			 }*/
	}
			 public void onTestSuccess(ITestResult result)
			 
			 {
				 test= extent.createTest(result.getClass().getName());  //create a new entry in the report
				 test.assignCategory(result.getMethod().getGroups());
				 test.log(Status.PASS,result.getName()+"got successfully executed");
			}
			 
			 public void onTestFailure(ITestResult result)
			 
			 {
				 test= extent.createTest(result.getClass().getName());
				 test.assignCategory(result.getMethod().getGroups());
				 test.log(Status.FAIL,result.getName()+"got failed");
				 test.log(Status.INFO,result.getThrowable().getMessage());
				 try {
				 		
				 		String impPath=new BaseClass().captureScreen(result.getName());
				 		test.addScreenCaptureFromPath(impPath);
				 	} catch (IOException e1) {
				 		e1.printStackTrace();
				 	} 
			}
			 
			public void onTestSkipped(ITestResult result)

		{
			 test= extent.createTest(result.getClass().getName());
			 test.assignCategory(result.getMethod().getGroups());
			 test.log(Status.SKIP,result.getName()+"got Skipped");
			 test.log(Status.INFO,result.getThrowable().getMessage());
		}
			
			public void onFisnish(ITestResult testContext)
			{
				extent.flush(); //Consolidate all information and generate
				
				String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
				File extentReport=new File(pathOfExtentReport);
				try {
					 Desktop.getDesktop().browse(extentReport.toURI()); //This statement open the report automatically once the execution completed
				} catch(IOException e) {
					e.printStackTrace();
				}
				
			}
		}
