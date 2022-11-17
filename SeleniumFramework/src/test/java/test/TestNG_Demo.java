package test;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo {

	WebDriver driver = null;

	//Setting up test and Chrome driver
	@BeforeTest
	public void setUpTest() {
		//Set path for easier porting to other machines, and driver for launching Chrome
		String projectPath = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void googleSearch() {
		//Go to Google.com
		driver.get("https://google.com");
		
		//Enter text into search bar
		driver.findElement(By.name("q")).sendKeys("Sequince");
		
		//Click Search button
		//driver.findElement(By.name("btnK")).click();
		
		//Add delay before sending Enter key
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Send Enter as search button is hidden
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	}
	
	@AfterTest
	public void tearDownTest() {

		//Close browser
		//driver.close();
		driver.quit();
		
		System.out.println("Test Completed Successfully.");
	}
	
}
