package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Example2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://habr.com/en/all/");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));

        /*Тест-кейс будет -> Пользователь находится на хабре не авторизованным и переходит во вкладку Development
        -> Companies
        -> VK
        -> News
        Да, простой тест кейс, но до сдачи час - затянул(
        */

        driver.findElement(By.xpath("//a[contains(@href, '/en/flows/develop/')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '/en/flows/develop/companies/')]")));
        driver.findElement(By.xpath("//a[contains(@href, '/en/flows/develop/companies/')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '/en/company/vk/profile/')]")));
        driver.findElement(By.xpath("//a[contains(@href, '/en/company/vk/profile/')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '/en/company/vk/news/')]")));
        driver.findElement(By.xpath("//a[contains(@href, '/en/company/vk/news/')]")).click();
    }

}
