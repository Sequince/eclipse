package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	
	private static WebElement element = null;
	
	
	public static WebElement textbox_search(WebDriver driver) {
		
		
		element = driver.findElement(By.name("q"));
		
		return element;
	}
	
	
	//Test to see if 404 is found
	public static boolean search404(WebDriver driver) {
		
		
		boolean result = driver.getTitle().contains("404");
		
		return result;
	}
	
	
	
	public static WebElement button_search(WebDriver driver) {
		
		element = driver.findElement(By.name("btnK"));
		return element;
		
	}
	
}
