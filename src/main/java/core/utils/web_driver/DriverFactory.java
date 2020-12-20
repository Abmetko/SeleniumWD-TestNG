package core.utils.web_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.Collections;
import static core.utils.PropertyLoader.getProperty;


public class DriverFactory {

    private WebDriver driver = null;

    public WebDriver getInstance() {
        if (driver != null) {
            return driver;
        }
        System.setProperty("webdriver.chrome.driver", getProperty("chromedriver.path.windows"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("start-maximized");
        options.addArguments("--lang=en-GB");
//        options.addArguments("--headless");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("--disable-notifications");
        options.addArguments("use-fake-ui-for-media-stream");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}