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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeletingRepository {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String MAIN_PAGE_URL = "https://github.com";

    //Этот тест-кейс из задания на Selenium IDE
    // !!! Я понимаю, что стоит использовать куки для постоянной авторизации, но я пока просто набиваю руку и пишу всё в ручную
    // Хотя такая себе отмазка :D

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

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
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

        driver.findElement(By.xpath("//input[@id='login_field']")).click();
        driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys("nikishkin.sashok@gmail.com");

        driver.findElement(By.xpath("//input[@id='password']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testingtesttotest");

        driver.findElement(By.xpath("//input[contains(@name, 'commit')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//aside//div[contains(@class, 'wb-break-word')]//a[contains(@href, '/SashokTest/Something1')]")));
        driver.findElement(By.xpath("//aside//div[contains(@class, 'wb-break-word')]//a[contains(@href, '/SashokTest/Something1')]")).click();
        driver.findElement(By.xpath("//details[contains(@class, 'details-overlay details-reset position-relative')]")).click();
        driver.findElement(By.xpath("//details//a[contains(@href, '/SashokTest/Something1/settings')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//summary[contains(text(), 'Delete this repository')]")));
        driver.findElement(By.xpath("//summary[contains(text(), 'Delete this repository')]")).click();
        //Этот тест надо использовать после прохождения предыдущего
        driver.findElement(By.xpath("//div[contains(@class, 'Box-body overflow-auto')]//input[contains(@name, 'verify')]")).sendKeys("SashokTest/Something1");
        //У нас тут как и в прошлом разе мешает заблокированная кнопка, поэтому...
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".btn:disabled")));
        driver.findElement(By.xpath("//form[contains(@action, '/SashokTest/Something1/settings/delete')]//button[contains(@class, 'btn-danger btn btn-block')]")).click();

        //Тут мы делаем ожидание на уже существующий репозиторий, просто чтобы страница прогрузилась, а то получится, что он скажет, что всё норм, когда даже не проверил
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//aside//div[contains(@class, 'wb-break-word')]//a[contains(@href, '/SashokTest/Something')]")));
        Assertions.assertEquals(isElementPresent(By.xpath("//aside//div[contains(@class, 'wb-break-word')]//a[contains(@href, '/SashokTest/Something1')]")), false);


    }
}
