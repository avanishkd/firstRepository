
package executionClasses;

import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FlipkartLoginPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import setUp.BaseClass;
import utility.CSVUtility;
import utility.ExcelUtility;

public class FlipkartLogin extends BaseClass {
	
	public FlipkartLogin(){
		System.out.println("flipkart constructor...");
	}
	FlipkartLoginPage flipkartLoginPageObject;
	
	HashMap<String, String> dict;
	ExcelUtility excelRead;
	@BeforeClass
	public void checkBeforeClass(){
		System.out.println("before class");
	}
	
	@AfterClass
	public void checkAfterClass(){
		System.out.println("after class");
	}
	
	@BeforeTest
	
	
	@Test
	public void demo() throws Exception{
		dict=new HashMap<String,String>();
		dict=testData.loadTestData(this.getClass().getPackage().getName(), this.getClass().getSimpleName());
		flipkartLoginPageObject = new FlipkartLoginPage();
		
		
		flipkartLoginPageObject.fromHometoLoginPage(dict.get("applicationURL"));
		flipkartLoginPageObject.login(dict.get("UserId"),dict.get("Password"));
		
		
		/*excelRead=new ExcelUtility(System.getProperty("user.dir")+"\\ReadExcel.xlsx");
		System.out.println(excelRead.getRowCount());
		 CSVUtility writeToCSV=new CSVUtility("number,message");
		 writeToCSV.closeCSVUtility();*/
		
		
	}
	
}
