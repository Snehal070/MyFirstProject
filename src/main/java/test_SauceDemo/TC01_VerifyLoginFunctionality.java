package test_SauceDemo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import pom_SauceDemo.POM_LoginPage;
import utility_SauceDemo.ScreenShots_SauceDemo;

public class TC01_VerifyLoginFunctionality extends TestBaseClass
{
	
	@Test(priority=0)
	public void TC01_LoginFunctionality() throws IOException, InterruptedException
	{
		System.out.println("Validations Applied");
		
		String ActURL=driver.getCurrentUrl();
		String ExpURL="https://www.saucedemo.com/inventory.html";
		
		Assert.assertEquals(ActURL, ExpURL);
		
	}
	
}
