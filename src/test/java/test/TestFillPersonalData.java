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
import dataWork.Work;
import factory.DriverFactory;
import fieldData.InputFieldData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.MainPageOtus;
import pages.PersonalAccountOtus;
import workGraf.WorkGraf;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TestFillPersonalData {

       private WebDriver driver;
       private MainPageOtus mainPageOtus;
       private PersonalAccountOtus personalAccountOtus;

       private DropDownList dropDownList;
       Faker faker = new Faker();


       @BeforeEach
       public void beforeEach() {
           this.driver = new DriverFactory().create();

       }

       @org.junit.jupiter.api.Test
       public void testOtusAuthorization() {
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

              new PersonalAccountOtus(driver).personalWait()
                                             .addNewNameFieldsClear(InputFieldData.FNAME)
                                             .addNewNameFields(InputFieldData.FNAME,faker.name().firstName())
                                             .addNewNameFields(InputFieldData.FNAMELATIN,faker.name().firstName())
                                             .addNewNameFields(InputFieldData.LNAME,faker.name().lastName())
                                             .addNewNameFields(InputFieldData.LNAMELATIN,faker.name().firstName())
                                             .addNewNameFields(InputFieldData.BLOGNAME,faker.name().firstName())
                                             .addNewNameFields(InputFieldData.DATEOFBRITH,
                                                        faker.date().birthday().toInstant().
                                                       atZone(ZoneId.systemDefault()).
                                                     toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                      .selectCountry(RussiaCityData.MOSSCOW) // заполнения поля странна
                      .selectCity(RussiaCityData.MOSSCOW) // заполнения поля город
                      .selectLanguage(EnglishLevelData.BEGINNER) //знания английского
                      .readyToMove(true) // Готовность к переезду
                      .workGraf(true, WorkGraf.REMOTELY) // выбор форма работы
                      .communicationMethod(CommunicationMethod.TELEGRAM)
                      .connection() // кликнтуь на выбор связи
                      .gender(Gender.MALE) // выбор пола
                      .workClear(Work.COMPANY) //
                      .workFill(Work.COMPANY,faker.name().lastName()) //заполнения комапнии
                      .workFill(Work.WORK,faker.name().lastName()) //заполения должности
                      .buttonSaveСontinue()//кликнуть по кнопки [Сохранить и заполнить позже]
                      .elementPercentage(); //проверка элемента

       }

       @AfterEach
       public void finish() {
              if (driver != null){
                  driver.quit();
              }
       }


}

