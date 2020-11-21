package test.java.ru.ruslasib.litecart.tests;

import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.tests.pages.admin.main.LeftMenu;
import test.java.ru.ruslasib.litecart.tests.pages.admin.LoginPage;

public class Litecart {

  private WebDriver driver;
  private LoginPage loginPage;
  private LeftMenu leftMenu;

  public Litecart(WebDriver driver) {
    this.driver = driver;
  }

  public void launch() {
    driver.get("http://localhost/litecart/admin/login.php/");
    loginPage = new LoginPage(driver);
    leftMenu = new LeftMenu(driver);
  }

  public LoginPage loginPage() {
    return loginPage;
  }

  public LeftMenu leftMenu() {
    return leftMenu;
  }
}
