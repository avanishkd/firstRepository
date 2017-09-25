package setUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utility.ExcelUtility;

public class BaseClass extends ExtentReportsClass{
	
	public static WebDriver driver ;
	public static ExcelUtility testData;
	
	public BaseClass(){
		System.out.println("Base class constructor...");
	}
	@BeforeMethod
	public void OpenBrowser(){
		startReport();
		System.setProperty("webdriver.chrome.driver","D:\\Java\\JARS\\chromedriver_win32\\chromedriver.exe");
		testData=new ExcelUtility(System.getProperty("user.dir")+"\\testData.xls");
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.get("https://www.flipkart.com/");
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void clearBrowser(){
		driver.quit();
		endReport();
	}
}
