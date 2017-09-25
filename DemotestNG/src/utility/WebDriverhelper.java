package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import setUp.BaseClass;

public class WebDriverhelper extends BaseClass {

	public boolean clickElement(WebElement element) {
		int i = 0;
		try {
			for (i = 0; i < 7; i++) {

				try {
					 (new WebDriverWait(driver,5)).until(ExpectedConditions.visibilityOf(element));
					// ViewElement(element);
					if (element.isDisplayed()) {
						element.click();
						System.out.println("Executed :clickElement, PASS");
						return true;
					} else {
						System.out.println("Trying to find object");
						continue;
					}
				} catch (TimeoutException | NoSuchElementException e) {
					Thread.sleep(1000);
					System.out.println("Trying to find object");
					continue;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public	static  boolean navigate(String URL){
		try {
			driver.navigate().to(URL);;
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean sendText(WebElement element, String text){
		int i = 0;
		try {	
			for (i = 0; i < 7; i++) {
				try {	
					(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(element));
					if (element.isDisplayed() && element.isEnabled()) {
						// ViewElement(element);
						
						System.out.print("into enter estimate4");
						element.clear();
						element.sendKeys(text);
						Thread.sleep(1000);
						if (!element.getAttribute("value").contains(text.trim())) {
							Thread.sleep(1000);
							System.out.println("Trying to find object");
							continue;
						}
						System.out.println("Executed :sendText, PASS");
						return true;
					} else {
						Thread.sleep(1000);
						System.out.println("Trying to find object");
						continue;
					}
				} catch (TimeoutException | NoSuchElementException e) {
					Thread.sleep(1000);
					System.out.println("Trying to find object");
					continue;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
