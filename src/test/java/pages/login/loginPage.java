package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;


public class loginPage {
    WebDriver driver;

    final String ImgHomeSite = "div[class='login_logo']";
    final String FieldUsrName = "input[id='user-name'";
    final String UserName = "standard_user";
    final String FieldPassword = "input[id='password']";
    final String Password = "secret_sauce";
    final String Submit = "input[id='login-button']";
    final String loggedTitle = "span[class='title']";

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void AccessSite() {
        driver.findElement(By.cssSelector(ImgHomeSite));
    }

    public void FillInDate() {
        driver.findElement(By.cssSelector(FieldUsrName)).sendKeys(UserName);
        driver.findElement(By.cssSelector(FieldPassword)).sendKeys(Password);
        driver.findElement(By.cssSelector(Submit)).click();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void LoggedArea() {
        String TxtCreateAccount = driver.findElement
                (By.cssSelector(loggedTitle)).getText();
        assertEquals("PRODUCTS", TxtCreateAccount);
    }
}