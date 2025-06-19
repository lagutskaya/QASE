package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProjectsPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    LoginPage loginPage;
    ProjectsPage projectsPage;

    @BeforeClass(alwaysRun = true)
    public void settings() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
    }

    @BeforeMethod
    public void setup() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;

        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();

//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//                .screenshots(false)
//                .savePageSource(true)
//        );
    }

    @AfterMethod
    public void tearDown() {
//        if (result.FAILURE == result.getStatus()) {
//            AllureUtils.takeScreenshot(driver);
//        }
        closeWebDriver();
    }
}
