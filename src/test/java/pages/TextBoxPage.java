package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitPress = $("#submit"),
            resultName = $("#output #name"),
            resultEmail = $("#output #email"),
            resultCurrentAddress = $("#output #currentAddress"),
            resultPermanentAddress = $("#output #permanentAddress");


    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);

        return this;
    }

    public TextBoxPage submit() {
        submitPress.click();

        return this;
    }


    public TextBoxPage checkResultFullName(String value) {
        resultName.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkResultEmail(String value) {
        resultEmail.shouldHave(text(value));

        return this;
    }


    public TextBoxPage checkResultCurrentAddress(String value) {
        resultCurrentAddress.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkResultPermanentAddress(String value) {
        resultPermanentAddress.shouldHave(text(value));

        return this;
    }
}

