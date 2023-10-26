package alyonachern.tests;

import alyonachern.pages.MainPage;
import alyonachern.pages.RepositoryPage;
import alyonachern.pages.SearchPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepsTest extends BaseTest {

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

        mainPage.openUrl();
        mainPage.searchValue(REPOSITORY);

        searchPage.findResult(REPOSITORY);

        repoPage.findIssuesTab()
                .verifyIssueWithTextExist(ISSUE_TEXT);
    }
}
