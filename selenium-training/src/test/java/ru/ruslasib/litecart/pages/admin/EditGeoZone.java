package test.java.ru.ruslasib.litecart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.ru.ruslasib.litecart.pages.Page;

import java.util.ArrayList;
import java.util.List;

public class EditGeoZone extends Page {

  WebDriver driver;

  public EditGeoZone(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }


  public List<String> allZonesNames() {
    List<String> zoneNames = new ArrayList<>();
    List<WebElement> zones = driver.findElements(By.cssSelector("[inputName*=zone_code] > [selected=selected]"));
    zones.forEach(zone -> zoneNames.add(zone.getAttribute("textContent")));
    return zoneNames;
  }
}
