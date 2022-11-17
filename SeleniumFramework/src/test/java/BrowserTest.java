import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		
		System.out.println("ProjectPath is: " +projectPath);
		
		//Required because newer version of Firefox
		//System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//System.setProperty("webdriver.ie.driver", projectPath+"/drivers/iedriver/IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		
		
				
		//driver.close();

		
		driver.get("https://www.google.com/");
		

		//Using Xpath
		driver.findElement(By.xpath("//input[@name=\'q\'][@class=\'gLFyf gsfi\']")).sendKeys("Seq");
		
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		
		int count = listOfInputElements.size();
		
		System.out.println("Count of Input Elements on page: " +count);
		
		//WebElement textBox = driver.findElement(By.name("q"));
		//textBox.sendKeys("Seq");
	}
}
