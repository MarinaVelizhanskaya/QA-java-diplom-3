import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegistrationPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class RegistrationTest {
    private String name;
    private String email;
    private String password;
    private WebDriver driver;
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
    public void checkSuccessfulRegistration(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        name = RandomStringUtils.randomAlphabetic(10);
        email = RandomStringUtils.randomAlphanumeric(10) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(10);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickSignInPersonalAccountButton();
        loginPage.clickRegisterButton();
        registrationPage.fillInfoForRegistration(name, email, password);
        registrationPage.clickRegisteredButton();
        Assert.assertTrue(loginPage.checkEnterButton());
    }

    @Test
    public void checkRegistrationWithIncorrectPassword(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        name = RandomStringUtils.randomAlphabetic(10);
        email = RandomStringUtils.randomAlphanumeric(10) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(5);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickSignInPersonalAccountButton();
        loginPage.clickRegisterButton();
        registrationPage.fillInfoForRegistration(name, email, password);
        registrationPage.clickRegisteredButton();
        Assert.assertTrue(registrationPage.checkIncorrectPasswordMessage());
    }
}
