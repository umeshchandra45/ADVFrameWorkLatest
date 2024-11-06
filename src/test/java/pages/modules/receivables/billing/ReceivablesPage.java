package pages.modules.receivables.billing;

import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pages.AbstractPage;
import support.StaticConstants;
import support.exceptions.CustomTestException;

public class ReceivablesPage extends AbstractPage {
	// Module Xpaths

	@FindBy(id = "clusters-right-nav")
	private WebElement rightclick;
	@FindBy(xpath = "//div[@class='flat-tabs-item' and .//a[text()='Receivables']]")
	private WebElement receivables;

	// Billing
	@FindBy(xpath = "//div[@id='itemNode_receivables_billing' or @title='Billing']")
	private WebElement billing;

	// Tasks Menu
	@FindBy(xpath = "//div[@id='pt1:_FOr1:1:_FONSr2:0:_FOTsdi__TransactionsWorkArea_itemNode__FndTasksList::ti' or @title='Tasks']")
	private WebElement tasks;

	@FindBy(xpath = "//a[@id='pt1:_FOr1:1:_FONSr2:0:_FOTRaT:0:RAtl7' or text()='Create Customer']")
	private WebElement taskMenuCustomer;

	// Customer Creation
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r1:0:inputText123::content']")
	private WebElement customerName;

	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r1:0:inputText31::content']")
	private WebElement dunsNO;

	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r1:0:inputText23::content']")
	private WebElement taxPayerIdentificationNO;

	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r2:0:inputText2::content']")
	private WebElement accountDescription;

	@FindBy(xpath = "//select[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r2:0:selectOneChoice1::content']")
	private WebElement accountType;

	@FindBy(xpath = "//select[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r2:0:selectOneChoice2::content']")
	private WebElement customerClass;

	@FindBy(xpath = "//span[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r3:0:setIdLovId::cntnrSpan']")
	private WebElement accountAddressSet;

	@FindBy(xpath = "//a[@id=\"pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r3:0:setIdLovId::dropdownPopup::popupsearch\" or text()='Search...']")
	private WebElement accountAddressSearch;

	@FindBy(xpath = "//input[@aria-label=\" Reference Data Set Code\"]")
	private WebElement referenceDataSetCode;

	@FindBy(xpath = "//button[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r3:0:setIdLovId::_afrLovInternalQueryId::search' or text()='Search']")
	private WebElement referenceDataCodeSearchBtn;

	@FindBy(xpath = "//div[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r3:0:setIdLovId_afrLovInternalTableId::db']")
	private WebElement accountAddressSelection;

	@FindBy(xpath = "//button[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r3:0:setIdLovId::lovDialogId::ok']")
	private WebElement accountAddressOkButton;

	// Address
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r3:0:dynam1:0:dynam1:0:s2:i1:0:inputText2::content']")
	private WebElement addressLineOne;

	@FindBy(xpath = "//a[@title='Postal Code']")
	private WebElement postalCode;

	@FindBy(xpath = "//a[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r3:0:dynam1:0:dynam1:0:s2:i1:4:inputComboboxListOfValues4::dropdownPopup::popupsearch' or text()='Search']")
	private WebElement addressSearch;

	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r3:0:dynam1:0:dynam1:0:s2:i1:4:inputComboboxListOfValues4::_afrLovInternalQueryId:value00::content']")
	private WebElement postalCodeInput;

	@FindBy(xpath = "//button[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r3:0:dynam1:0:dynam1:0:s2:i1:4:inputComboboxListOfValues4::_afrLovInternalQueryId::search']")
	private WebElement postalCodeSearch;

	@FindBy(xpath = "//div[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r3:0:dynam1:0:dynam1:0:s2:i1:4:inputComboboxListOfValues4_afrLovInternalTableId::db']//table//tbody/tr[@_afrrk='0']")
	private WebElement postalCodeSelection;

	@FindBy(xpath = "//button[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:pt_r3:0:dynam1:0:dynam1:0:s2:i1:4:inputComboboxListOfValues4::lovDialogId::ok']")
	private WebElement postalCodeOkButton;

	@FindBy(xpath = "//button[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:cupanel1:cucommandButton2']")
	private WebElement saveFormButton;

	// Validate the Customer No for the Newly created Account
	@FindBy(xpath = "//span[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:2:AP1:pt_r1:0:AT1:_ATp:table1:0:commandLink2']//a[@class='xmv']//span")
	private WebElement validateCustomerNO;
	
	@FindBy(xpath="//span[@class='x2hi']//a[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:2:AP1:pt_r4:0:AT1:_ATp:table1:0:outputText61']")
	private WebElement customerSite;
	
	@FindBy(xpath="//img[@id=\"pt1:_FOr1:1:_FONSr2:0:MAnt2:3:cupanel1:sitedet:0:AT1:_ATp:create::icon\"]")
	private WebElement addAddress;
	
	@FindBy(xpath="(//td[@class='xen']//select[contains(@id, 'SiteUseCodeUpd::content')])[2]")
			
	private WebElement selectAddressShipTo;
	
	
//@FindBy(xpath="//tr[@class=\"p_AFFocused xem p_AFSelected\"]//td//span[@class=\"x2hi\"]//span[@id=\"pt1:_FOr1:1:_FONSr2:0:MAnt2:3:cupanel1:sitedet:0:AT1:_ATp:table1:0:SiteUseCodeUpd\"]")
																									
//	@FindBy(xpath="//tr[@class=\"p_AFFocused xem p_AFSelected\"]//td//span[@class=\"x2hi\"]//span//select")
	@FindBy(xpath="(//td[@class='xen']//select[contains(@id, 'SiteUseCodeUpd::content')])[1]")
	private WebElement selectAddressBillTo;
	
	@FindBy(xpath="pt1:_FOr1:1:_FONSr2:0:MAnt2:3:cupanel1:sitedet:0:AT1:_ATp:table1:0:billToSiteUseIdId::cntnr")
	private WebElement billToSite;
	
	@FindBy(xpath="//a[@class=\"x1o4 xmv\"]")
	private WebElement billToSiteSearch;
	
	
	
	@FindBy(xpath="//button[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:3:cupanel1:cucommandButton2']")
	private WebElement saveAddress;

	public ReceivablesPage(String moduleType, Map<Object, Object> objectMap) throws CustomTestException {
		try {
			PageFactory.initElements(driver, this);
			waitFor(rightclick).toBeClickable().click();
			waitFor(rightclick).toBeClickable().click();
			waitFor(rightclick).toBeClickable().click();
			moduleHandling(moduleType, objectMap);

		} catch (Exception e) {
			throw new CustomTestException("Error in LoginPage while handling login elements", e);
		}

	}

	private void moduleHandling(String moduleType, Map<Object, Object> objectMap) throws CustomTestException {

		waitFor(receivables).elementWaiter(3);
		waitFor(receivables).toBeClickable().click();

		switch (moduleType.toLowerCase()) {
		case "billing":
			navigateToBilling(objectMap);
			break;

		case "revenue":
			navigateToRevenue();
			break;

		case "accountsreceivable":
			navigateToAccountsReceivable();
			break;

		// Add more cases for other modules if needed
		default:
			throw new CustomTestException("Invalid receivables module type: " + moduleType);
		}

	}

	private void navigateToAccountsReceivable() {

	}

	private void navigateToRevenue() {
		// TODO Auto-generated method stub

	}

	private void navigateToBilling(Map<Object, Object> objectMap) {
		waitFor(billing).toBeClickable().click();
//		new WaitFunctions().
		waitFor(tasks).elementWaiter(15);
		waitFor(tasks).toBeClickable().click();
		waitFor(taskMenuCustomer).toBeClickable().click();
		try {
			createCustomer(objectMap);
		} catch (CustomTestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void createCustomer(Map<Object, Object> objectMap) throws CustomTestException {
		if (objectMap != null) {
			try {
				String customerNameStr = getValueFromMap(objectMap, "CustomerName");
				Random rand = new Random();

				// Generate a random number between 100 and 999
				int randomNumber = rand.nextInt(900) + 100;
				StaticConstants.customerName = customerNameStr + String.valueOf(randomNumber);
				System.out.println("customerName" + StaticConstants.customerName);
				waitFor(customerName).tobeEnabled().sendKeys(StaticConstants.customerName);
				waitFor(dunsNO).tobeEnabled().sendKeys(getValueFromMap(objectMap, "DUNSNo"));
				waitFor(taxPayerIdentificationNO).tobeEnabled().sendKeys(getValueFromMap(objectMap, "TaxNo"));
				waitFor(accountDescription).tobeEnabled().sendKeys(getValueFromMap(objectMap, "AccountDesc"));
				waitFor(accountType).tobeEnabled();
				// Create an instance of the Select class
				Select select = new Select(accountType);
				// Select option by index (0-based index)
				select.selectByIndex(Integer.parseInt((String) objectMap.get("AccountType")));

				// Create an instance of the Select class
				Select selectCustomerClass = new Select(customerClass);
				// Select option by index (0-based index)
				selectCustomerClass.selectByIndex(Integer.parseInt((String) objectMap.get("CustomerClass")));

				waitFor(accountAddressSet).toBeClickable().click();
				waitFor(accountAddressSearch).toBeClickable().click();
				waitFor(referenceDataSetCode).tobeEnabled().sendKeys(getValueFromMap(objectMap, "DataSetCode"));
				waitFor(referenceDataCodeSearchBtn).toBeClickable().click();
				Thread.sleep(1000);
				waitFor(accountAddressSelection).toBeClickable().click();
				Thread.sleep(1000);
				waitFor(accountAddressOkButton).toBeClickable().click();
				waitFor(addressLineOne).tobeEnabled().sendKeys(getValueFromMap(objectMap, "AddressLineOne"));
		        
				waitFor(postalCode).elementWaiter(15);
				waitFor(postalCode).toBeClickable().click();
				
				waitFor(addressSearch).toBeClickable().click();

				waitFor(postalCodeInput).tobeEnabled().sendKeys(getValueFromMap(objectMap, "PostalCodeSearch"));
				waitFor(postalCodeSearch).toBeClickable().click();

				Thread.sleep(500);
				waitFor(postalCodeSelection).toBeClickable().click();
				Thread.sleep(500);
				waitFor(postalCodeOkButton).toBeClickable().click();
				waitFor(saveFormButton).elementWaiter(2);
//				((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView(true);", saveFormButton);
				waitFor(saveFormButton).toBeClickable().click();

				
				createAndValidateBillToShipToCustomer(customerNameStr,objectMap);
				

			} catch (Exception e) {
				throw new CustomTestException("Unable to Create the Account in Accounts Receivbles", e);
			}

		}

	}
	
	private void createAndValidateBillToShipToCustomer(String customerName,Map<Object, Object> objectMap) throws CustomTestException {
		if (customerName != null) {
			try {

				waitFor(validateCustomerNO).elementWaiter(10);
				WebElement customerWebElement = waitFor(validateCustomerNO).toBeDisplayed();
				String validateCustomerCreation = customerWebElement.getText();
				Assert.assertEquals(StaticConstants.customerName, validateCustomerCreation);
				
			//Customer Site click and Validate
				waitFor(customerSite).toBeClickable().click();
				waitFor(addAddress).toBeClickable().click();
				waitFor(selectAddressBillTo).tobeEnabled();
				
				// Create an instance of the Select class
				Select select = new Select(selectAddressBillTo);
				// Select option by index (0-based index)
				select.selectByIndex(Integer.parseInt((String) objectMap.get("BillTo")));
				
				Thread.sleep(1000);
				waitFor(addAddress).toBeClickable().click();
				waitFor(selectAddressShipTo).tobeEnabled();
				
//				Select selAddressShipTo = new Select(selectAddressShipTo);
//				selAddressShipTo.selectByIndex(Integer.parseInt((String) objectMap.get("ShipTo")));
//				// Get the currently selected option text
//		        String selectedText = selAddressShipTo.getFirstSelectedOption().getText();
//		        if(selectedText.equalsIgnoreCase("")) {
//		        	waitFor(billToSite).toBeClickable().click();
//		        	waitFor(billToSiteSearch).toBeClickable().click();
//		        	
//		        }
				
				waitFor(saveAddress).toBeClickable().click();
				
				
				
				
				

			} catch (Exception e) {
				throw new CustomTestException("Unable to save the Account", e);
			}

		}

	}

}
