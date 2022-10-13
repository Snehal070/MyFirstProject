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

public class TC05_VerifyFilterFuctionality_2_Price_LowToHigh extends TestBaseClass
{
	WebDriver driver;
	@Test
	public void TC05_Filter_2_Price_LowToHigh() throws IOException, InterruptedException
	{
		
		POM_HomePage hp=new POM_HomePage(driver);
		
		hp.ClickFilterDrpDwn("Price (low to high)");
		System.out.println("Clicked on filter option");
		System.out.println("Price(Low to High) - Filter selected");
		
		Thread.sleep(2000);
		
		ScreenShots_SauceDemo.ScreenShot(driver, "TC 05-FilterProd-");
		System.out.println("Filter products screenshot taken");
		
		Thread.sleep(2000);
		
		System.out.println("Validation Applied");
		
		List<String> ExpText=new ArrayList<String>();
		Collections.addAll(ExpText, "$7.99","$9.99","$15.99","$15.99","$29.99","$49.99");
		List<String> ActText=hp.GetPriceAllProd();
		Assert.assertEquals(ExpText, ActText);	
		
	}
}
