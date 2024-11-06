package extentreports;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManagerNew {
    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports getInstance() {
        if (extentReports == null) {
        	SimpleDateFormat simpleDateformat=new SimpleDateFormat("dd-mm-yyyy HH-MM-SS");
    		Date date =new Date();
    		String actualDate=simpleDateformat.format(date);
            extentReports = new ExtentReports();
           
            String filePath=System.getProperty("user.dir")+"/Report/ExecutionReport_"+actualDate+".html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filePath);
            extentReports.attachReporter(sparkReporter);
            sparkReporter.config().setDocumentTitle("DocumentTitle");
    		sparkReporter.config().setTheme(Theme.DARK);
    		sparkReporter.config().setReportName("ErrorTestMotorCycle");
        }
        return extentReports;
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static void flush() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
