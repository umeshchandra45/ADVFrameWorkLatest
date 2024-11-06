package listeners;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
//import com.relevantcodes.extentreports.LogStatus;
//import extentReport.ExtentManager;
//import extentReport.ExtentTestManager;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extentreports.ExtentSetUP;
import steps.WebDriverManager;
import support.ExcelUtilties;
import support.StaticConstants;

import com.relevantcodes.extentreports.LogStatus;

import extentreports.ExtentTestManager;
import extentreports.ExtentManager;

public class EventListener implements WebDriverListener, ITestListener {
	private static final int SCALE_FACTOR = 3;
	Logger loggerFactory = LoggerFactory.getLogger(EventListener.class);
	String destination = "";
	
	public static ExtentTest test;
    public static ExtentReports extent;

	@Override
	public void beforeClick(WebElement element) {
//		System.out.println("BeforeClick is Calling");

            try {
                File source =  ((TakesScreenshot) WebDriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
//                destination=System.getProperty("user.dir")+"/Screenshot"+System.currentTimeMillis()+".png";
//                destination = "test-output/ExtentReport/"+ "Run_" + System.currentTimeMillis()  +".png";
                String reportDate=ExtentManager.returnDate();
                destination = "test-output/ExtentReport/"+ "Run_" + reportDate + "/"+"Screenshot"+".png" ;
                File dest=new File(destination);
                System.out.println("source"+source);
                System.out.println("destination"+destination);
//                FileUtils.copyFile(source,dest);
                String fileAbolutPath=dest.getAbsolutePath();
//                ExtentTestManager.attacheScreenshot(fileAbolutPath);

                ExtentTestManager.getTest().log(LogStatus.valueOf("PASS"),"SnapShot"+ExtentTestManager.attacheScreenshot(fileAbolutPath));
                ExtentManager.getReporter().flush();
            }catch (Exception e){
                ExtentTestManager.write(LogStatus.valueOf("FAIL"),destination);
                ExtentManager.getReporter().flush();
                e.printStackTrace();
            }

	}

//
	private static byte[] getScaledScreenshot() {
		try {
			byte[] screenshot = ((TakesScreenshot) WebDriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
			ByteArrayInputStream in = new ByteArrayInputStream(screenshot);
			BufferedImage img = ImageIO.read(in);
			int height = img.getHeight() / EventListener.SCALE_FACTOR;
			int width = img.getWidth() / EventListener.SCALE_FACTOR;
			Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage imageBuff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0, 0, 0), null);
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			ImageIO.write(imageBuff, "jpg", buffer);
			screenshot = buffer.toByteArray();
			return screenshot;
		} catch (Exception e) {
			return new byte[0];
		}
	}

//    
////    @Override
////    public void beforeClick(WebElement element) {
////    	// TODO Auto-generated method stub
////    	
////    }
//
//    @Override
//    public void onFinish(ITestContext context) {
////        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
//
//    }
	
	//OnTestFailure By Namashivaya G
//	@Override
//	public void onTestFailure(ITestResult result) {
//		// System.out.println("BeforeClick is Calling");
//		if (result.getStatus() == ITestResult.FAILURE) {
//			try {
//				File source = ((TakesScreenshot) WebDriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
////	           destination=System.getProperty("user.dir")+"/Screenshot"+System.currentTimeMillis()+".png";
////	           destination = "test-output/ExtentReport/"+ "Run_" + System.currentTimeMillis()  +".png";
//				String reportDate = ExtentManager.returnDate();
//				destination = "test-output/ExtentReport/" + "Run_" + reportDate + "/" + "Screenshot" + ".png";
//				File dest = new File(destination);
//				System.out.println("source" + source);
//				System.out.println("destination" + destination);
////	           FileUtils.copyFile(source,dest);
//				String fileAbolutPath = dest.getAbsolutePath();
////	           ExtentTestManager.attacheScreenshot(fileAbolutPath);
//
//				ExtentTestManager.getTest().log(LogStatus.valueOf("PASS"),
//						"SnapShot" + ExtentTestManager.attacheScreenshot(fileAbolutPath));
//				ExtentManager.getReporter().flush();
//			} catch (Exception e) {
//				ExtentTestManager.write(LogStatus.valueOf("FAIL"), destination);
//				ExtentManager.getReporter().flush();
//				e.printStackTrace();
//
//			}
//		}
//	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
//		test.log(Status.PASS, "Test case : " + result.getMethod().getMethodName() + " is Passed");
//	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
//	    Date date = new Date();
//	    String actualDate = simpleDateFormat.format(date);
//
//	    test.log(Status.FAIL, "Test case: " + result.getMethod().getMethodName() + " has failed.");
//	    test.log(Status.FAIL, result.getThrowable());
//
//	    File src = ((TakesScreenshot) WebDriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
//	    String screenShotPath = "./Report/ScreenShots/ScreenShot_" + actualDate + ".jpeg"; // Relative path
//	    File dest = new File(System.getProperty("user.dir") + "/Report/ScreenShots/ScreenShot_" + actualDate + ".jpeg");
//
//	    try {
//	        new File(System.getProperty("user.dir") + "/Report/ScreenShots").mkdirs();
//	        FileUtils.copyFile(src, dest);
//	        
//	        if (dest.exists()) {
//	            test.addScreenCaptureFromPath(screenShotPath, "Screenshot of failure"); // Using relative path
//	        } else {
//	            test.log(Status.FAIL, "Screenshot file not found at: " + screenShotPath);
//	        }
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
		String className = result.getTestClass().getName();
		String methodName = result.getMethod().getMethodName();
		System.out.println("Test succeeded in class: " + className + ", method: " + methodName);
		String customerDataFilePath = System.getProperty("user.dir") + "/src/test/resources/TestData/ReceivablesTestData/WriteCustomerData.xlsx";
		if (methodName.equalsIgnoreCase("testBillingModule")) {
			int currentInvocation = result.getMethod().getCurrentInvocationCount();
			if (currentInvocation == 1) {
				try {
					ExcelUtilties.writeData("CustomerData", customerDataFilePath, StaticConstants.customerName, 0, 1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				try {
					ExcelUtilties.writeData("CustomerData", customerDataFilePath, StaticConstants.customerName, 1, 1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}
	
	@Override
	public void onTestStart(ITestResult result) {
//		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	

	@Override
	public void onTestFailure(ITestResult result) {
//	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
//	    Date date = new Date();
//	    String actualDate = simpleDateFormat.format(date);
//
//	    test.log(Status.FAIL, "Test case: " + result.getMethod().getMethodName() + " has failed.");
//	    test.log(Status.FAIL, result.getThrowable());
//
//	    File src = ((TakesScreenshot) WebDriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
//	    String screenShotPath = "./Report/ScreenShots/ScreenShot_" + actualDate + ".jpeg"; // Relative path
//	    File dest = new File(System.getProperty("user.dir") + "/Report/ScreenShots/ScreenShot_" + actualDate + ".jpeg");
//
//	    try {
//	        new File(System.getProperty("user.dir") + "/Report/ScreenShots").mkdirs();
//	        FileUtils.copyFile(src, dest);
//	        
//	        if (dest.exists()) {
//	            test.addScreenCaptureFromPath(screenShotPath, "Screenshot of failure"); // Using relative path
//	        } else {
//	            test.log(Status.FAIL, "Screenshot file not found at: " + screenShotPath);
//	        }
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        
//	    }
//
//	    extent.flush();
	}


	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		// setup method call
//		extent = ExtentSetUP.setUpExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		// close extent
//		extent.flush();
	}

}
