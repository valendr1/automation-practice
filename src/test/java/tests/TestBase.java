package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    static String login = config.login();
    static String password = config.password();
    static String selenoidSign = "https://" + login + ":" + password + "@selenoid.autotests.cloud/wd/hub";

    @BeforeAll
    static void startup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String chooseBrowser = System.getProperty("chooseBrowser","chrome");
        String setBrowserSize = System.getProperty("setBrowserSize", "1920x1200");
        Configuration.browser = chooseBrowser;
        Configuration.browserSize = setBrowserSize;

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = selenoidSign;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        System.out.println(chooseBrowser);
        System.out.println(setBrowserSize);

    }

    @AfterEach
    public void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
