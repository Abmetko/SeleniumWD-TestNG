package tests;

import com.app.screens.*;
import core.utils.DataExtractorTransformer;
import core.utils.PropertyLoader;
import core.utils.web_driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import static org.junit.Assert.*;


public class GooglePodcastsScreenClass {

    private Google googleScreen;
    private GooglePodcasts googlePodcastsScreen;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new DriverFactory().getInstance();
        googleScreen = new Google(driver);
        googlePodcastsScreen = new GooglePodcasts(driver);
    }

    @Test(description = "Launch Google Podcasts screen")
    public void openGooglePodcastsScreen(){
        googleScreen.openScreen().Google_apps.click();
        googleScreen.switchToFrame(googleScreen.iframe);
        googleScreen.Podcasts.click();
        googleScreen.switchToDefaultContent();
        assertTrue(googlePodcastsScreen.waitIsScreenLoaded());
    }

    @Test(description = "Check title of Google Podcasts screen",dependsOnMethods={"openGooglePodcastsScreen"})
    public void checkTitleOfGooglePodcastsScreen(){
        assertEquals("Google Podcasts", googlePodcastsScreen.getCurrentTitle());
    }

    @Test(description = "Check url of of Google Podcasts screen",dependsOnMethods={"openGooglePodcastsScreen"})
    public void checkUrlOfGooglePodcastsScreen(){
        assertTrue(googlePodcastsScreen.getCurrentUrl().
                contains(PropertyLoader.getProperty("url.Google.Podcasts")));
    }

    @Test(dependsOnMethods={"checkTitleOfGooglePodcastsScreen"})
    public void checkSearchPodcast(){
        googlePodcastsScreen.inputDataInField(googlePodcastsScreen.Search_for_podcasts,"The Joe Rogan Experience");
        googlePodcastsScreen.Search.click();
        assertEquals("The Joe Rogan Experience",
                googlePodcastsScreen.searched_header.getText());
        /* post conditions */
        driver.navigate().back();
        googlePodcastsScreen.waitScreenLoaded();
    }

    @Test(description = "Check of all top podcasts are presented and can be open",dependsOnMethods = {"openGooglePodcastsScreen"})
    public void checkAllTopPodcastsArePresentedAndCanBeOpen(){
        String[] topPodcasts = {"The Joe Rogan Experience","The Daily","TED Talks Daily","Stuff You Should Know","This American Life",
                "Planet Money","7 Good Minutes Daily Self-Improvement Podcast with Clyde Lee Dennis","Wait Wait... Don't Tell Me!",
                "The Ben Shapiro Show","Radiolab","Up First"};
        List<WebElement> elements = googlePodcastsScreen.top_podcast_element;
        assertArrayEquals(topPodcasts, DataExtractorTransformer.transformListToArray(elements));
        for (WebElement i:elements) {
            i.click();
            assertEquals(topPodcasts[elements.indexOf(i)],googlePodcastsScreen.podcast_header.getText());
            driver.navigate().back();
        }
    }

    @AfterClass
    public void closeApplication(){
        driver.quit();
        driver = null;
    }
}