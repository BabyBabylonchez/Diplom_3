package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    WebDriver webDriver;

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By textMessage = By.xpath(".//*[text()='В этом разделе вы можете изменить свои персональные данные']");

    private final By nameField = By.xpath(".//li[1]//input");
    private final By emailField = By.xpath(".//li[2]//input");

    private final By constructorButton = By.xpath(".//*[text()='Конструктор']");

    private final By logo = By.xpath(".//nav/div[@class='AppHeader_header__logo__2D0X2']");

    private final By exitButton = By.xpath(".//button[text()='Выход']");

    public void waitForPageLoad() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(textMessage));
    }

    public String getEmailText() {
        return webDriver.findElement(emailField).getAttribute("value");
    }

    public String getNameText() {
        return webDriver.findElement(nameField).getAttribute("value");
    }

    public void clickConstructorButton() {
        webDriver.findElement(constructorButton).click();
    }

    public void clickLogo() {
        webDriver.findElement(logo).click();
    }

    public void clickExitProfileButton() {
        webDriver.findElement(exitButton).click();
    }
}