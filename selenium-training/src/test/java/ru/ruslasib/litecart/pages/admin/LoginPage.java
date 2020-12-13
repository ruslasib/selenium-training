package test.java.ru.ruslasib.litecart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.ru.ruslasib.litecart.pages.Page;

public class LoginPage extends Page {

  private WebDriver driver;

  public LoginPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public void login(String login, String password) {
    typeLogin(login);
    typePassword(password);
//    click(By.cssSelector("[inputName=login]"));
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
  }

  public void typeLogin(String login) {
    type(By.name("username"), login);
  }

  public void typePassword(String password) {
    type(By.name("password"), password);
  }

  public void clickLogin() {
    click(By.cssSelector("[name=login]"));
  }
}
