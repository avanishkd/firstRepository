
package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WebDriverhelper;

public class FlipkartLoginPage extends WebDriverhelper{
	
	@FindBy (linkText="Log In")
	public WebElement homePageLoginLink;	
	
	@FindBy (linkText="Signup")
	public WebElement homePageSignUpLink;
	
	@FindBy (xpath="//form/div[1]/input[@type='text']")
	public WebElement userNameEdit;
	
	@FindBy (xpath="//form/div[2]/input[@type='password']")
	public WebElement passwordEdit;
	
	@FindBy (xpath="//form/div[3]/button")
	public WebElement LoginButton;
	
	public FlipkartLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean fromHometoRegistrationPage(String homePageURL){
		Assert.assertTrue(navigate(homePageURL));
		Assert.assertTrue(clickElement(homePageSignUpLink));
		return true;
	}
	public boolean fromHometoLoginPage(String homePageURL){
		Assert.assertTrue(navigate(homePageURL));
		Assert.assertTrue(clickElement(homePageLoginLink));
		return true;
	}
	
	public boolean clickLoginButton(){
		
		Assert.assertTrue(clickElement(LoginButton));
		return true;
	}
	
	public boolean enterLoginUsername(String userName){
		
		Assert.assertTrue(sendText(userNameEdit, userName));
		return true;
	}
	
	public boolean enterLoginPassword(String password){
		
		Assert.assertTrue(sendText(passwordEdit, password));
		return true;
	}
	
	public boolean login(String userName,String password){
		
		Assert.assertTrue(enterLoginUsername(userName));
		Assert.assertTrue(enterLoginPassword(password));
		return true;
	}
}
