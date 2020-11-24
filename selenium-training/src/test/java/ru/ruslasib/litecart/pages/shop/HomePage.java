package test.java.ru.ruslasib.litecart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.ru.ruslasib.litecart.pages.Page;

import java.util.List;

public class HomePage extends Page {

  WebDriver driver;

  public HomePage(WebDriver driver) {
    super(driver);
    this.driver = driver;
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

  public void countries() {
    driver.findElement(By.cssSelector("[href$=countries]")).click();
  }

  public void goToHomePage() {
    driver.findElement(By.cssSelector(".logotype a"));
  }
}
