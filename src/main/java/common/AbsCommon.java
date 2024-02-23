package common;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.WaitTools;

import java.time.Duration;

public abstract class AbsCommon {
    protected WebDriver driver;
    protected WaitTools waitTools;
    protected WebDriverWait wait;
    protected Actions actions;
    //protected Faker faker;

    public AbsCommon(WebDriver driver){
        this.driver = driver;
        waitTools = new WaitTools(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        //this.faker = new Faker();
        PageFactory.initElements(driver,this);

    }

}
