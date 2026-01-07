package BaseClassPack;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import FileOperation.ReadWriteProperty;

public class BaseClass {
	
	public WebDriver driver;
	
	
	void launchBrowser(String browser) throws IOException {

		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			throw new IllegalArgumentException("Invalid browser: "+browser);
		}
	}
	
	void configureBrowser() throws IOException {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(ReadWriteProperty.readProperty("url"));
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void Setup(String browser) throws IOException {

launchBrowser(browser);
configureBrowser();
	
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		if(driver!=null) {
			driver.quit();
		}
	}

}
