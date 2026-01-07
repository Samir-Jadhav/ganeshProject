package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClassPack.BaseClass;
import PageClass.LoginPage;
import RetryTest.RetryImplementation;

public class LoginTest extends BaseClass {
	
	@Test(retryAnalyzer = RetryImplementation.class)
	void lp() throws IOException {
		LoginPage login = new LoginPage(driver);
		login.login();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

}
