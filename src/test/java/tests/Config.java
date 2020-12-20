package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class Config {

    @BeforeSuite
    public void testBeforeSuite() {
        System.out.println("start suite...");
    }

    @AfterSuite
    public void testAfterSuite() {
        System.out.println("stop suite...");
    }
}