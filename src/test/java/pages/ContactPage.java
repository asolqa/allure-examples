package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContactPage {

    private static final String CONTACTS_PAGE_TITLE = "Контакты";
    private final SelenideElement pageTitle = $("#pagetitle"),
                                  mainBlock = $(".bottom_block"),
                                  map = $(".bx-yandex-view-map"),
                                  messageButton = $("[data-name=contacts]");


    @Step("Checking contact page has data")
    public ContactPage verifyContactPageData() {

        pageTitle.shouldHave(text(CONTACTS_PAGE_TITLE));
        mainBlock.shouldHave(text("Режим работы"));
        mainBlock.shouldHave(text("с 10.00 до 19.00"));
        mainBlock.shouldHave(text("Телефон"));
        mainBlock.shouldHave(text("+7 (495) 185-04-22"));
        mainBlock.shouldHave(text("E-mail"));
        mainBlock.shouldHave(text("ask@askmask.ru"));
        return this;

    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Checking contact page has a map")
    public ContactPage verifyMapVisibility() {
        map.shouldBe(visible);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Checking option to send message is available")
    public ContactPage verifyMessageOption() {
        messageButton.shouldBe(visible);
        return this;
    }

}