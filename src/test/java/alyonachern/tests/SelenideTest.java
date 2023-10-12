package alyonachern.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("a.chernyakova")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск Issue в репозитории")
    public void openIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").setValue("alyonachern/project-for-git-test").submit();
        $(linkText("alyonachern/project-for-git-test")).click();
        $("#issues-tab").click();
        $(linkText("Issue for issue")).should(Condition.exist);
    }
}
