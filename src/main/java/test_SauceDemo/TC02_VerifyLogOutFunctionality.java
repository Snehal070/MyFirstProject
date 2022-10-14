package test_SauceDemo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import pom_SauceDemo.POM_HomePage;
import pom_SauceDemo.POM_LoginPage;
import utility_SauceDemo.ScreenShots_SauceDemo;

public class TC02_VerifyLogOutFunctionality extends TestBaseClass
{
	
	@Test
	public void TC02_LogOutFunctionality() throws IOException, InterruptedException
	{
	
		POM_HomePage hp=new POM_HomePage(driver);
		
		hp.ClickMenuButton();
		System.out.println("Clicked on menu button");
		hp.ClickLogOutButton();
		System.out.println("Clicked on Logout button");
		
		Thread.sleep(2000);
		
//		ScreenShots_SauceDemo.ScreenShot(driver,"TC 02-LogoutPage-");
//		System.out.println("LogOut page screenshot taken");
		
		System.out.println("Validations Applied");
		Thread.sleep(2000);
		
		String ExpURL="https://www.saucedemo.com/";
		String ActURL=driver.getCurrentUrl();
		
		Assert.assertEquals(ActURL, ExpURL);

	}
}
