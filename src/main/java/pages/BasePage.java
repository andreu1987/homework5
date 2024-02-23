package pages;

import common.AbsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.WaitTools;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BasePage extends AbsCommon {

    public BasePage (WebDriver driver){
        super(driver);
    }

    // метод ждем когда появится элемент
    public void waitVisibility(By elementBy){
       wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }


}
