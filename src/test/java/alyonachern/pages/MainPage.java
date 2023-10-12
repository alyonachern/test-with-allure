package alyonachern.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private static final String URL = "https://github.com";
    private static final SelenideElement SEARCH_INACTIVE_BAR = $(".search-input"),
            SEARCH_ACTIVE_BAR = $("#query-builder-test");

    @Step("Открыть главную страницу")
    public void openUrl() {
        open(URL);
    }

    @Step("Найти репозиторий {value}")
    public void searchValue(String value) {
        SEARCH_INACTIVE_BAR.click();
        SEARCH_ACTIVE_BAR.setValue(value).submit();
    }
}
