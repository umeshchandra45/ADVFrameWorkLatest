package support;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringDecorator;

import listeners.EventListener;

public class DriverSupport extends EventFiringDecorator<WebDriver> {
	private static WebDriver webdriver;

	public static final String defaultDriver = "";
	public static final String defaultHeadLess = "false";

	public static WebDriver getDriver(String browser) {
		String driverType="";
		String browserType = System.getProperty("Driver", defaultDriver);
		if(!browserType.isEmpty())
		{
			String[] browserArray = browserType.split(",");
			 for(String strBrowser: browserArray) {
				 if(strBrowser.equalsIgnoreCase(browser)) {
					 driverType=browser;
				 }
				 
			 }
		}
		else
		{
			driverType=browser;
		}
		 
		System.out.println("driverType" + driverType);
		
		String headlessStr = System.getProperty("headless", defaultHeadLess);
//		System.out.println("headlessStr" + headlessStr);

		
		switch (driverType) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();

			if (headlessStr.equalsIgnoreCase("true")) {
				chromeOptions.addArguments("--headless");

			}

			// Add argument to disable automation control
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

			// Set user preferences to disable the save password prompt
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("password_manager_enabled", false);
			chromeOptions.setExperimentalOption("prefs", prefs);

			webdriver = new EventFiringDecorator<WebDriver>(new EventListener())
					.decorate(new ChromeDriver(chromeOptions));

			return webdriver;

		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();

			if (headlessStr.equalsIgnoreCase("true")) {
				firefoxOptions.addArguments("--headless");
			}
			
			
			// Set user preferences to disable the save password prompt
		    FirefoxProfile profile = new FirefoxProfile();
		    profile.setPreference("signon.rememberSignons", false); // Disable the save password prompt
		    profile.setPreference("signon.autofillForms", false);   // Disable autofill for forms
		    profile.setPreference("signon.storeWhenAutocompleteOff", false); // Disable saving credentials on autocomplete
		    profile.setPreference("credentials_enable_service", false); // Similar to Chrome

		    // Apply the profile to FirefoxOptions
		    firefoxOptions.setProfile(profile);
			
			
			webdriver = new EventFiringDecorator<WebDriver>(new EventListener())
					.decorate(new FirefoxDriver(firefoxOptions));

			return webdriver;
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			if (headlessStr.equalsIgnoreCase("true")) {
				edgeOptions.addArguments("--headless");
			}
			
			// Disable the "Controlled by automated test software" notification
			edgeOptions.setExperimentalOption("useAutomationExtension", false);
			edgeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

			// Set user preferences to disable the save password prompt
			Map<String, Object> prefsEdge = new HashMap<>();
			prefsEdge.put("credentials_enable_service", false);  // Disable password save prompt
			prefsEdge.put("profile.password_manager_enabled", false); // Disable password manager
			edgeOptions.setExperimentalOption("prefs", prefsEdge);


			webdriver = new EventFiringDecorator<WebDriver>(new EventListener()).decorate(new EdgeDriver(edgeOptions));

			return webdriver;

		}

		return webdriver;

	}

}
