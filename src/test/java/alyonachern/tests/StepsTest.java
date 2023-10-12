package alyonachern.tests;

import alyonachern.pages.MainPage;
import alyonachern.pages.RepositoryPage;
import alyonachern.pages.SearchPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepsTest {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    RepositoryPage repoPage = new RepositoryPage();

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

        mainPage.openUrl();
        mainPage.searchValue(REPOSITORY);

        searchPage.findResult(REPOSITORY);

        repoPage.findIssuesTab()
                .verifyIssueWithTextExist(ISSUE_TEXT);
    }
}
