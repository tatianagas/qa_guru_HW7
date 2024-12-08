package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setEmail("ivan_petrov1978@mail.ru")
                .setGender("Male")
                .setUserNumber("0123456789")
                .setDateOfBirth("13", "March", "1978")
                .setSubject("Biology")
                .setHobbies("Reading")
                .setPicture("bug.jpg")
                .setAddress("Some address")
                .setState("NCR")
                .setCity("Delhi")
                .submit()

                .checkSuccessRegistration()
                .checkSuccessfulMassage("Thanks for submitting the form")

                .checkResult("Student Name", "Ivan Petrov")
                .checkResult("Student Email", "ivan_petrov1978@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789")
                .checkResult("Date of Birth", "13 March,1978")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "bug.jpg")
                .checkResult("Address", "Some address")
                .checkResult("State and City", "NCR Delhi");

    }
}
