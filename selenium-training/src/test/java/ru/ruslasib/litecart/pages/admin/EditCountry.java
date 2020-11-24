package test.java.ru.ruslasib.litecart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.ru.ruslasib.litecart.pages.Page;

import java.util.ArrayList;
import java.util.List;

public class EditCountry extends Page {

  private WebDriver driver;

  public EditCountry(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public void goToHomePage() {
    driver.findElement(By.cssSelector(".logotype a"));
  }

  public List<String> allZones() {
    List<String> zonesNames = new ArrayList<>();
    List<WebElement> zones = driver.findElements(By.cssSelector("table.dataTable td:nth-of-type(3) > [type=hidden]"));
    zones.forEach(zone -> zonesNames.add(zone.getAttribute("value")));
    return zonesNames;
  }
}
