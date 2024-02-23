package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeDriverSettings implements IDriverSettings {

    {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    public AbstractDriverOptions settings(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--homepage=about:blank");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--start-maximized");
        return chromeOptions;
    }

}
