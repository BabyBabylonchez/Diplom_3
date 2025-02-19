import Utils.Endpoints;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import static Utils.WebDriverCreator.createWebDriver;

public class BaseTest  {
    WebDriver webDriver;
    @Before
    public void setUp(){
        webDriver = createWebDriver();
        webDriver.get(Endpoints.HOME_URL);
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }
}