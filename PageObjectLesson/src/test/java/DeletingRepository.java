import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.get(MAIN_PAGE_URL);
    }

    @Test
    void deleteRepository() {
        new MainUnAuthorizedPage(driver)
                .clickSignButton()
                .login("nikishkin.sashok@gmail.com", "Testingtesttotest")
                .clickOnNewCreatedRepository()
                .goToSettings()
                .deleteRepInSettings("SashokTest/Something1");
        Assertions.assertEquals(isElementPresent(By.xpath(mainAuthorizedPage.repositoryThatWeAreCreatingForTest)), false);
    }
}
