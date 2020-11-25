package test.java.ru.ruslasib.litecart.tests;

import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.pages.shop.HomePage;
import test.java.ru.ruslasib.litecart.pages.shop.ProductPage;

public class Shop {

  private WebDriver driver;

  private HomePage homePage;
  private ProductPage productPage;

  public Shop(WebDriver driver) {
    this.driver = driver;
  }

  public void launch() {
    driver.get("http://localhost/litecart/");
    homePage = new HomePage(driver);
    productPage = new ProductPage(driver);
  }

  public HomePage homePage() {
    return homePage;
  }

  public ProductPage productPage() {
    return productPage;
  }
}
