package tests.receivables;

import java.io.File;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import extentreports.ExtentTestManager;
import listeners.EventListener;
import pages.LoginPage;
import pages.modules.receivables.billing.ReceivablesPage;
import steps.WebDriverManager;
import support.ExcelUtilties;
import support.exceptions.CustomTestException;
@Listeners(EventListener.class)
public class ReceivablesBillingTest extends WebDriverManager {
	public static String customerPath = System.getProperty("user.dir") + "/src/test/resources/TestData/ReceivablesTestData/UserNamePassword.xlsx";
	
	

	 @Test(dataProvider = "custData",dataProviderClass = ReceivablesBillingTest.class,invocationCount = 1)
	    public void testBillingModule(Map<Object, Object> objectMap,ITestResult iTestResult) {
		 
		 try {
			 ExtentTestManager.startTest(this.getClass().getName());
			 ExtentTestManager.getTest().log(LogStatus.INFO, /* "Test case started..." + */ this.getClass().getTypeName());
			
			 new LoginPage(objectMap);
			new ReceivablesPage("Billing",objectMap);
			
			
		} catch (CustomTestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		 finally {
//			 ExtentTestManager.endTest();
//		}
		
	    }
	 
	 
	 
	 @DataProvider(name = "custData")
		public static Object[][] customerData() throws Exception {
		 System.out.println("customerPath"+customerPath);
			File filePath = new File(customerPath);
			Object[][] testObjArray = ExcelUtilties.getTestDataMap(filePath, "Customer");
			return testObjArray;
		}
	 
	
	 
	 
}
