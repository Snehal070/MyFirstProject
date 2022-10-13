package pack1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pom_SauceDemo.POM_LoginPage;
import utility_SauceDemo.ScreenShots_SauceDemo;

public class BaseClass
{
	Logger log=Logger.getLogger("SauceDemoMaven");
	WebDriver driver;
	
	@BeforeMethod
	public void setup ()throws InterruptedException
	{
		PropertyConfigurator.configure("Log4j.properties");
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
	
	log.info("Browser is open");
	
	driver.manage().window().maximize();
	
	driver.get("https://www.saucedemo.com/");
	log.info("URL is open");
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	POM_LoginPage lp=new POM_LoginPage(driver);
	
	lp.EnterUserName();
	log.info("Username entered");
	
	lp.EnterPassword();
	log.info("Password entered");
	
	lp.ClickLoginButton();
	log.info("Clicked on login button");
	
	log.info("Home page open");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		log.info("Close the browser ");
		
		log.info("End Of Program");
	}

}
