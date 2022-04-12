import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RepositorySettings extends BasePageObject {

    public RepositorySettings(WebDriver driver) {
        super(driver);
    }

    private final static String deleteThisRepButtonXpath = "//summary[contains(text(), 'Delete this repository')]";
    private final static String blockerOfDeleteBtnCssLocator = ".btn:disabled";

    @FindBy(xpath = deleteThisRepButtonXpath)
    WebElement deleteThisRepButton;

    @FindBy(xpath = "//div[contains(@class, 'Box-body overflow-auto')]//input[contains(@name, 'verify')]")
    WebElement verifyInputFieldToDelete;

    @FindBy(xpath = "//form[contains(@action, '/SashokTest/Something1/settings/delete')]//button[contains(@class, 'btn-danger btn btn-block')]")
    WebElement finalDeleteRepBtn;

    @Step("Удалить репозиторий в настройках")
    public MainAuthorizedPage deleteRepInSettings(String verifyRepName) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteThisRepButtonXpath)));
        deleteThisRepButton.click();
        verifyInputFieldToDelete.sendKeys(verifyRepName);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(blockerOfDeleteBtnCssLocator)));
        finalDeleteRepBtn.click();
        return new MainAuthorizedPage(driver);
    }
}
