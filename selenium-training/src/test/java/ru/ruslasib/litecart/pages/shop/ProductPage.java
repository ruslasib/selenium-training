package test.java.ru.ruslasib.litecart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.ru.ruslasib.litecart.pages.Page;

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
}
