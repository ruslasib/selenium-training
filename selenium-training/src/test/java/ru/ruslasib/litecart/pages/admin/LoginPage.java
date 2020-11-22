package test.java.ru.ruslasib.litecart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.pages.Page;

public class LoginPage extends Page {

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void login(String login, String password) {
    typeLogin(login);
    typePassword(password);
    click(By.cssSelector("button[name=login]"));
  }

  public void typeLogin(String login) {
    type(By.name("username"), login);
  }

  public void typePassword(String password) {
    type(By.name("password"), password);
  }

  public void clickLogin() {
    click(By.cssSelector("button[name=login]"));
  }
}
