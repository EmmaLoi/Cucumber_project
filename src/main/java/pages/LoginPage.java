package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginPage {
  private WebDriver driver = null;
  private By userNameInput = By.id("login-form-username");
  private By passwordInput = By.id("login-form-password");
  private By loginButton = By.id("login");

  public void enterUserName(String name) {
    WebDriverFactory.getDriver().findElement(userNameInput).clear();
    WebDriverFactory.getDriver().findElement(userNameInput).sendKeys(name);
  }

  public void enterPassword(String password) {
    WebDriverFactory.getDriver().findElement(passwordInput).sendKeys(password);
  }

  public void clickLogin() {
    WebDriverFactory.getDriver().findElement(loginButton).click();
  }

  public void navigateTo() {
    WebDriverFactory.getDriver().get("https://jira.hillel.it/secure/Dashboard.jspa");
  }

  public boolean errorMessageIsPresent() {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(20).getSeconds());
    return wait.until(presenceOfElementLocated(By.id("usernameerror"))).isDisplayed();
  }
}