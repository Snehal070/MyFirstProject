package pom_SauceDemo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class POM_HomePage 
{
private WebDriver driver;
private Select S;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") 
	private WebElement MenuButton;
	public void ClickMenuButton()
	{
		MenuButton.click();
	}
	
	@FindBy(xpath="//a[@id='inventory_sidebar_link']") 
	private WebElement AllItemsButton;
	public void ClickAllItems()
	{
		AllItemsButton.click();
	}
	
	@FindBy(xpath="//a[@id='about_sidebar_link']") 
	private WebElement AboutButton;
	public void ClickAboutButton()
	{
		AboutButton.click();
	}
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']") 
	private WebElement LogOutButton;
	public void ClickLogOutButton()
	{
		LogOutButton.click();
	}
	
	@FindBy(xpath="//a[@id='reset_sidebar_link']")
	private WebElement ResetAppState;
	public void ClickResetAppState()
	{
		ResetAppState.click();
	}
	
	@FindBy(xpath="//a[@class='shopping_cart_link']") 
	private WebElement Cart;
	public void ClickCart()
	{
		Cart.click();
	}
	
	@FindBy(xpath="//a[@class='shopping_cart_link']") 
	private WebElement GetTextCart;
	public String GetTextCart()
	{
		String CartText=GetTextCart.getText();
		return CartText;
	}
	
	@FindBy(xpath="//SELECT[@class='product_sort_container']") 
	private WebElement FilterDrpDwn;
	public String ClickFilterDrpDwn(String FilterVisibleText)
	{
		FilterDrpDwn.click();
		S.selectByVisibleText(FilterVisibleText);
		return FilterVisibleText;
	}
	
	@FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory']")
	private List<WebElement> All_ProdAddToCart;
	public void ClickAll_AddToCart()
	{
		for(WebElement i:All_ProdAddToCart)
		{
			i.click();
		}
	}
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	private List<WebElement> AllProdTitle;
	
	public List<String> GetTextAllProd()
	{
		List<String> ActTitles=new ArrayList<String>();
		for(WebElement i: AllProdTitle)
		{
			ActTitles.add(i.getText());
		}
		return ActTitles;
	}
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	private List<WebElement> AllProdPrice;
	
	public List<String> GetPriceAllProd()
	{
		List<String> ActPrices=new ArrayList<String>();
		for(WebElement i: AllProdPrice)
		{
			ActPrices.add(i.getText());
		}
		return ActPrices;
	}
	
	public POM_HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		S = new Select(FilterDrpDwn);
	}
}
