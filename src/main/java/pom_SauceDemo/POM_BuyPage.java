package pom_SauceDemo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_BuyPage 
{
	private WebDriver driver;
	
	@FindBy(xpath="//button[@id='continue-shopping']")
	private WebElement ContinueShopping;
	public void ClickContinueShopping()
	{
		ContinueShopping.click();
	}
	
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement Checkout;
	public void ClickCheckout()
	{
		Checkout.click();
	}
	
	@FindBy(xpath="//button[text()='Remove']")
	private List<WebElement> RemoveButton;
	public void ClickRemoveButton()
	{
		for(WebElement i:RemoveButton)
		{
			i.click();
		}
	}
	
	@FindBy(xpath="//input[@id='first-name']")
	private WebElement FName;
	public String EnterFirstName(String FirstName)
	{
		FName.sendKeys(FirstName);
		return FirstName;
	}
	
	@FindBy(xpath="//input[@id='last-name']")
	private WebElement LName;
	public String EnterLastName(String LastName)
	{
		LName.sendKeys(LastName);
		return LastName;
	}
	
	@FindBy(xpath="//input[@id='postal-code']")
	private WebElement PostalCode;
	public String EnterPostalCode(String ZipCode)
	{
		PostalCode.sendKeys(ZipCode);
		return ZipCode;
	}
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement ContinueButton;
	public void ClickContinueButton()
	{
		ContinueButton.click();
	}
	
	@FindBy(xpath="//button[@id='finish']")
	private WebElement FinishButton;
	public void ClickFinishButton()
	{
		FinishButton.click();
	}
	
	@FindBy(xpath="//button[@id='cancel']")
	private WebElement CancelButton;
	public void ClickCancelButton()
	{
		CancelButton.click();
	}
	
	@FindBy(xpath="//span[text()='Checkout: Complete!']")
	private WebElement CompletMsgText;
	public String GetCompletMsgText()
	{
		String ActMsg=CompletMsgText.getText();
		return ActMsg;
	}
	
	@FindBy(xpath="//button[@id='back-to-products']")
	private WebElement GetBackButton;
	public void ClickGetBackButton()
	{
		GetBackButton.click();
	}
	
	
//	@FindBy(xpath="//button[text()='Remove']")
//	private List<WebElement> RemovePerticular;
//	public void ClickRemovePerticularProd()
//	{
		
//		for(WebElement i:RemovePerticular)
//		{
//			i.click();
//		}
//  }
	
	public POM_BuyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
	
	

