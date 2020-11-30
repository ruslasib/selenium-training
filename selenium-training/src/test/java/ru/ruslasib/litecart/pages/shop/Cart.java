package test.java.ru.ruslasib.litecart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.ru.ruslasib.litecart.pages.Page;

import java.util.List;

public class Cart extends Page {

  private WebDriver driver;

  public Cart(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public List<WebElement> orderedItemsQuantity() {
    return driver.findElements(By.cssSelector("#box-checkout-summary td.item"));
  }

  public void remove() {
    click(By.name("remove_cart_item"));
  }

  public WebElement noItemsInYourCart() {
    return driver.findElement(By.cssSelector("#checkout-cart-wrapper em"));
  }
}
