package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Example1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com");

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

        driver.findElement(By.cssSelector(".btn-primary")).click();




    }

}
