package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class CatalogPage {

    private static final String SEARCH_PAGE_TITLE = "Поиск";
    private final SelenideElement pageTitle = $("#pagetitle"),
                                  leftMenuBlock = $(".sticky-sidebar__inner"),
                                  filterSections =$(".bx_filter_section"),
                                  productId = $("#bx_3966226736_2081");



    @Step("Checking catalog page after search")
    public CatalogPage verifyCatalogPageResults() {

        pageTitle.shouldHave(text(SEARCH_PAGE_TITLE));
        leftMenuBlock.shouldBe(visible);
        filterSections.shouldBe(visible);
        productId.shouldBe(visible);

        return this;

    }

    @Step("Click on found product")
    public ProductPage clickOnProduct(){
        productId.shouldBe(visible).click();
        return page(ProductPage.class);
    }

}
