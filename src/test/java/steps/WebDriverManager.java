package steps;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import extentreports.ExtentManager;
import extentreports.ExtentTestManager;
import support.DriverSupport;
import support.LogFileCleaner;
import support.PropertiesReader;

public class WebDriverManager {

	public static final String defLocale = "de_AT";
	public   WebDriver webdriver;
	protected static ThreadLocal<WebDriver> threadLocale;

	
//	@BeforeClass
//	public void beforeClass() {
//		threadLocale = new ThreadLocal<WebDriver>();
//		webdriver = DriverSupport.getDriver();
//		threadLocale.set(webdriver);
//		threadLocale.get().manage().window().maximize();
//		homePage();
//
//	}
	
	@BeforeSuite
	public void beforeSuite() {
		LogFileCleaner.deleteLogFiles();
	}
	
//	@Parameters({"browser"})
//	@BeforeMethod
//	//@org.testng.annotations.Optional("chrome")  if we do not pass browser type from the Test Runner file by default 
//	//it will automatically take the browser as Chrome
//	public void beforeMethod(@org.testng.annotations.Optional("chrome")String browser) {
//		System.out.println("browser"+browser);
//		threadLocale = new ThreadLocal<WebDriver>();
//		webdriver = DriverSupport.getDriver(browser);
//		threadLocale.set(webdriver);		
//		threadLocale.get().manage().window().maximize();
//		homePage();
//
//	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void beforeMethod(@org.testng.annotations.Optional("chrome") String browser) {
	    System.out.println("Executing beforeMethod in WebDriverManager with browser: " + browser);
	    threadLocale = new ThreadLocal<>();
	    webdriver = DriverSupport.getDriver(browser);
	    threadLocale.set(webdriver);
	    if (threadLocale.get() != null) {
	        threadLocale.get().manage().window().maximize();
	        homePage();
	    } else {
	        System.out.println("WebDriver was not initialized!");
	    }
	}

	

	private void homePage() {
		threadLocale.get().navigate().to("https://fa-etap-dev21-saasfademo1.ds-fa.oraclepdemos.com/");
	}

	private String getHomePage() {
		System.out.println("getRequiredSystemProperty" + getRequiredSystemProperty("locale"));
		return PropertiesReader.getKey(getRequiredSystemProperty("locale"));
	}

	public static String getRequiredSystemProperty(String name) {
		
		try {
			System.out.println("System.getProperty(name)"+System.getProperty(name));
			if (System.getProperty(name)==null||System.getProperty(name).isEmpty()) {

					return defLocale;
			}
			else {
			
				return Optional.ofNullable(System.getProperty(name)).orElseThrow(() -> new IllegalArgumentException(
						String.format("Required system property '%s' is missing", name)));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
//		if (!System.getProperty(name).isEmpty()&&System.getProperty(name)!=null) {
//			
//
//		} else {
//			try {
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return defLocale;

	}

    @AfterMethod
    public void afterMethod(){
//    	if (threadLocale != null) {
//			threadLocale.get().quit();
//		}
        System.out.println("after method");
        String fileName = "ExtentOutput.html";
        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
        ExtentManager.getReporter().flush();
        File source = new File(ExtentManager.folderPath() + fileName);
        File dest = new File("test-output/JenkinsReport/"+fileName);
        try {
            FileUtils.copyFile(source,dest);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("extent report end");

    }
	public static WebDriver getWebDriver() {
		if (threadLocale != null) {
			System.out.println("threadLocale.get()"+threadLocale.get());
			return threadLocale.get();
		}
		return null;

	}
	

}
