import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import User.*;
import Utils.Endpoints;
import PageObject.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Utils.RandomString.randomString;

public class PersonalProfilePageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    ProfilePage profilePage;

    String email;
    String password;
    String name;
    String accessToken;
    UserClient userClient = new UserClient();
    User user;

    @Before
    public void createUser(){
        name = randomString(7);
        email = randomString(6) + "@yandex.ru";
        password = randomString(7);
        user = new User(email, password, name);
        Response createUser = userClient.createUser(user);
        accessToken = createUser.body().path("accessToken").toString().substring(7);

        homePage = new HomePage(webDriver);
        homePage.clickEnterAccountButton();
        loginPage = new LoginPage(webDriver);
        loginPage.waitForPageLoad();
        loginPage.fillInUserData(email, password);
        loginPage.clickEnterButton();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void testEnterPersonalProfileByClickPersonalProfileButton(){
        homePage.waitForRegisterOrderButton();
        homePage.enterPersonalProfile();
        profilePage = new ProfilePage(webDriver);
        profilePage.waitForPageLoad();
        Assert.assertEquals(Endpoints.PROFILE_URL, webDriver.getCurrentUrl());
        Assert.assertEquals(name, profilePage.getNameText());
        Assert.assertEquals(email, profilePage.getEmailText());
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    public void testClickConstructorButtonFromPersonalProfile() {
        homePage.waitForRegisterOrderButton();
        homePage.enterPersonalProfile();
        profilePage = new ProfilePage(webDriver);
        profilePage.waitForPageLoad();
        profilePage.clickConstructorButton();
        Assert.assertEquals(Endpoints.HOME_URL, webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    public void testClickLogoFromPersonalProfile() {
        homePage.waitForRegisterOrderButton();
        homePage.enterPersonalProfile();
        profilePage = new ProfilePage(webDriver);
        profilePage.waitForPageLoad();
        profilePage.clickLogo();
        Assert.assertEquals(Endpoints.HOME_URL, webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void testExitButton() {
        homePage.waitForRegisterOrderButton();
        homePage.enterPersonalProfile();
        profilePage = new ProfilePage(webDriver);
        profilePage.waitForPageLoad();
        profilePage.clickExitProfileButton();
        loginPage.waitForPageLoad();
        Assert.assertEquals(Endpoints.LOGIN_URL, webDriver.getCurrentUrl());
        Assert.assertEquals("", loginPage.getEmailInputFieldValue());
        Assert.assertEquals("", loginPage.getPasswordInputFieldValue());
    }

    @After
    public void cleanUp(){
        userClient.deleteUser(accessToken);
    }
}