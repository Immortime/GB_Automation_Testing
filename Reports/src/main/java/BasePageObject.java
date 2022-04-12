import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePageObject {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(4));
        actions = new Actions(this.driver);
        PageFactory.initElements(driver, this);
    }
}
