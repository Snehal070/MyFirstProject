package pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom_SauceDemo.POM_BuyPage;
import pom_SauceDemo.POM_HomePage;
import utility_SauceDemo.ScreenShots_SauceDemo;

public class TestClass extends BaseClass
{
	@Test(priority=1)
	public void VerifyLoginFunctionality() throws IOException
	{
		
		log.info("Validations Applied");
		
		String ActURL=driver.getCurrentUrl();
		String ExpURL="https://www.saucedemo.com/inventory.html";
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(ActURL, ExpURL);
		log.info("Soft assertion executed");
		String Title=driver.getTitle();
		String ExpTitle="Swag Labs";
		soft.assertEquals(Title, ExpTitle);
		soft.assertAll();
		log.info("2nd Hard assertion executed");
		
	}
	
	@Test(priority=2)
	public void VerifyLogoutFunctionality() throws InterruptedException, IOException
	{
       POM_HomePage hp=new POM_HomePage(driver);
		
		hp.ClickMenuButton();
		log.info("Clicked on menu button");
		hp.ClickLogOutButton();
		log.info("Clicked on Logout button");
		
		log.info("Validations Applied");
	
		String ExpURL="https://www.saucedemo.com/";
		
		String ActURL=driver.getCurrentUrl();
		Assert.assertEquals(ActURL, ExpURL);
		
		ScreenShots_SauceDemo.ScreenShot(driver,"SD-Logout");
		log.info("Logout Functionality Screenshot Taken");
	}
	
	@Test(priority=4)
	public void VerifyAddToCart() throws InterruptedException, IOException
	{
        POM_HomePage hp=new POM_HomePage(driver);
		
		hp.ClickAll_AddToCart();
		log.info("Clicked on all Add To Cart Buttons");
		
		log.info("Validations Applied");
		
		String ExpResult="6";
		String ActResult=hp.GetTextCart();
		
		Assert.assertEquals(ExpResult, ActResult);
		
		ScreenShots_SauceDemo.ScreenShot(driver,"SDAddToCart");
		log.info("All product add to cart Functionality Screenshot Taken");
	
	}
	
	@Test(priority=3)
	public void VerifyFilterZToA() throws InterruptedException, IOException
	{
         POM_HomePage hp=new POM_HomePage(driver);
		
		hp.ClickFilterDrpDwn("Name (Z to A)");
		log.info("Clicked on filter option");
		log.info("Name (Z to A) - Filter selected");
		
		log.info("Validation Applied");
		
		List<String> ExpProdTitles=new ArrayList<String>();
		Collections.addAll(ExpProdTitles,"Test.allTheThings() T-Shirt (Red)","Sauce Labs Onesie","Sauce Labs Fleece Jacket","Sauce Labs Bolt T-Shirt","Sauce Labs Bike Light","Sauce Labs Backpack");
	
		Assert.assertEquals(ExpProdTitles, (hp.GetTextAllProd()));
		
		ScreenShots_SauceDemo.ScreenShot(driver,"FilterZ-A");
		log.info("Filter(Z-A) Functionality Screenshot Taken");
	
	}
	
	@Test(priority=5)
	public void VerifyFilterPrice() throws InterruptedException, IOException
	{
        POM_HomePage hp=new POM_HomePage(driver);
		
		hp.ClickFilterDrpDwn("Price (low to high)");
		log.info("Clicked on filter option");
		log.info("Price(Low to High) - Filter selected");
		
		log.info("Validation Applied");
		
		List<String> ExpText=new ArrayList<String>();
		Collections.addAll(ExpText, "$7.99","$9.99","$15.99","$15.99","$29.99","$49.99");
		
		//Actual result = hp.GetPriceAllProd()
		
		Assert.assertEquals(ExpText, (hp.GetPriceAllProd()));
		
		ScreenShots_SauceDemo.ScreenShot(driver, "FilterL-H");
		log.info("Filter(Price L to H) Functionality Screenshot Taken");
	
	}
	
	@Test(priority=6)
	public void VerifyBuyProduct() throws InterruptedException, IOException
	{
        POM_HomePage hp=new POM_HomePage(driver);
		
		hp.ClickAll_AddToCart();
		log.info("All products added to cart");
		
		hp.ClickCart();
		log.info("Clicked on cart button");
	
		POM_BuyPage BuyPage=new POM_BuyPage(driver);
		
		BuyPage.ClickCheckout();
		log.info("Clicked on checkout button");
		
		BuyPage.EnterFirstName("Snehal");
		log.info("First name entered");
		
		BuyPage.EnterLastName("Saste");
		System.out.println("Last name entered");
		
		BuyPage.EnterPostalCode("411070");
		log.info("Postal code entered");
		
		BuyPage.ClickContinueButton();
		log.info("Clicked on continue button");
		
		BuyPage.ClickFinishButton();
		log.info("Clicked on finish button");
		
		log.info("Validations Applied");
		
		String ExpTextMsg="CHECKOUT: COMPLETE!";
		String ActTextMsg=BuyPage.GetCompletMsgText();
		
		Assert.assertEquals(ExpTextMsg, ActTextMsg);
		ScreenShots_SauceDemo.ScreenShot(driver, "BuyProd");
		log.info("Total Buy Product Functionality Screenshot Taken");
	
	}
}
