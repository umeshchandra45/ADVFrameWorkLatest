package testRunner;

import org.testng.TestNG;

import tests.LoginTest;
import tests.receivables.ReceivablesBillingTest;

public class MultipleTestRunner {
    public static void main(String[] args) {
        // Initialize TestNG
        TestNG testng = new TestNG();

        // Add classes you want to run
        testng.setTestClasses(new Class[] {LoginTest.class });


        // Run the tests
        testng.run();
    }
}
