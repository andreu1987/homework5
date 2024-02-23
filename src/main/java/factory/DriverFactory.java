package factory;

import exceptions.BrowserNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private String browserName = System.getProperty("browser.name");

    public WebDriver create() {
        browserName = browserName.toLowerCase();

        IDriverSettings settings = null;

        switch (browserName){
            case "chrome": {
                settings = new ChromeDriverSettings();
                return new ChromeDriver((ChromeOptions) settings.settings());
            }
            case "firefox":{
                settings = new FirefoxDriverSettings();
                return new FirefoxDriver((FirefoxOptions) settings.settings());
            }
        }
        throw new BrowserNotSupportedException(browserName);
    }
}
