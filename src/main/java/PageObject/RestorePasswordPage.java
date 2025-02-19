package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RestorePasswordPage {
    WebDriver webDriver;

    public RestorePasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By restoreFormHeading = By.xpath(".//*[text()='Восстановление пароля']");

    private final By rememberedPasswordLink = By.xpath(".//a[text()='Войти']");

    public void waitForPageLoad(){
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(restoreFormHeading));
    }

    public void clickRememberedPassword(){
        webDriver.findElement(rememberedPasswordLink).click();
    }
}