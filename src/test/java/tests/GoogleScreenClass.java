package tests;

import com.app.screens.*;
import core.utils.DataExtractorTransformer;
import core.utils.PropertyLoader;
import core.utils.web_driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;


public class GoogleScreenClass {

    private WebDriver driver;
    private Google googleScreen;
    private GmailEmailFromGoogleScreen gmailEmailFromGoogleScreen;

    @BeforeClass
    public void setUp(){
        driver = new DriverFactory().getInstance();
        googleScreen = new Google(driver);
        gmailEmailFromGoogleScreen = new GmailEmailFromGoogleScreen(driver);
    }

    @Test(description = "Launch Google screen")
    public void openGoogleScreen(){
        googleScreen.navigateTo(PropertyLoader.getProperty("url.Google"));
        assertTrue(googleScreen.waitIsScreenLoaded());
    }

    @Test(description = "Check title of Google screen",dependsOnMethods = {"openGoogleScreen"})
    public void checkTitle(){
        assertEquals("Google", googleScreen.getCurrentTitle());
    }

    @Test(description = "Check iframe opens after click on it",dependsOnMethods = {"checkTitle"})
    public void checkGoogleAppsIframeOpens(){
        googleScreen.openScreen().Google_apps.click();
        assertTrue(googleScreen.waitIsElementVisible(googleScreen.iframe));
    }

    @Test(description = "check that all Google elements are presented at the top",dependsOnMethods = {"checkGoogleAppsIframeOpens"})
    public void checkAllGoogleElementsArePresentedAtTheTop(){
        googleScreen.switchToFrame(googleScreen.iframe);
        String[] googleAppsTop = {"Account","Search","Maps","YouTube","Play","News","Gmail","Meet","Contacts","Drive","Calendar","Translate","Photos","Duo"};
        assertArrayEquals(googleAppsTop, DataExtractorTransformer.transformListToArray(googleScreen.iframe_top_element));
    }

    @Test(description = "check that all Google elements are presented at the bottom",dependsOnMethods = {"checkAllGoogleElementsArePresentedAtTheTop"})
    public void checkAllGoogleElementsArePresentedAtTheBottom(){
        String[] googleAppsBottom = {"Docs","Sheets","Slides","Books","Blogger","Hangouts","Keep","Jamboard","Earth","Collections","Arts and Culture","Google Ads","Podcasts"};
        assertArrayEquals(googleAppsBottom, DataExtractorTransformer.transformListToArray(googleScreen.iframe_bottom_element));
    }

    @Test
    public void checkSearchByVoice() {
        googleScreen.Search_by_voice.click();
        assertTrue(googleScreen.waitIsElementVisible(googleScreen.microphone));
    }

    @Test
    public void checkGmailEmailFromGoogleScreenOpens(){
        googleScreen.Gmail.click();
        assertTrue(gmailEmailFromGoogleScreen.waitIsScreenLoaded());
        /* post conditions */
        driver.navigate().back();
        googleScreen.waitScreenLoaded();
    }

    @AfterClass
    public void closeApplication(){
        driver.quit();
        driver = null;
    }
}