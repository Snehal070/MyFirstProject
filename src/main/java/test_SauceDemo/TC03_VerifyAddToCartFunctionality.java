package test_SauceDemo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import pom_SauceDemo.POM_HomePage;
import pom_SauceDemo.POM_LoginPage;
import utility_SauceDemo.ScreenShots_SauceDemo;

public class TC03_VerifyAddToCartFunctionality extends TestBaseClass
{
	
	@Test
	public void TC03_AddToCartFunctionality() throws IOException, InterruptedException
	{
		POM_HomePage hp=new POM_HomePage(driver);
		
		hp.ClickAll_AddToCart();
		System.out.println("Clicked on all Add To Cart Buttons");
		
		Thread.sleep(2000);
		
		System.out.println("Validations Applied");
		
		String ExpResult="6";
		String ActResult=hp.GetTextCart();
		
		Assert.assertEquals(ExpResult, ActResult);

	}
}
