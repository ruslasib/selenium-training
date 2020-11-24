package test.java.ru.ruslasib.litecart.pages.admin.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.ru.ruslasib.litecart.pages.Page;

import java.util.List;

public class GeoZones extends Page {

  WebDriver driver;

  public GeoZones(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }


  public List<WebElement> allZonesRows() {
    return driver.findElements(By.cssSelector("tr.row"));
  }

  public void editGeoZone(int rowNumber) {
    driver.findElement(By.cssSelector("tr:nth-of-type(" + (rowNumber + 1) +") [title=Edit]")).click();
  }
}
