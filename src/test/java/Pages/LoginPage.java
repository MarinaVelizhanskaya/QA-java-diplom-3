package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    private By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");
    private By passwordRecoveryButton = By.className("Auth_link__1fOlj");
    private By enterButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx " +
            "button_button_size_medium__3zxIa']");
    private By emailUserField = By.name("name");
    private By passwordUserField = By.name("Пароль");



    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }
    public void clickPasswordRecoveryButton(){
        driver.findElement(passwordRecoveryButton).click();
    }
    public boolean checkEnterButton() {
        boolean isFindEnterButton = driver.findElement(enterButton).isDisplayed();
        return isFindEnterButton;
    }

    public void fillEmailUserField() {
        driver.findElement(emailUserField).sendKeys("m.velizhanskaya91@yandex.ru");
    }
    public void fillPasswordUserField() {
        driver.findElement(passwordUserField).sendKeys("practicum");
    }

    public void clickEnterButton(){
        driver.findElement(enterButton).click();
    }

    public void login(){
        fillEmailUserField();
        fillPasswordUserField();
        clickEnterButton();
    }


}
