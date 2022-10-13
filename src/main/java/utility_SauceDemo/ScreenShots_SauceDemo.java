package utility_SauceDemo;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShots_SauceDemo
{
	public static void ScreenShot(WebDriver driver, String SSName) throws IOException
	{
		Date d=new Date();
		DateFormat d1= new SimpleDateFormat("dd-MM-yy & hh-mm-ss");
		String Date=d1.format(d);
		
		TakesScreenshot TS=(TakesScreenshot)driver;
		File Source=TS.getScreenshotAs(OutputType.FILE);
		File Dest=new File("./Screenshots\\SauceDemoMaven\\"+SSName+Date+".jpg");
	    FileHandler.copy(Source, Dest);
	}
}
