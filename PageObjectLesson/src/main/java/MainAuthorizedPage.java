import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainAuthorizedPage extends BasePageObject {

    public MainAuthorizedPage(WebDriver driver) {
        super(driver);
    }

    private final static String buttonNewXpathLocator = "//aside//a[contains(@class, 'btn btn-sm btn-primary')]";
    public final static String repositoryThatWeAreCreatingForTest = "//aside//div[contains(@class, 'wb-break-word')]//a[contains(@href, '/SashokTest/Something1')]";


    @FindBy(xpath = buttonNewXpathLocator)
    WebElement buttonNewToCreateRepository;

    @FindBy(xpath = "//aside//div[contains(@class, 'wb-break-word')]//a[contains(@href, '/SashokTest/Something1')]")
    WebElement newCreatedRepository;

    public RepositoryCreationMenuPage clickNewForRep() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonNewXpathLocator)));
        buttonNewToCreateRepository.click();
        return new RepositoryCreationMenuPage(driver);
    }

    public void checkForRepository() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(repositoryThatWeAreCreatingForTest)));
    }

    public NewRepositoryPage clickOnNewCreatedRepository() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(repositoryThatWeAreCreatingForTest)));
        newCreatedRepository.click();
        return new NewRepositoryPage(driver);
    }
}
