import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewRepositoryPage extends BasePageObject {

    public NewRepositoryPage(WebDriver driver) {
        super(driver);
    }

    private final static String mainPageButtonXpath = "//div[contains(@class, 'Header-item mt-n1 mb-n1  d-none d-md-flex')]//a[contains(@href, 'https://github.com/')]";
    private final static String extendOfRepFunctionsXpath = "//details[contains(@class, 'details-overlay details-reset position-relative')]";

    @FindBy(xpath = mainPageButtonXpath)
    WebElement returnToTheMainPageButton;

    @FindBy (xpath = extendOfRepFunctionsXpath)
    WebElement extendOfRepFunctions;

    @FindBy (xpath = "//details//a[contains(@href, '/SashokTest/Something1/settings')]")
    WebElement settingsButton;

    public MainAuthorizedPage clickMainPageButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mainPageButtonXpath)));
        returnToTheMainPageButton.click();
        return new MainAuthorizedPage(driver);
    }

    public RepositorySettings goToSettings() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(extendOfRepFunctionsXpath)));
        extendOfRepFunctions.click();
        settingsButton.click();
        return new RepositorySettings(driver);
    }
}
