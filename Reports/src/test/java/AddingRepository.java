import Helpers.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Story("Работа с добавлением репозитория")
public class AddingRepository {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String MAIN_PAGE_URL = "https://github.com";

    @BeforeAll
    static void startDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDrivers() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        driver.get(MAIN_PAGE_URL);
    }

    MainAuthorizedPage mainAuthorizedPage;

    @Test
    @Feature("Добавление репозитория")
    void addRepository(){
        new MainUnAuthorizedPage(driver)
                .clickSignButton()
                .login("nikishkin.sashok@gmail.com", "Testingtesttotest")
                .clickNewForRep()
                .createRepository("Something1")
                .clickMainPageButton()
                .checkForRepository();

        Assertions.assertEquals(driver.findElement(By.xpath(mainAuthorizedPage.repositoryThatWeAreCreatingForTest)).isDisplayed(), true);
    }

    @AfterEach
    void shutDown() {
        driver.quit();
    }
}
