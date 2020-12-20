package tests;

import com.app.screens.*;
import com.app.screens.SignInGoogleAccounts;
import core.utils.PropertyLoader;
import core.utils.web_driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.junit.Assert.*;


public class SignInGoogleAccountsScreenClass {

    private Google googleScreen;
    private SignInGoogleAccounts signInGoogleAccountsScreen;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new DriverFactory().getInstance();
        googleScreen = new Google(driver);
        signInGoogleAccountsScreen = new SignInGoogleAccounts(driver);
    }

    @Test(description = "Launch Sign in - Google Accounts screen")
    public void openSignInGoogleAccountsScreen(){
        googleScreen.openScreen().Sign_in.click();
        assertTrue(signInGoogleAccountsScreen.waitIsScreenLoaded());
    }

    @Test(description = "Check title of Sign in - Google Accounts screen",dependsOnMethods={"openSignInGoogleAccountsScreen"})
    public void checkTitleOfSignInGoogleAccountsScreen(){
        assertEquals("Sign in - Google Accounts", signInGoogleAccountsScreen.getCurrentTitle());
    }

    @Test(description = "Check url of Sign in - Google Accounts screen",dependsOnMethods={"openSignInGoogleAccountsScreen"})
    public void checkUrlOfSignInGoogleAccountsScreen(){
        assertTrue(signInGoogleAccountsScreen.getCurrentUrl().
                contains(PropertyLoader.getProperty("url.Google.Accounts")));
    }

    @AfterClass
    public void closeApplication(){
        driver.quit();
        driver = null;
    }
}