package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {


	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		// create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google Search Test One", "This is a test to validate Google Search functionality");

		//Set path for easier porting to other machines, and driver for launching Chrome
		String projectPath = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
        
		//Set pass message to be logged when hit
		test1.log(Status.INFO, "Starting Test Case");
		
		//Go to website
		driver.get("https://google.com");
		//Set pass message when website hit
		test1.pass("Navigated to Google.com");
		
		
		
		//locate element on page
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered text in Searchbox");
		
				//Add delay before sending Enter key
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard Enter key");
		
		/*
		driver.close();
		driver.quit();
		test1.pass("Close the browser");
		*/
		
		test1.info("Test Completed!");
		
		
		
		
		
		
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test2 = extent.createTest("Google Search Test Two", "This is a test to validate Google Search functionality");

		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
        
		//Set pass message to be logged when hit
		test2.log(Status.INFO, "Starting Test Case");
		
		//Go to website
		driver.get("https://google.com");
		//Set pass message when website hit
		test2.pass("Navigated to Google.com");
		
		
		
		//locate element on page
		driver.findElement(By.name("q")).sendKeys("Automation");
		test2.pass("Entered text in Searchbox");
		
				//Add delay before sending Enter key
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test2.fail("Pressed keyboard Enter key");
		
		test2.info("Test Completed!");
		
		
		
		//calling flush writes everything to the log file
		extent.flush();
		
	}

}
