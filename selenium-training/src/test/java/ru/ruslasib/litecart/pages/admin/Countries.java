package test.java.ru.ruslasib.litecart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.ru.ruslasib.litecart.pages.Page;

import java.util.List;

public class Countries extends Page {

  WebDriver driver;

  public Countries(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public List<WebElement> countriesRows() {
    return driver.findElements(By.cssSelector("table.dataTable tr.row"));
  }
}
