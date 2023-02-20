import Pages.LoginPage;
import Pages.MainPage;
import Pages.PasswordRecoveryPage;
import Pages.RegistrationPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
    private WebDriver driver;
    private String currentUrl;

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver","/home/zaymer/WebDriver/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    };

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void loginByEnterInAccountButton() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickEnterInAccountButton();
        loginPage.login();
        mainPage.clickSignInPersonalAccountButton();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account", currentUrl);
    }

    @Test
    public void loginByPersonalAccountButton() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickSignInPersonalAccountButton();
        loginPage.login();
        mainPage.clickSignInPersonalAccountButton();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account", currentUrl);
    }

    @Test
    public void loginByEnterButtonOnRegistrationPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.clickSignInPersonalAccountButton();
        loginPage.clickRegisterButton();
        registrationPage.clickEnterButton();
        loginPage.login();
        mainPage.clickSignInPersonalAccountButton();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account", currentUrl);
    }

    @Test
    public void loginByEnterButtonOnPasswordRecoveryPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickSignInPersonalAccountButton();
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        loginPage.clickPasswordRecoveryButton();
        passwordRecoveryPage.clickEnterButton();
        loginPage.login();
        mainPage.clickSignInPersonalAccountButton();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account", currentUrl);
    }
}
