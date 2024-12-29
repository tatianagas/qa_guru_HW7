package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalComponent;
import pages.components.ResultComponent;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement checkForm = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateArea = $("#state"),
            stateWrapper = $("#stateCity-wrapper"),
            cityArea = $("#city"),
            submitPress = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();

    ModalComponent modalComponent = new ModalComponent();

    ResultComponent resultComponent = new ResultComponent();

    @Step("Открыть страницу формы регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        checkForm.shouldHave(text("Student Registration Form"));

        return this;
    }

    @Step("Убрать рекламные баннеры")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Ввести имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Ввести фамилию")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Ввести эл. почту")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Выбрать пол")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Ввести номер телефона")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Выбрать дату рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Выбрать дисциплину")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбрать хобби")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Загрузить фото")
    public RegistrationPage setPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("Вести адрес")
    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }


    @Step("Выбрать штат")
    public RegistrationPage setState(String value) {
        stateArea.click();
        stateWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Выбрать город")
    public RegistrationPage setCity(String value) {
        cityArea.click();
        stateWrapper.$(byText(value)).click();

        return this;
    }


    @Step("Подтвердить данные заполненной формы")
    public RegistrationPage submit() {
        submitPress.click();

        return this;
    }


    @Step("Появилось окно заполненной формы регистрации")
    public RegistrationPage checkSuccessRegistration() {
        modalComponent.isVisible();

        return this;
    }

    @Step("Не появилось окно заполненной формы регистрации")
    public RegistrationPage checkUnsuccessRegistration() {
        modalComponent.isNotVisible();

        return this;
    }


    @Step("Появилось сообщение об успешной регистрации")
    public RegistrationPage checkSuccessfulMassage(String value) {
        modalComponent.checkModalTitle(value);

        return this;
    }

    @Step("Проверка корректности заполненных данных в таблице успешной регистрации")
    public RegistrationPage checkResult(String key, String value) {
        resultComponent.checkResult(key, value);

        return this;
    }
}
