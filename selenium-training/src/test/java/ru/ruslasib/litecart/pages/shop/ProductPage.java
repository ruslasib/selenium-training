package test.java.ru.ruslasib.litecart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.ru.ruslasib.litecart.pages.Page;

import java.util.List;

public class ProductPage extends Page {

  private WebDriver driver;

  public ProductPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public String productName() {
    return driver.findElement(By.cssSelector("h1.title")).getAttribute("textContent");
  }

  public WebElement regularPrice() {
    return driver.findElement(By.cssSelector("#box-product .price-wrapper s"));
  }

  public WebElement promoPrice() {
    return driver.findElement(By.cssSelector("#box-product .price-wrapper strong"));
  }

  public void addToCart() {
    click(By.name("add_cart_product"));
  }

  public void selectSize() {
    if (isElementPresent(By.cssSelector("[name^=options]"))) {
      click(By.cssSelector("[name^=options]"));
      List<WebElement> options = driver.findElements(By.cssSelector("[name^=options] option"));
      options.get(1).click();
    }
  }

  public WebElement quantity() {
    return driver.findElement(By.cssSelector("#cart-wrapper .quantity"));
  }
}
