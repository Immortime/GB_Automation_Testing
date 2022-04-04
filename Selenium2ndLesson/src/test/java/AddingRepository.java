import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @Test
    void addRepository(){
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

        driver.findElement(By.xpath("//input[@id='login_field']")).click();
        driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys("nikishkin.sashok@gmail.com");

        driver.findElement(By.xpath("//input[@id='password']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testingtesttotest");

        driver.findElement(By.xpath("//input[contains(@name, 'commit')]")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//aside//a[contains(@class, 'btn btn-sm btn-primary')]")));
        driver.findElement(By.xpath("//aside//a[contains(@class, 'btn btn-sm btn-primary')]")).click();

        driver.findElement(By.xpath("//input[contains(@id, 'repository_name')]")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'repository_name')]")).sendKeys("Something1");

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".btn:disabled")));
        driver.findElement(By.xpath("//button[contains(@class, 'btn-primary btn')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Header-item mt-n1 mb-n1  d-none d-md-flex')]//a[contains(@href, 'https://github.com/')]")));
        driver.findElement(By.xpath("//div[contains(@class, 'Header-item mt-n1 mb-n1  d-none d-md-flex')]//a[contains(@href, 'https://github.com/')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//aside//div[contains(@class, 'wb-break-word')]//a[contains(@href, '/SashokTest/Something1')]")));

        Assertions.assertEquals(driver.findElement(By.xpath("//aside//div[contains(@class, 'wb-break-word')]//a[contains(@href, '/SashokTest/Something1')]")).isDisplayed(), true);

    }

    @AfterEach
    void shutDown() {
        driver.quit();
    }


}
