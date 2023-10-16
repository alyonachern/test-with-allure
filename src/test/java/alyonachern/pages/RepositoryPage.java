package alyonachern.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class RepositoryPage {

    private static final SelenideElement ISSUES_TAB =  $("#issues-tab");

    @Step("Открыть вкладку Issues")
    public RepositoryPage findIssuesTab() {
       ISSUES_TAB.click();
       return this;
    }

    @Step("Проверить наличие issue c названием {issueText}")
    public void verifyIssueWithTextExist(String issueText) {
        $(linkText(issueText)).should(Condition.exist);
    }
}
