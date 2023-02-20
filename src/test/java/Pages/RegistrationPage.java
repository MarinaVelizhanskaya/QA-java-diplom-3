package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;


    private By nameField = By.xpath(".//div/main/div/form/fieldset[1]/div/div/input");
    private By emailField = By.xpath(".//div/main/div/form/fieldset[2]/div/div/input");
    private By passwordField = By.xpath(".//div/main/div/form/fieldset[3]/div/div/input");
    private By registeredButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By enterButton = By.className("Auth_link__1fOlj");

    private By incorrectPasswordMessage = By.xpath(".//div[@class='input__container']/p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fillNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void fillEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegisteredButton() {
        driver.findElement(registeredButton).click();
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    public void fillInfoForRegistration(String name, String email, String password) {
        fillNameField(name);
        fillEmailField(email);
        fillPasswordField(password);
    }


    public boolean checkIncorrectPasswordMessage() {
        boolean isFindIncorrectPasswordMessage = driver.findElement(incorrectPasswordMessage).isDisplayed();
        return isFindIncorrectPasswordMessage;
    }

}
