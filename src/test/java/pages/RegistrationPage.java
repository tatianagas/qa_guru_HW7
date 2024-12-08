package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
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

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }


    public RegistrationPage setState(String value) {
        stateArea.click();
        stateWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityArea.click();
        stateWrapper.$(byText(value)).click();

        return this;
    }


    public RegistrationPage submit() {
        submitPress.click();

        return this;
    }


    public RegistrationPage checkSuccessRegistration() {
        modalComponent.isVisible();

        return this;
    }

    public RegistrationPage checkUnsuccessRegistration() {
        modalComponent.isNotVisible();

        return this;
    }


    public RegistrationPage checkSuccessfulMassage(String value) {
        modalComponent.checkModalTitle(value);

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        resultComponent.checkResult(key, value);

        return this;
    }
}
