package core.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Listener implements ITestListener {

    @Override
    public void onFinish(ITestContext Result) {

    }

    @Override
    public void onStart(ITestContext Result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

    }

    @Override
    public void onTestFailure(ITestResult Result) {
        System.out.println("test case FAILED: " + Result.getName() + " [" + DateClass.transformTime(Result.getEndMillis()) + "]");
    }

    @Override
    public void onTestSkipped(ITestResult Result) {
        System.out.println("test case SKIPPED: " + Result.getName() + " [" + DateClass.transformTime(Result.getEndMillis()) + "]");
    }

    @Override
    public void onTestStart(ITestResult Result) {

    }

    @Override
    public void onTestSuccess(ITestResult Result) {
        System.out.println("test case PASSED: " + Result.getName() + " [" + DateClass.transformTime(Result.getEndMillis()) + "]");
    }

    public static class DateClass{
        public static String transformTime(long millis){
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(millis);
            return new SimpleDateFormat("HH:mm:ss:SSS").format(cal.getTime());
        }
    }
}