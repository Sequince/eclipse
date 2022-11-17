import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.ie.InternetExplorerDriver;


//Desired Capabilities - Allows use of additional properties for browser, versions, ignore popups, ignore java, etc - google for full list 
//This uses ignore protect mode (in selenium) 
public class DesiredCapabilities_Demo {

	public static void main(String[] args) {

		//Setup browser
		String projectPath = System.getProperty("user.dir");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		
		//Set path of IE Driver
		System.setProperty("webdriver.ie.driver", projectPath+"/drivers/iedriver/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver(caps);
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Seq");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

		//driver.close();
		//driver.quit();
	}

}
