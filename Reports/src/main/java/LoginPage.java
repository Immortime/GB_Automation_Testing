import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageObject {

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    MainAuthorizedPage mainAuthorizedPage = new MainAuthorizedPage(driver);

    @FindBy(xpath = "//input[@id='login_field']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[contains(@name, 'commit')]")
    WebElement buttonSignIn;

    @Step("Логин")
    public MainAuthorizedPage login(String email, String password) {
        emailInput.click();
        emailInput.sendKeys(email);
        passwordInput.click();
        passwordInput.sendKeys(password);
        buttonSignIn.click();
        return mainAuthorizedPage;
    }

}
