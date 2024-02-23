package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropDownList extends BaseHeader {
    public DropDownList(WebDriver driver){
        super(driver);
    }

    //Ожидание элемента Авторизованного имени
    public DropDownList implicitlyWaitButtonName(){
        WebElement waitButtonName = driver.findElement(By.xpath("//*[@class='sc-199a3eq-0 fJMWHf']"));
        wait.until(ExpectedConditions.visibilityOf(waitButtonName));
        return  this;
    }

    // Клик по элементу "Авторизованного имени"
    public DropDownList clickButtonName(){
        driver.findElement(By.xpath("//*[@class='sc-199a3eq-0 fJMWHf']")).click();
        return this;
    }

    //Ожидание элемента "Мой профиль"
    public DropDownList implicitlyWaitButtonMyProfile(){
        WebElement buttonMyProfile = driver.findElement(By.xpath("//a[contains(text(),'Мой профиль')]"));
        wait.until(ExpectedConditions.visibilityOf(buttonMyProfile));
        return this;
    }

    //Кликнуть по элементу "Мой профиль"
    public DropDownList clickButtonMyProfile(){
        WebElement clickElementButtonMyProfile = driver.findElement
                (By.xpath("//a[contains(text(),'Мой профиль')]"));
        clickElementButtonMyProfile.click();
        return this;
    }


}
