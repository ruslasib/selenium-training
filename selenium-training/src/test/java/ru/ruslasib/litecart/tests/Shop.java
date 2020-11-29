package test.java.ru.ruslasib.litecart.tests;

import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.pages.shop.Cart;
import test.java.ru.ruslasib.litecart.pages.shop.CreateAccount;
import test.java.ru.ruslasib.litecart.pages.shop.HomePage;
import test.java.ru.ruslasib.litecart.pages.shop.ProductPage;

public class Shop {

  private WebDriver driver;

  private HomePage homePage;
  private ProductPage productPage;
  private CreateAccount createAccount;
  private Cart cart;

  public Shop(WebDriver driver) {
    this.driver = driver;
  }

  public void launch(String url) {
    openUrl(url);
    homePage = new HomePage(driver);
    productPage = new ProductPage(driver);
    createAccount = new CreateAccount(driver);
    cart = new Cart(driver);
  }

  private void openUrl(String url) {
    driver.get(url);
  }

  public HomePage homePage() {
    return homePage;
  }

  public ProductPage productPage() {
    return productPage;
  }

  public CreateAccount createAccount() {
    return createAccount;
  }

  public Cart cart() {
    return cart;
  }
}
