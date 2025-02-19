import User.*;
import Utils.Endpoints;
import PageObject.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.restassured.response.Response;
import static Utils.RandomString.randomString;

public class AuthorizationTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    ProfilePage profilePage;
    RegistrationPage registrationPage;
    RestorePasswordPage restorePasswordPage;


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
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void testEnterViaEnterAccountButton() {
        homePage = new HomePage(webDriver);
        homePage.waitForEnterAccountButton();
        homePage.clickEnterAccountButton();
        loginPage = new LoginPage(webDriver);
        loginPage.waitForPageLoad();
        loginPage.fillInUserData(email, password);
        loginPage.clickEnterButton();
        homePage.waitForRegisterOrderButton();
        Assert.assertEquals(Endpoints.HOME_URL, webDriver.getCurrentUrl());
        homePage.enterPersonalProfile();
        profilePage = new ProfilePage(webDriver);
        profilePage.waitForPageLoad();
        Assert.assertEquals(email, profilePage.getEmailText());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void testEnterViaPersonalProfileButton(){
        homePage = new HomePage(webDriver);
        homePage.waitForPersonalProfileButton();
        homePage.enterPersonalProfile();
        loginPage = new LoginPage(webDriver);
        loginPage.waitForPageLoad();
        loginPage.fillInUserData(email, password);
        loginPage.clickEnterButton();
        homePage.waitForRegisterOrderButton();
        homePage.enterPersonalProfile();
        profilePage = new ProfilePage(webDriver);
        profilePage.waitForPageLoad();
        Assert.assertEquals(email, profilePage.getEmailText());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void testEnterViaLinkInRegistrationForm(){
        homePage = new HomePage(webDriver);
        homePage.waitForEnterAccountButton();
        homePage.clickEnterAccountButton();
        loginPage = new LoginPage(webDriver);
        loginPage.waitForPageLoad();
        loginPage.clickRegistrationLink();
        registrationPage = new RegistrationPage(webDriver);
        registrationPage.waitForPageLoad();
        registrationPage.clickAlreadyRegisteredLink();
        loginPage.waitForPageLoad();
        loginPage.fillInUserData(email, password);
        loginPage.clickEnterButton();
        homePage.waitForRegisterOrderButton();
        homePage.enterPersonalProfile();
        profilePage = new ProfilePage(webDriver);
        profilePage.waitForPageLoad();
        Assert.assertEquals(email, profilePage.getEmailText());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void testEnterViaLinkInRestorePasswordForm(){
        homePage = new HomePage(webDriver);
        homePage.waitForEnterAccountButton();
        homePage.clickEnterAccountButton();
        loginPage = new LoginPage(webDriver);
        loginPage.waitForPageLoad();
        loginPage.clickRestorePasswordLink();
        restorePasswordPage = new RestorePasswordPage(webDriver);
        restorePasswordPage.waitForPageLoad();
        restorePasswordPage.clickRememberedPassword();
        loginPage.waitForPageLoad();
        loginPage.fillInUserData(email,password);
        loginPage.clickEnterButton();
        homePage.waitForRegisterOrderButton();
        homePage.enterPersonalProfile();
        profilePage = new ProfilePage(webDriver);
        profilePage.waitForPageLoad();
        Assert.assertEquals(email, profilePage.getEmailText());
    }

    @After
    public void cleanUp(){
        userClient.deleteUser(accessToken);
    }
}