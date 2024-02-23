package pages;

import communicatMetod.ICommunicationMethod;
import data.cities.ICityData;
import dataData.english.IEnglishLevel;
import dataGender.IGender;
import dataWork.IWork;
import dataWork.Work;
import fieldData.InputFieldData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import workGraf.WorkGraf;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PersonalAccountOtus extends BasePage {
    public PersonalAccountOtus(WebDriver driver) {
        super(driver);
    }
    private String buttonSaveSelector = "[title='Сохранить и заполнить позже']";

    // Ожидания Элемента
    public PersonalAccountOtus personalWait(){
        WebElement personal = driver.findElement(By.xpath("//h3[contains(text(),'Персональные данные')]"));
        wait.until(ExpectedConditions.visibilityOf(personal));
        return this;
    }


    // Очистить поля "Имя"
    public PersonalAccountOtus addNewNameFieldsClear(InputFieldData... inputFieldData){
        for (InputFieldData fieldData : InputFieldData.values()){
            driver.findElement(By.cssSelector(String.format("input[name='%s']",
                    fieldData.getFname()))).clear();
        }
        return this;
    }

    //метод заполнения полей [Имя, имя латинице, фамилия, фамилия латинице]
    public PersonalAccountOtus addNewNameFields(InputFieldData inputFieldData,String data){
            driver.findElement(By.cssSelector(String.format("input[name='%s']",
                            inputFieldData.getFname())))
                    .sendKeys(data);
        return this;
    }

    // метод по заполнения страны и города
    public PersonalAccountOtus selectCountry(ICityData cityData){
        WebElement russiaSelectElement = driver.findElement
                (By.cssSelector("[data-slave-selector='.js-lk-cv-dependent-slave-city']"));
        russiaSelectElement.click(); ///// кликнули по элементу страна

        //нашли элемент выпадающего списка
        WebElement cityListContainer = driver.findElement
                (By.xpath("//*[@class='lk-cv-block__select-options js-custom-select-options-container']"));

        //ожидания видимости элемента список
        wait.until(ExpectedConditions.visibilityOf(cityListContainer));

        driver.findElement(By.cssSelector(String.format("[title='%s']", cityData.countriesData().getName()))).click();

        return this;

    }


    // метод по заполнению города
    public PersonalAccountOtus selectCity(ICityData cityData){

        //проверка что при выборе страны пропадет нужный атрибут
        WebElement attribute = driver.findElement(By.cssSelector("[name='city']"));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(attribute,"disabled","disabled")));

        // нашли поля город
        WebElement moscowSelectElement = driver.findElement
                (By.xpath("//*[@class='select lk-cv-block__input lk-cv-block__input_full js-lk-cv-dependent-slave-city js-lk-cv-custom-select']"));
        // ожидания поля город
        wait.until(ExpectedConditions.elementToBeClickable(moscowSelectElement));
        //кликнуть по полю город
        moscowSelectElement.click();

        // найти элемент выпадающего списка
        WebElement listSelectElement = driver.findElement
                (By.xpath("//*[@class='lk-cv-block__select-options js-custom-select-options-container']"));

        // ожидания видимости списка
        wait.until(ExpectedConditions.visibilityOf(listSelectElement));
        // Выбор города

        driver.findElement(By.cssSelector(String.format("[title='%s']", cityData.getName()))).click();

        return this;
    }


    // метод по заполнению уровн языка
    public PersonalAccountOtus selectLanguage(IEnglishLevel englishLevel){
        //Кликнуть на поле выбор английского языка
        WebElement languageSelect =
                driver.findElement(By.xpath
                        ("//*[@class='select lk-cv-block__input lk-cv-block__input_full js-lk-cv-custom-select']"));
        languageSelect.click();

        //нашли элемент выпадающего списка
        WebElement listLanguage =
                driver.findElement(By.xpath
                        ("//*[@class='lk-cv-block__select-options js-custom-select-options-container']"));
        // ожидания элемента выпадающего списка
        wait.until(ExpectedConditions.visibilityOf(languageSelect));
        // Выбор языка
        driver.findElement(By.cssSelector(String.format("[title='%s']",englishLevel.getName()))).click();

        return this;
    }


    // метод выбрать чекбокс true false
    public PersonalAccountOtus readyToMove(boolean isSelected){
        String relocate = isSelected ? "Да": "НЕТ";
        driver.findElement(By.xpath(String.format("//span[@class='radio__label'and text()='%s']",relocate))).click();

        return this;
    }


    // метод выбрать чекбокс true false формат работы
    public PersonalAccountOtus workGraf(boolean isSelected,WorkGraf...workGrafs){

        for(WorkGraf workGraf : workGrafs) {
            WebElement inputSelect = driver.findElement(By.xpath(String.format("//*[@title='%s']/..", workGraf.getName())));
            if (inputSelect.isSelected() != isSelected){
                inputSelect.click();
            }
        }
        return this;
    }


    // метод на выбор способа связи
    public PersonalAccountOtus communicationMethod(ICommunicationMethod communicationMethod){
        WebElement communicatSelect =
                driver.findElement(By.xpath
                        ("//*[@class='container__col container__col_12 container__col_middle']/descendant::div[1]"));

        // кликнуть по полю
        communicatSelect.click();
        //ожидания выпадающего списка
        WebElement listCommunicat =
                driver.findElement
                        (By.xpath("//*[@class='container__col container__col_12 container__col_middle']/descendant::div[3]"));

        wait.until(ExpectedConditions.visibilityOf(listCommunicat));
        driver.findElement(By.cssSelector(String.format("[title='%s']",communicationMethod.getName()))).click();
        return this;
    }


    // выбор связи
    public PersonalAccountOtus connection(){
        WebElement connection = driver.findElement(By.xpath("//*[@id='id_contact-0-preferable']/.."));
        connection.click();
        return this;
    }


    //выбор пола
    public PersonalAccountOtus gender(IGender gender) {
        // находим поля
        WebElement selectInputGender = driver.findElement(By.cssSelector("[id='id_gender']"));
        // кликаем на поле
        selectInputGender.click();
        // Получаем список
        WebElement listGender = driver.findElement(By.cssSelector("[id='id_gender']"));
        //ожидания видимости списка
        wait.until(ExpectedConditions.visibilityOf(listGender));
        // выбор из списка пола
        driver.findElement(By.cssSelector(String.format("[value ='%s']", gender.getName()))).click();
        return this;

    }

       // очистка поля по работе
        public PersonalAccountOtus workClear(Work... work){
          for (Work work1 : Work.values()){
              driver.findElement(By.cssSelector(String.format("[name = '%s']",work1.getName()))).clear();
          }

           return this;
        }


        // ввод работы и должности
        public PersonalAccountOtus workFill(Work work,String data){
            driver.findElement(By.cssSelector(String.format("[name = '%s']",work.getName()))).sendKeys(data);

        return this;
    }

    // Нажимаем на кнопку [Сохранить и заполнить позже]
       public PersonalAccountOtus buttonSaveСontinue(){
        // Нашли элемент кнопки
        //WebElement buttonSave = driver.findElement(buttonSaveSelector);
        //Ожидания элемента кнопка
        //wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSaveSelector));
        waitVisibility(By.cssSelector(buttonSaveSelector));
        //кликнуть на кнопку
           driver.findElement(By.xpath(buttonSaveSelector)).click();
        return this;
       }

       //проверка элемента
       public PersonalAccountOtus elementPercentage(){
        //WebElement elementPercentage = driver.findElement(By.xpath("//*[@class='progress-bar__fill']"));
        //Assertions.assertTrue(elementPercentage.isDisplayed(),"elementPercentage elementPercentage");
           //WebElement buttonSave = driver.findElement(By.cssSelector("[title='Сохранить и заполнить позже']"));
        Assertions.assertFalse(waitTools.waitNotElementPresent
                (By.cssSelector(buttonSaveSelector)),"The button is missing");
        return this;
       }


}
