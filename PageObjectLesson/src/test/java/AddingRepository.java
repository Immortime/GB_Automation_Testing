import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.get(MAIN_PAGE_URL);
    }

    MainAuthorizedPage mainAuthorizedPage;

    @Test
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
