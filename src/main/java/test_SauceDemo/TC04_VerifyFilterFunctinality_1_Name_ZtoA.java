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

public class TC04_VerifyFilterFunctinality_1_Name_ZtoA extends TestBaseClass
{
	
	@Test
	public void TC04_Filter_ZtoA() throws IOException, InterruptedException
	{
		POM_HomePage hp=new POM_HomePage(driver);
		
		hp.ClickFilterDrpDwn("Name (Z to A)");
		System.out.println("Clicked on filter option");
		System.out.println("Name (Z to A) - Filter selected");
		
		Thread.sleep(2000);
		
//		ScreenShots_SauceDemo.ScreenShot(driver, "TC 04-FilterProd-");
//		System.out.println("Filter products screenshot taken");
		
		System.out.println("Validation Applied");
		
		List<String> ExpProdTitles=new ArrayList<String>();
		Collections.addAll(ExpProdTitles,"Test.allTheThings() T-Shirt (Red)","Sauce Labs Onesie","Sauce Labs Fleece Jacket","Sauce Labs Bolt T-Shirt","Sauce Labs Bike Light","Sauce Labs Backpack");
		
			Assert.assertEquals(ExpProdTitles, (hp.GetTextAllProd()));
	}
}
