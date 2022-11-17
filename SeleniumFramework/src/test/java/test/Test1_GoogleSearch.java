package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {

	public static void main(String[] args) {
	
		googleSearch();
	}
	
	public static void googleSearch() {
		
		//Set path for easier porting to other machines, and driver for launching Chrome
		String projectPath = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
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
		
		
		//Close browser
		//driver.close();
		
		System.out.println("Test Completed Successfully.");
		
		
	}
	
}
