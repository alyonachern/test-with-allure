package alyonachern.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class LambdaWIthStepTest {

    private static final String REPOSITORY = "alyonachern/project-for-git-test";
    private static final String ISSUE_TEXT = "Issue for issue";

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("a.chernyakova")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск Issue в репозитории")
    public void openIssueTest() {
        SelenideLogger.addListener("allure",new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open("https://github.com");
        });
        step("Найти репозиторий " + REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue("alyonachern/project-for-git-test").submit();
        });
        step("Кликнуть по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открыть вкладку Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверить наличие issue c названием " + ISSUE_TEXT, () -> {
            $(linkText(ISSUE_TEXT)).should(Condition.exist);
        });
    }
}
