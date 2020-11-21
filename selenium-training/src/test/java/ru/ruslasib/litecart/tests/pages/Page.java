package test.java.ru.ruslasib.litecart.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {

  private WebDriver driver;

  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void type(By locator, String inputText) {
    driver.findElement(locator).sendKeys(inputText);
  }
}
