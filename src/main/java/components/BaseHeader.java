package components;

import common.AbsCommon;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.WaitTools;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BaseHeader extends AbsCommon {

    public BaseHeader (WebDriver driver){
        super(driver);
    }


}
