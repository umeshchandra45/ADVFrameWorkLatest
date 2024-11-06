package testRunner;

import java.util.Arrays;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import tests.LoginTest;
import tests.receivables.ReceivablesBillingTest;

public class MultipleMainMethodsTestRunner {

	public static void main2(String browser) {
		TestNG testng = new TestNG();
		XmlTest xmlTest = new XmlTest();
		xmlTest.setName("Sample Test");
		xmlTest.addParameter("browser", "edge");
		xmlTest.setClasses(Arrays.asList(new XmlClass(ReceivablesBillingTest.class)));
		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName("Sample Suite1");
		xmlTest.setSuite(xmlSuite);
		xmlSuite.setTests(Arrays.asList(xmlTest));
		testng.setXmlSuites(Arrays.asList(xmlSuite));
		testng.run();
	}

	public static void main(String browser) {
		TestNG testng = new TestNG();
		XmlTest xmlTest = new XmlTest();
		xmlTest.setName("Sample Test");
		xmlTest.addParameter("browser", "chrome");
		xmlTest.setClasses(Arrays.asList(new XmlClass(ReceivablesBillingTest.class)));
		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName("Sample Suite2");
		xmlTest.setSuite(xmlSuite);
		xmlSuite.setTests(Arrays.asList(xmlTest));
		testng.setXmlSuites(Arrays.asList(xmlSuite));
		testng.run();
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Called by JVM.. Default main()");
		main3("edge");
//		main2("chrome");
//		main("edge");
	}

	public static void main3(String browserType) {
		TestNG testng = new TestNG();
		XmlTest xmlTest = new XmlTest();
//		xmlTest.setName("Sample Test");
		xmlTest.addParameter("browser", browserType);
		xmlTest.setClasses(Arrays.asList(new XmlClass(LoginTest.class)));
		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName("Sample Suite3");
		xmlTest.setSuite(xmlSuite);
		xmlSuite.setTests(Arrays.asList(xmlTest));
		testng.setXmlSuites(Arrays.asList(xmlSuite));
		testng.run();
	}

}
