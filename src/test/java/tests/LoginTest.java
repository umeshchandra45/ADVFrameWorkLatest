package tests;

import java.io.File;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import extentreports.ExtentTestManager;
import pages.LoginPage;
import steps.WebDriverManager;
import support.ExcelUtilties;
import support.exceptions.CustomTestException;

public class LoginTest extends WebDriverManager {
	public static String securityPath = System.getProperty("user.dir") + "/src/test/resources/TestData/UserNamePassword.xlsx";

	@Test( dataProvider = "loginData",dataProviderClass = LoginTest.class,groups = {"Regression"})
	public void testLogin(Map<Object, Object> objectMap) {
//		System.out.println("TestNG.getDefault().getGroups()"+TestNG.getGroups());

//        ExtentTest extentTest=new ExtentTest("Login Test Case","Login Test Case");
		
		ExtentTestManager.startTest(this.getClass().getName());
		ExtentTestManager.getTest().log(LogStatus.INFO, /* "Test case started..." + */ this.getClass().getTypeName());
		try {
			new LoginPage(objectMap);
		} catch (CustomTestException e) {		
			e.printStackTrace();
		}

	}
	
	@DataProvider(name = "loginData")
	public static Object[][] securityLoginData() throws Exception {
		File filePath = new File(securityPath);
		Object[][] testObjArray = ExcelUtilties.getTestDataMap(filePath, "LoginCredsNew");

		return testObjArray;
	}


	
	
}
