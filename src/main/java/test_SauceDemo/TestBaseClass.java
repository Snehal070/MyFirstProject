package test_SauceDemo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pom_SauceDemo.POM_LoginPage;

public class TestBaseClass 
{
	WebDriver driver;
	//@Parameters("BrowserName")
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		//if(BrowserName.equals("FireFox"))
		//{
			//System.setProperty("webdriver.gecko.driver", "F:\\Chrome Browser\\Chrome\\geckodriver.exe\\");
		   // driver=new FirefoxDriver();
		//}
		//else
		//{
			System.setProperty("webdriver.chrome.driver","F:\\Chrome Browser\\Chrome\\chromedriver.exe");
			
			driver=new ChromeDriver();
		//}
	
	System.out.println("Browser is open");
	
	driver.manage().window().maximize();
	
	driver.get("https://www.saucedemo.com/");
	System.out.println("URL is open");
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(1000);
	
	POM_LoginPage lp=new POM_LoginPage(driver);
	
	lp.EnterUserName();
	System.out.println("Username entered");
	
	lp.EnterPassword();
	System.out.println("Password entered");
	
	lp.ClickLoginButton();
	System.out.println("Clicked on login button");
	
	System.out.println("Home page open");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		System.out.println("Close the browser ");
		
		System.out.println("End Of Program");
	}

}
