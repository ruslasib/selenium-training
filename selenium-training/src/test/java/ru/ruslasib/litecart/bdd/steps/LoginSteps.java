package test.java.ru.ruslasib.litecart.bdd.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.ru.ruslasib.litecart.tests.LitecartAdmin;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginSteps {

  private LitecartAdmin litecartAdmin;
  WebDriver driver;
  WebDriverWait wait;

  @Before
  public void init() {
    driver = new FirefoxDriver();
    wait = new WebDriverWait(driver, 5);
    litecartAdmin = new LitecartAdmin(driver);
    litecartAdmin.launch();
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }

  @Given("^login page is opened$")
  public void openLoginPage() {
    driver.get("http://localhost/litecart/admin/login.php/");
  }

  @When("^I enter login (.+) and password (.+)$")
  public void login(String login, String password) {
    litecartAdmin.loginPage().typeLogin(login);
    litecartAdmin.loginPage().typePassword(password);
    litecartAdmin.loginPage().clickLogin();
  }

  @Then("^I see administration panel and see lightcart copyright$")
  public void verifyLoginToAdministrationPanel() {
    WebElement mainPageTitle = wait.until(presenceOfElementLocated(By.id("platform")));
    assertThat(mainPageTitle.getText(), containsString("LiteCart"));
  }

}
