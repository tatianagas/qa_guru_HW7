package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ModalComponent {
    public void isVisible() {
        $(".modal-dialog").should(appear);
    }

    public void checkModalTitle(String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text(value));
    }

    public void isNotVisible() {
        $(".modal-dialog").shouldNot(appear);
    }

}
