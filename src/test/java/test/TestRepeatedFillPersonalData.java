package test;

import com.github.javafaker.Faker;
import communicatMetod.CommunicationMethod;
import communicatMetod.ICommunicationMethod;
import components.DropDownList;
import data.cities.ICityData;
import data.cities.RussiaCityData;
import dataData.english.EnglishLevelData;
import dataData.english.IEnglishLevel;
import dataGender.Gender;
import dataGender.IGender;
import factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPageOtus;
import pages.PersonalAccountOtus;

public class TestRepeatedFillPersonalData {

    private WebDriver driver;
    private MainPageOtus mainPageOtus;
    private PersonalAccountOtus personalAccountOtus;

    private DropDownList dropDownList;
    Faker faker = new Faker();


    @BeforeEach
    public void beforeEach() {
        this.driver = new DriverFactory().create();

    }

    @Test
    public void testOtusPersonalData(){

        ICityData[] cityData = RussiaCityData.values();
        ICityData city = faker.options().nextElement(cityData);

        IEnglishLevel[] englishLevels = EnglishLevelData.values();
        IEnglishLevel engglish = faker.options().nextElement(englishLevels);

        ICommunicationMethod[] communicationMethod = CommunicationMethod.values();
        ICommunicationMethod communi = faker.options().nextElement(communicationMethod);

        IGender[] genders = Gender.values();
        IGender gender = faker.options().nextElement(genders);

        new  MainPageOtus(driver).goTo() //вход на сайт
                .thereIsNotPopupElement() //Проверка что PopupElement нету, - "Войдите в свой акаунт"
                .implicitlyWaitButton() // ожидания элемента кнопка "Войти"
                .clickElementEnter() // клик по элементу кнопки "Войти"
                .untilWait() // ожидания попапа
                .popupElementDisplayed() //Проверка что PopupElement есть - "Войдите в свой акаунт"
                .authorizationEmail() // ввод Email
                .authorizationPassword() // ввод Password
                .clickElementEnterEnter() // клик по кнопки войти
                .thereIsNoButton() //Проверка что нет кнопки "Войти"
                .getCookies(); // вывод в лог куков

        new DropDownList(driver).implicitlyWaitButtonName() //Ожидание элемента Авторизованного имени
                .clickButtonName() // Клик по элементу "Авторизованного имени"
                .implicitlyWaitButtonMyProfile() //Ожидание элемента "Мой профиль"
                .clickButtonMyProfile(); //Кликнуть по элементу "Мой профиль"

        new PersonalAccountOtus(driver).personalWait();

    }

    @AfterEach
    public void finish() {
        if (driver != null){
            driver.quit();
        }
    }
}
