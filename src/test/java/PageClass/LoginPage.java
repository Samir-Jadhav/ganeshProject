package PageClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FileOperation.ReadWriteProperty;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passWord;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement logBtn;
	
	public void login() throws IOException {
		userName.sendKeys(ReadWriteProperty.readProperty("username"));
		passWord.sendKeys(ReadWriteProperty.readProperty("password"));
		logBtn.click();
	}
	

}
