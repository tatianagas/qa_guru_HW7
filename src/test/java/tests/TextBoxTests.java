package tests;


import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    TextBoxPage textBox = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBox.openPage()
                .removeBanner()
                .setFullName("Alex")
                .setEmail("alex@egorov.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submit()

                .checkResultFullName("Alex")
                .checkResultEmail("alex@egorov.com")
                .checkResultCurrentAddress("Some street 1")
                .checkResultPermanentAddress("Another street 1");

    }
}
