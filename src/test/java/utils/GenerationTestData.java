package utils;

import com.github.javafaker.Faker;

import java.util.Locale;


public class GenerationTestData {
    Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            dayOfBirth = String.format("%s", faker.number().numberBetween(1, 28)),
            monthOfBirth = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December"),
            yearOfBirth = String.format("%s",faker.number().numberBetween(1924, 2010)),
            subject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry", "Biology",
            "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History",
            "Civics"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = faker.options().option("bug.jpg", "img1.png", "img2.png"),
            address = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = selectCity(state);



    public String selectCity(String state) {
        switch(state){

            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");

            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");

            case "Haryana":
                return faker.options().option("Karnal", "Panipat");

            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");

            default:
                return null;
        }

    }
}
