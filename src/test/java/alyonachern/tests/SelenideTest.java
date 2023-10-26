package alyonachern.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends BaseTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("a.chernyakova")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск Issue в репозитории")
    public void openIssueTest() {

        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").setValue("alyonachern/project-for-git-test").submit();
        $(linkText("alyonachern/project-for-git-test")).click();
        $("#issues-tab").click();
        $(linkText("Issue for issue")).should(Condition.exist);
    }
}
