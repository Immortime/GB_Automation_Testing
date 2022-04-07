import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainUnAuthorizedPage extends BasePageObject{

    public MainUnAuthorizedPage(WebDriver driver) {
        super(driver);
    }

    private static final String signButtonXpath = "//a[contains(text(),'Sign in')]";

    LoginPage loginPage = new LoginPage(driver);

    @FindBy(xpath = signButtonXpath)
    public WebElement signButton;

    public LoginPage clickSignButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signButtonXpath)));
        signButton.click();
        return loginPage;
    }

}
