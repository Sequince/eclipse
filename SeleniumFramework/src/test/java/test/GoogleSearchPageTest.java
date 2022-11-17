package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.GoogleSearchPageObjects;

public class GoogleSearchPageTest {

	//initiate variable, private so only available to this class
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearchTest();
	}
	
	public static void googleSearchTest() {
		
		//Set path for easier porting to other machines, and driver for launching Chrome
		String projectPath = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Object for Google search page to reference classes from GoogleSearchPageObjects
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		
		//Go to the website
		driver.get("https://Google.com");
		
		searchPageObj.setTextInSearchBox("A B C D");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		searchPageObj.clickSearchButton();
		
		
		//driver.close();
		
	}
	
}
