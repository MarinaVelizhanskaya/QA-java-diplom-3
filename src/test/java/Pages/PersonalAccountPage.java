package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    private WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By exitButton = By.xpath(".//button[text()='Выход']");

    public void clickExitButton(){
        driver.findElement(exitButton).click();
    }

}
