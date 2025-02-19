package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By enterFormHeading = By.xpath(".//*[text()='Вход']");
    private final By emailInputField = By.xpath(".//fieldset[1]//input");
    private final By passwordInputField = By.xpath(".//fieldset[2]//input");

    private final By enterButton = By.xpath(".//button[text()='Войти']");

    private final By registrationLink = By.className("Auth_link__1fOlj");

    private final By restorePasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public void waitForPageLoad(){
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(enterFormHeading));
    }
    public void fillInUserData(String email, String password) {
        webDriver.findElement(emailInputField).sendKeys(email);
        webDriver.findElement(passwordInputField).sendKeys(password);
    }
    public void clickEnterButton(){
        webDriver.findElement(enterButton).click();
    }
    public void clickRegistrationLink(){
        webDriver.findElement(registrationLink).click();
    }
    public void clickRestorePasswordLink(){
        webDriver.findElement(restorePasswordLink).click();
    }

    public String getEmailInputFieldValue(){
        return webDriver.findElement(emailInputField).getAttribute("value");
    }
    public String getPasswordInputFieldValue(){
        return webDriver.findElement(passwordInputField).getAttribute("value");
    }
}