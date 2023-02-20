import Pages.MainPage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.containsString;

public class ConstructorTest {
    private WebDriver driver;
    private String atr;


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
    public void goToSauceSection(){

        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceSection();
        atr = mainPage.getSauceSectionSelectedAttribute();
        MatcherAssert.assertThat(atr, containsString("current"));
    }

    @Test
    public void goToFillingsSection(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingsSection();
        atr = mainPage.getFillingsSectionSelectedAttribute();
        MatcherAssert.assertThat(atr, containsString("current"));
    }

    @Test
    public void goToBunsSection() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceSection();
        mainPage.clickBunsSection();
        atr = mainPage.getFillingsBunsSectionSelectedAttribute();
        MatcherAssert.assertThat(atr, containsString("current"));
    }

}
