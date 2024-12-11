package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.GenerationTestData;


public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    GenerationTestData generationTestData = new GenerationTestData();


    @Test
    void fillWholeFormRegistrationTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(generationTestData.firstName)
                .setLastName(generationTestData.lastName)
                .setEmail(generationTestData.email)
                .setGender(generationTestData.gender)
                .setUserNumber(generationTestData.phoneNumber)
                .setDateOfBirth(generationTestData.dayOfBirth, generationTestData.monthOfBirth, generationTestData.yearOfBirth)
                .setSubject(generationTestData.subject)
                .setHobbies(generationTestData.hobbies)
                .setPicture(generationTestData.picture)
                .setAddress(generationTestData.address)
                .setState(generationTestData.state)
                .setCity(generationTestData.city)
                .submit()

                .checkSuccessRegistration()
                .checkSuccessfulMassage("Thanks for submitting the form")
                .checkResult("Student Name", generationTestData.firstName + " " + generationTestData.lastName)
                .checkResult("Student Email", generationTestData.email)
                .checkResult("Gender", generationTestData.gender)
                .checkResult("Mobile", generationTestData.phoneNumber)
                .checkResult("Date of Birth", generationTestData.dayOfBirth + " " + generationTestData.monthOfBirth + "," + generationTestData.yearOfBirth)
                .checkResult("Subjects", generationTestData.subject)
                .checkResult("Hobbies", generationTestData.hobbies)
                .checkResult("Picture", generationTestData.picture)
                .checkResult("Address", generationTestData.address)
                .checkResult("State and City", generationTestData.state + " " + generationTestData.city);

    }
}


