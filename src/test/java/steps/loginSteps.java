package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.login.loginPage;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("NonAsciiCharacters")
public class loginSteps {
    WebDriver driver;

    @Before
    public void config() {
        final String BaseUrl = "https://www.saucedemo.com/";
        System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BaseUrl);
        driver.manage().deleteAllCookies();
    }

    @After
    public void After() {
        driver.close();
    }

    @Dado("que o usuário acesse a pagina de login")
    public void que_o_usuário_acesse_a_pagina_de_login() {
        loginPage RegistPage = new loginPage(driver);
        RegistPage.AccessSite();
    }

    @Quando("ele preencher username e password validos")
    public void ele_preencher_username_e_password_validos() {
        loginPage RegistPage = new loginPage(driver);
        RegistPage.FillInDate();
    }

    @Então("ele é logado no site")
    public void ele_é_logado_no_site() {
        loginPage RegistPage = new loginPage(driver);
        RegistPage.LoggedArea();
    }
}