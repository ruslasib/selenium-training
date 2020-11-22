package test.java.ru.ruslasib.litecart.tests;

import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.pages.shop.HomePage;

public class Shop {

  private WebDriver driver;

  private HomePage homePage;

  public Shop(WebDriver driver) {
    this.driver = driver;
  }

  public void launch() {
    driver.get("http://localhost/litecart/");
    homePage = new HomePage(driver);
  }

  public HomePage homePage() {
    return homePage;
  }
}
