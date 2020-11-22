package test.java.ru.ruslasib.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Shop {

  private WebDriver driver;

  public Shop(WebDriver driver) {
    this.driver = driver;
  }

  public void launch() {
    driver.get("http://localhost/litecart/");
  }

  public List<WebElement> mostPopularItems() {
    return driver.findElements(By.cssSelector("#box-most-popular li"));
  }

  public List<WebElement> campaignsItems() {
    return driver.findElements(By.cssSelector("#box-campaigns li"));
  }

  public List<WebElement> latestProductsItems() {
    return driver.findElements(By.cssSelector("#box-latest-products li"));
  }
}
