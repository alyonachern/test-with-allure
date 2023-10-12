package alyonachern.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class SearchPage {

    @Step("Кликнуть по ссылке репозитория {result}")
    public void findResult(String result) {
        $(linkText(result)).click();
    }
}
