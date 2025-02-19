import PageObject.HomePage;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.not;

public class ConstructorNavigationTest extends BaseTest {

    HomePage homePage;

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void testMoveToBunsSection(){
        homePage = new HomePage(webDriver);
        homePage.waitForEnterAccountButton();
        homePage.clickSaucesLink();
        Assert.assertThat(homePage.getClassNameOfBunsLink(), not(CoreMatchers.containsString("tab_tab_type_current__2BEPc")));
        homePage.clickBunsLink();
        Assert.assertThat(homePage.getClassNameOfBunsLink(), CoreMatchers.containsString("tab_tab_type_current__2BEPc"));
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void testMoveToSaucesSection(){
        homePage = new HomePage(webDriver);
        homePage.waitForEnterAccountButton();
        Assert.assertThat(homePage.getClassNameOfSaucesLink(), not(CoreMatchers.containsString("tab_tab_type_current__2BEPc")));
        homePage.clickSaucesLink();
        Assert.assertThat(homePage.getClassNameOfSaucesLink(), CoreMatchers.containsString("tab_tab_type_current__2BEPc"));
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void testMoveTjFillingsSection(){
        homePage = new HomePage(webDriver);
        homePage.waitForEnterAccountButton();
        Assert.assertThat(homePage.getClassNameOfFillingsLink(), not(CoreMatchers.containsString("tab_tab_type_current__2BEPc")));
        homePage.clickFillingsLink();
        Assert.assertThat(homePage.getClassNameOfFillingsLink(), CoreMatchers.containsString("tab_tab_type_current__2BEPc"));
    }
}