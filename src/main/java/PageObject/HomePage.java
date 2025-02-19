package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver webDriver;
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By registerOrderButton = By.xpath(".//*[text()='Оформить заказ']");
    private final By personalProfileButton = By.xpath(".//*[text()='Личный Кабинет']");
    private final By saucesLink = By.xpath(".//span[text()='Соусы']/parent::div");
    private final By bunsLink = By.xpath(".//span[text()='Булки']/parent::div");
    private final By fillingLink = By.xpath(".//*[text()='Начинки']/parent::div");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void clickEnterAccountButton() {
        webDriver.findElement(enterAccountButton).click();
    }
    public void waitForEnterAccountButton(){
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(enterAccountButton));
    }

    public void waitForRegisterOrderButton(){
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(registerOrderButton));
    }
    public void waitForPersonalProfileButton(){
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(personalProfileButton));
    }
    public void enterPersonalProfile(){
        webDriver.findElement(personalProfileButton).click();
    }
    public void clickBunsLink() {
        webDriver.findElement(bunsLink).click();
    }
    public void clickSaucesLink() {
        webDriver.findElement(saucesLink).click();
    }
    public void clickFillingsLink(){
        webDriver.findElement(fillingLink).click();
    }
    public String getClassNameOfBunsLink() {
        return webDriver.findElement(bunsLink).getAttribute("class");
    }
    public String getClassNameOfSaucesLink(){
        return webDriver.findElement(saucesLink).getAttribute("class");
    }
    public String getClassNameOfFillingsLink(){
        return webDriver.findElement(fillingLink).getAttribute("class");
    }
}