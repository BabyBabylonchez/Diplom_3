package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverCreator {
    private static final String CHROMEDRIVER_PATH = "C:/WebDriver/bin/chromedriver.exe";
    private static final String YANDEX_BROWSER_PATH = "C:/Users/Kirill/AppData/Local/Yandex/YandexBrowser/Application/browser.exe";

    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            return createChromeDriver();
        }
        switch (browser) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
            default:
                return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().browserVersion("133").setup();
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexDriver() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.setBinary(YANDEX_BROWSER_PATH);

        // 🔹 Отключаем флаг автоматизации
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-infobars"); // Убирает "браузером управляет..."

        // 🔹 Улучшаем стабильность
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        return new ChromeDriver(options);
    }
}