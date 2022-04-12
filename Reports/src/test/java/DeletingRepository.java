import Helpers.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Story("Работа с удалением репозитория")
public class DeletingRepository {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String MAIN_PAGE_URL = "https://github.com";

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    MainAuthorizedPage mainAuthorizedPage;

    @BeforeAll
    static void startDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDrivers() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        driver.get(MAIN_PAGE_URL);
    }

    @Test
    @Feature("Удаление репозитория")
    void deleteRepository() {
        new MainUnAuthorizedPage(driver)
                .clickSignButton()
                .login("nikishkin.sashok@gmail.com", "Testingtesttotest")
                .clickOnNewCreatedRepository()
                .goToSettings()
                .deleteRepInSettings("SashokTest/Something1");
        Assertions.assertEquals(isElementPresent(By.xpath(mainAuthorizedPage.repositoryThatWeAreCreatingForTest)), false);
    }

    @AfterEach
    void shutDown() {
        driver.quit();
    }
}
