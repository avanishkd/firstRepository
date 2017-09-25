
package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WebDriverhelper;

public class RegisterPage extends WebDriverhelper{
	
	
	
	
	

	@FindBy (id="register_email")
	public WebElement registerEmail;	
	@FindBy (id="register_password")
	public WebElement passwordEdit;
	
	@FindBy (id="register_pwconfirm")
	public WebElement confirmPasswordEdit;

	@FindBy (id="register_submit")
	public WebElement submitButton;
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean register(String userName, String Password){
		Assert.assertTrue(sendText(registerEmail,userName));
		Assert.assertTrue(sendText(passwordEdit,Password));
		Assert.assertTrue(sendText(confirmPasswordEdit,Password));
		Assert.assertTrue(clickElement(submitButton));
		return true;
	}
	
	
}
