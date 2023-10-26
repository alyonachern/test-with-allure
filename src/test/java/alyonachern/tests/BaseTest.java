package alyonachern.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("version", "100.0");
        Configuration.browserSize = System.getProperty("windowSize", "1920x1080");
        Configuration.remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure",new AllureSelenide());
    }
}


