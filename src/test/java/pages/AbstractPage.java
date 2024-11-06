package pages;

import java.io.File;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import steps.WebDriverManager;
import support.WaitFunctions;

public class AbstractPage extends WebDriverManager{
	
	public static final Logger LOG = LoggerFactory.getLogger(AbstractPage.class);
    protected static WebDriver driver ;
    private WebDriverWait wait;
    private WebElement webElement;
    private Duration waitTimeout = Duration.ofSeconds(15);
//    public static ExtentTest test;
//    public static ExtentReports extent;

    public AbstractPage() {

        AbstractPage.driver = WebDriverManager.getWebDriver();
    }

    protected WaitFunctions waitFor(WebElement webElement) {
        return new WaitFunctions(driver, webElement);
    }
    protected WaitFunctions waitFor(File file) {
        return new WaitFunctions(driver,file);
    }

    protected WaitFunctions waiting() {
        return new WaitFunctions(driver);
    }
    public void navigateToPreviousPage(){
        driver.navigate().back();
        }
    
    public static String getValueFromMap(Map<Object, Object> map, Object key) throws Exception {
		if (map == null || key == null) {
			throw new IllegalArgumentException("Map or Key cannot be null.");
		}

		if (map.containsKey(key)) {
			return (String) map.get(key);
		} else {
			throw new Exception("Key '" + key + "' not found in the map.");
		}
	}

}
