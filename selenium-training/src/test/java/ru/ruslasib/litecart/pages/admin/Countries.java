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

  public void editCountry(int rowNumber) {
    driver.findElement(By.cssSelector("table.dataTable tr:nth-of-type(" + (rowNumber + 1) + ") td:last-child a")).click();
  }

  public void editCountry(String countryName) {
    List<WebElement> countries = driver.findElements(By.cssSelector(".row > td:nth-of-type(5) >a"));
    for (WebElement country : countries) {
      if (country.getAttribute("textContent").equals(countryName)) {
        country.click();
        return;
      }
    }
  }

  public WebElement header() {
    return driver.findElement(By.tagName("h1"));
  }
}
