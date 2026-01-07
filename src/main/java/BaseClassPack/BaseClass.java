package BaseClassPack;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import FileOperation.ReadWriteProperty;

public class BaseClass {
	
	public WebDriver driver;
	
	
	void launchBrowser(String browser) throws IOException {
		

		
		 boolean headless =
			        Boolean.parseBoolean(ReadWriteProperty.readProperty("headless"));

			    if (browser.equalsIgnoreCase("chrome")) {

			        ChromeOptions options = new ChromeOptions();
			        if (headless) {
			            options.addArguments("--headless=new");
			            options.addArguments("--window-size=1920,1080");
			        }
			        driver = new ChromeDriver(options);

			    } else if (browser.equalsIgnoreCase("firefox")) {

			        FirefoxOptions options = new FirefoxOptions();
			        if (headless) {
			            options.addArguments("-headless"); // CORRECT
			        }
			        driver = new FirefoxDriver(options);

			    } else if (browser.equalsIgnoreCase("edge")) {

			        EdgeOptions options = new EdgeOptions();
			        if (headless) {
			            options.addArguments("--headless=new");
			            options.addArguments("--window-size=1920,1080");
			        }
			        driver = new EdgeDriver(options);

			    } else {
			        throw new IllegalArgumentException("Invalid browser: " + browser);
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
