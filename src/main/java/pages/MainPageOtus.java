package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPageOtus extends BasePage {

    public MainPageOtus(WebDriver driver) {
        super(driver);
    }
    private String otusUrl = System.getProperty("otus.Url");
    private String email = System.getProperty("email");
    private String password = System.getProperty("password");
    private  String loginButtonLocator = "//button[text()='Войти']";


    //Вход на сайт
    public MainPageOtus goTo() {
        driver.get(otusUrl);
        return this;
    }

    //Проверка что PopupElement нету, компонента регистрации "Войдите в свой акаунт"
    public MainPageOtus thereIsNotPopupElement(){
        //WebElement popupElementCss = driver.findElement(By.cssSelector("#__PORTAL__>div"));
        Assertions.assertTrue(waitTools.WaitForCondition(ExpectedConditions.not(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#__PORTAL__>div")))),"1233");
        return this;
    }


    //Ожидание элемента кнопка войти
    public MainPageOtus implicitlyWaitButton() {
        waitVisibility(By.xpath(loginButtonLocator));
        return this;
    }

    // кликнуть по кнопки
    public MainPageOtus clickElementEnter() {
        driver.findElement(By.xpath(loginButtonLocator)).click();
        return this;
    }

    //Ожидания
    public MainPageOtus untilWait(){
        WebElement popupElementCss = driver.findElement(By.cssSelector("#__PORTAL__>div"));
        wait.until(ExpectedConditions.visibilityOf(popupElementCss));
        return this;
    }

    //Проверка PopupElement есть, компонента регистрации "Войдите в свой акаунт"
    public MainPageOtus popupElementDisplayed() {
        WebElement PopupElementCss = driver.findElement(By.cssSelector("#__PORTAL__>div"));
        Assertions.assertTrue(PopupElementCss.isDisplayed(), "PopupElement is  displayed");
        return this;
    }


    // ввод в поле email
    public MainPageOtus authorizationEmail() {
        driver.findElement(By.xpath("//div[./input[@name='email']]")).click();
        //WebElement emailInputSelector = driver.findElement(By.xpath("//div[./input[@name='email']]"));
        WebElement emailInputSelector = driver.findElement(By.cssSelector("[name = 'email']"));
        //Assertions.assertTrue(waitTools.WaitForCondition(ExpectedConditions.stalenessOf(emailInputSelector)));
        waitTools.WaitForCondition(ExpectedConditions.stalenessOf(emailInputSelector));
        //emailInputSelector.click();
        driver.findElement(By.cssSelector("[name = 'email']")).sendKeys(email);
        return this;
    }

    // ввод в поле password
    public MainPageOtus authorizationPassword() {
        driver.findElement(By.xpath("//div[./input[@type='password']]")).click();
        WebElement passwordInputSelector = driver.findElement(By.cssSelector("input[type='password']"));
        //passwordInputSelector.sendKeys(password);
        waitTools.WaitForCondition(ExpectedConditions.stalenessOf(passwordInputSelector));
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
        return this;
    }

    // кликнуть по кнопки
    public MainPageOtus clickElementEnterEnter() {
        WebElement clickElementEnterEnter = driver.findElement(By.cssSelector("#__PORTAL__ button"));
        waitTools.WaitForCondition(ExpectedConditions.stalenessOf(clickElementEnterEnter));
        driver.findElement(By.cssSelector("#__PORTAL__ button")).click();
        return this;
    }


    //Проверка что нет кнопки "Войти"
    public MainPageOtus thereIsNoButton() {
        Assertions.assertFalse(waitTools.waitNotElementPresent
                (By.xpath(loginButtonLocator)),"The button is missing");
        return this;
    }

    // Вывести в лог куки
    public MainPageOtus getCookies() {
        System.out.println(driver.manage().getCookies());
        return this;


    }


}









