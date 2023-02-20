import Pages.LoginPage;
import Pages.MainPage;
import Pages.PersonalAccountPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountTest {
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
    public void returnOnMainPageByConstructorClick(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickEnterInAccountButton();
        loginPage.login();
        mainPage.clickSignInPersonalAccountButton();
        mainPage.clickConstructorButton();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", currentUrl);
    }

    @Test
    public void returnOnMainPageByLogoClick(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickEnterInAccountButton();
        loginPage.login();
        mainPage.clickSignInPersonalAccountButton();
        mainPage.clickLogo();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", currentUrl);
    }

    @Test
    public void returnOnMainPageByExitButton(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickEnterInAccountButton();
        loginPage.login();
        mainPage.clickSignInPersonalAccountButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text()='Выход']")));
        personalAccountPage.clickExitButton();
        Assert.assertTrue(loginPage.checkEnterButton());
    }




}
