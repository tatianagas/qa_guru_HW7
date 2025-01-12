package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@Tag("demoqa")
public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Description("Полностью заполненная форма для успешной регистрации")
    void fillWholeFormRegistrationTest() {
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

    @Test
    @Description("Минимально заполненная форма для успешной регистрации")
    void minFillFormRegistrationTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setGender("Male")
                .setUserNumber("0123456789")
                .submit()

                .checkSuccessRegistration()
                .checkSuccessfulMassage("Thanks for submitting the form")
                .checkResult("Student Name", "Ivan Petrov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789");

    }

    @Test
    @Description("Неуспешно заполненная форма регистрации — невалидный телефонный номер")
    void shortPhoneNumberFormRegistrationTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setGender("Male")
                .setUserNumber("012345678")
                .submit()

                .checkUnsuccessRegistration();

    }
}


