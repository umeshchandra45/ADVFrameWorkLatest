package pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import extentreports.ExtentTestManager;
import support.exceptions.CustomTestException;

public class LoginPage extends AbstractPage {
	

	@FindBy(id = "userid")
	private WebElement input_user;

	@FindBy(id = "password")
	private WebElement input_password;

	@FindBy(id = "btnActive")
	private WebElement button_signIn;

	@FindBy(xpath = "//a[text()='You have a new home page!']")
	private WebElement text_homePage;
	
	@FindBy(xpath="//div[@id='pt1:_UISpgl52u']")
	private WebElement homeButton;
	
//	ExtentTest test;
	

	public LoginPage(Map<Object, Object> objectMap) throws CustomTestException  {
		try {
		PageFactory.initElements(driver, this);
//		this.test=test;
		waitFor(input_user).elementWaiter(2);
		waitFor(input_password).elementWaiter(2);
		setLoginID(objectMap);
		setPassword(objectMap);
		clickSignInButton();
		clickHomeButton();
		
		writeExcel();
		
		}
		catch(Exception e) {
			throw new CustomTestException("Error in LoginPage while handling login elements", e);			
		}

	}

	private void writeExcel() {
		// TODO Auto-generated method stub
		
	}

	private void clickHomeButton() {
		waitFor(homeButton).elementWaiter(3);
		waitFor(homeButton).toBeClickable().click();
		
	}

	public void setLoginID(Map<Object, Object> userData) {
		ExtentTestManager.getTest().log(LogStatus.PASS,  "Login Id Entered");
//		test.info("Login Id Entered");
		if (userData != null) {
			String loginData = (String) userData.get("username");
			input_user.sendKeys(loginData);
		}

	}

	public void setPassword(Map<Object, Object> userData) {
		ExtentTestManager.getTest().log(LogStatus.PASS,  "Password Entered");
//		test.info("Password Entered");
		if (userData != null) {
			String loginData = (String) userData.get("password");
			input_password.sendKeys(loginData);
		}

	}

	public void clickSignInButton() {
		ExtentTestManager.getTest().log(LogStatus.PASS,  "Clicked on Login Button");
//		test.info("Clicked on Login Button");
		button_signIn.click();

	}
	
	

}
