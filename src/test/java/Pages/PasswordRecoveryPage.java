package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private WebDriver driver;
    public PasswordRecoveryPage(WebDriver driver){
        this.driver = driver;
    }

    private By enterButton = By.className("Auth_link__1fOlj");
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}
