package test_SauceDemo;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import pom_SauceDemo.POM_HomePage;
import pom_SauceDemo.POM_LoginPage;
import utility_SauceDemo.ScreenShots_SauceDemo;

public class TC06_VerifyFilterFunctionality_Price_HighToLow extends TestBaseClass
{
	
	@Test
	public void TC06_Filter_Price_LowToHigh() throws IOException, InterruptedException
	{
		
		POM_HomePage hp=new POM_HomePage(driver);
		
		hp.ClickFilterDrpDwn("Price (high to low)");
		System.out.println("Clicked on filter option");
		System.out.println("Price(High to Low) - Filter selected");
		
		Thread.sleep(2000);
//		
//		ScreenShots_SauceDemo.ScreenShot(driver, "TC 06-FilterProd-");
//		System.out.println("Filter products screenshot taken");
		
		Thread.sleep(2000);
		
		System.out.println("Validation Applied");
		
		List<String> ExpText=new ArrayList<String>();
		Collections.addAll(ExpText, "$49.99","$29.99","$15.99","$15.99","$9.99","$7.99");
		
		Assert.assertEquals(ExpText, (hp.GetPriceAllProd()));
	}
}
