package test_SauceDemo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import pom_SauceDemo.POM_BuyPage;
import pom_SauceDemo.POM_HomePage;
import pom_SauceDemo.POM_LoginPage;
import utility_SauceDemo.ScreenShots_SauceDemo;

public class TC07_VerifyBuyProduct_CompleteProcess extends TestBaseClass
{
	WebDriver driver;
	@Test
	public void TC07_BuyProduct_CompleteProcess() throws IOException, InterruptedException
	{
		
		POM_HomePage hp=new POM_HomePage(driver);
		
		hp.ClickAll_AddToCart();
		System.out.println("All products added to cart");
		Thread.sleep(2000);
		
		ScreenShots_SauceDemo.ScreenShot(driver, "TC 07-AddedToCart-");
		System.out.println("Add To Cart screenshot taken");
		
		Thread.sleep(2000);
		
		hp.ClickCart();
		System.out.println("Clicked on cart button");
		
		Thread.sleep(2000);
		
		ScreenShots_SauceDemo.ScreenShot(driver, "TC 07-YourCartPage-");
		System.out.println("Your cart page screenshot taken");
		
		Thread.sleep(2000);
		
		POM_BuyPage BuyPage=new POM_BuyPage(driver);
		
		BuyPage.ClickCheckout();
		System.out.println("Clicked on checkout button");
		
		Thread.sleep(2000);
		
		ScreenShots_SauceDemo.ScreenShot(driver, "TC 07-YourInfoPage-");
		System.out.println("Your information page screenshot taken");
		
		Thread.sleep(2000);
		
		BuyPage.EnterFirstName("Snehal");
		System.out.println("First name entered");
		
		BuyPage.EnterLastName("Saste");
		System.out.println("Last name entered");
		
		BuyPage.EnterPostalCode("411070");
		System.out.println("Postal code entered");
		
		BuyPage.ClickContinueButton();
		System.out.println("Clicked on continue button");
		Thread.sleep(2000);
		ScreenShots_SauceDemo.ScreenShot(driver, "TC 07-OverviewPage-");
		System.out.println("Overview page screenshot taken");
		
		Thread.sleep(2000);
		
		BuyPage.ClickFinishButton();
		System.out.println("Clicked on finish button");
		Thread.sleep(2000);
		ScreenShots_SauceDemo.ScreenShot(driver, "TC 07-FinalCheckout-");
		System.out.println("Final Checkout page screenshot taken");
		Thread.sleep(2000);
		
		System.out.println("Validations Applied");
		
		String ExpTextMsg="CHECKOUT: COMPLETE!";
		String ActTextMsg=BuyPage.GetCompletMsgText();
		
		Assert.assertEquals(ExpTextMsg, ActTextMsg);
	}
}
