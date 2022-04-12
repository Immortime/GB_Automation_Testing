import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RepositoryCreationMenuPage extends BasePageObject {

    public RepositoryCreationMenuPage(WebDriver driver) {
        super(driver);
    }

    private final static String cssLocatorOffButtonCreateRepositoryBlocker = ".btn:disabled";

    @FindBy(xpath = "//input[contains(@id, 'repository_name')]")
    WebElement inputNameOfRepository;

    @FindBy(xpath = "//button[contains(@class, 'btn-primary btn')]")
    WebElement buttonCreateRepository;

    @Step("Создать новый репозиторий")
    public NewRepositoryPage createRepository(String repName) {
        inputNameOfRepository.click();
        inputNameOfRepository.sendKeys(repName);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(cssLocatorOffButtonCreateRepositoryBlocker)));
        buttonCreateRepository.click();
        return new NewRepositoryPage(driver);
    }
}
