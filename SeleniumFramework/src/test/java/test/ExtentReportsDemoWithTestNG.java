package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemoWithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	
	//Runs before test runs to perform setup - Use @BeforeSuite if only want to run once (if multi tests setup)
	@BeforeTest
	public void setUp() {

		//BIG tip!  Ctrl+Shift+O = Import all default required imports for missing elements 
		//Ctrl+A & Ctrl+I = Indentation for whole document

		// start reporters
		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	
	//Setting up test and Chrome driver
	@BeforeTest
	public void setUpTest() {
		//Set path for easier porting to other machines, and driver for launching Chrome
		String projectPath = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	

	@Test
	//Test code
	public void test1() throws Exception {
		
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		
		driver.get("Https://google.com");
		test.pass("Navigated to Google.com");
		
		
        // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        // info(details)
        test.info("This step shows usage of info(details)");        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@Test
	//Test code
	public void test2() throws Exception {
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
			
		
        // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
	}
	
	
	@AfterTest
	public void tearDownTest() {

		//Close browser
		//driver.close();
		driver.quit();
		
		System.out.println("Test Completed Successfully.");
	} 
	
	@AfterTest
	//Runs after test to do the tear down Use @AfterSuite if only want to run once (if multi tests setup)
	public void tearDown() {

		extent.flush();
	}

}
