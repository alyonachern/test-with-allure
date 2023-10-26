package alyonachern.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class LambdaWIthStepTest extends BaseTest {

    private static final String REPOSITORY = "alyonachern/project-for-git-test";
    private static final String ISSUE_TEXT = "Issue for issue";

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("a.chernyakova")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск Issue в репозитории")
    public void openIssueTest() {

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
