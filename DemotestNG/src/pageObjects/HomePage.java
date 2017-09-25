package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WebDriverhelper;

public class HomePage extends WebDriverhelper{
	
	
	
	@FindBy (xpath="//span[@id='header_account_desktop_txt']")
	public WebElement ButtonMyAccount;	
	
	@FindBy (xpath="//a[text()='Se connecter']")
	public WebElement ButtonLogin;
	@FindBy (xpath="//a[text()='Créer un compte']")
	public WebElement ButtonRegistration;
	@FindBy (xpath="//ul[@class='dropdown-menu header_desktop_menu container']/li[4]")
	public WebElement LinkMyModeofRepayment;
	@FindBy (xpath="//ul[@class='dropdown-menu header_desktop_menu container']/li[5]")
	public WebElement LinkLogOut;

	@FindBy (xpath="//span[@id='header_basket_desktop_txt']/span")
	public WebElement TextBasketAmount;
	@FindBy (xpath="(//span[@class='offer_tile_discount'])[1]")
	public WebElement OfferAmountFirstProduct;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean fromHometoRegistrationPage(String homePageURL){
		Assert.assertTrue(navigate(homePageURL));
		Assert.assertTrue(clickElement(ButtonRegistration));
		return true;
	}
	public boolean fromHometoLoginPage(String homePageURL){
		Assert.assertTrue(navigate(homePageURL));
		Assert.assertTrue(clickElement(ButtonLogin));
		return true;
	}
	
	public boolean logout(){
		
		Assert.assertTrue(clickElement(ButtonMyAccount));
		Assert.assertTrue(clickElement(LinkLogOut));
		
		return true;
	}
	
	
	
}
