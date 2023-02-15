package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    private By signInPersonalAccountButton = By.xpath(".//div/header/nav/a/p[text()='Личный Кабинет']");
    private By bunsSection = By.xpath(".//span[text()='Булки']");
    private By sauceSection = By.xpath(".//span[text()='Соусы']");
    private By bunsSectionSelected = By.xpath(".//section[1]/div[1]/div[1]");
    private By sauceSectionSelected = By.xpath(".//section[1]/div[1]/div[2]");
    private By fillingsSection = By.xpath(".//span[text()='Начинки']");
    private By fillingsSectionSelected = By.xpath(".//section[1]/div[1]/div[3]");
    private By enterInAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private By logo = By.className("AppHeader_header__logo__2D0X2");




    public void clickSignInPersonalAccountButton(){
        driver.findElement(signInPersonalAccountButton).click();
    }
    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }
    public void clickEnterInAccountButton(){
        driver.findElement(enterInAccountButton).click();
    }
    public void clickLogo(){
        driver.findElement(logo).click();
    }
    public void clickSauceSection(){
        driver.findElement(sauceSection).click();
    }
    public void clickFillingsSection(){
        driver.findElement(fillingsSection).click();
    }
    public void clickBunsSection(){
        driver.findElement(bunsSection).click();
    }

    public String getSauceSectionSelectedAttribute() {
        return driver.findElement(sauceSectionSelected).getAttribute("class");
    }

    public String getFillingsSectionSelectedAttribute() {
        return driver.findElement(fillingsSectionSelected).getAttribute("class");
    }
    public String getFillingsBunsSectionSelectedAttribute() {
        return driver.findElement(bunsSectionSelected).getAttribute("class");
    }



}
