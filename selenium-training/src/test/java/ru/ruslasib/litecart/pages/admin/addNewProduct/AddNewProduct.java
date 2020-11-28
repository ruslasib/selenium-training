package test.java.ru.ruslasib.litecart.pages.admin.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.pages.Page;

public class AddNewProduct extends Page {

  private WebDriver driver;
  private General general;
  private Information information;
  private Prices prices;

  public AddNewProduct(WebDriver driver) {
    super(driver);
    this.driver = driver;
    general = new General(driver);
    information = new Information(driver);
    prices = new Prices(driver);
  }

  public General general() {
    return general;
  }

  public Information information() {
    return information;
  }

  public Prices prices() {
    return prices;
  }

  public void generalTab() {
    click(By.cssSelector("[href$=tab-general]"));
  }

  public void informationTab() {
    click(By.cssSelector("[href$=tab-information]"));

  }

  public void pricesTab() {
    click(By.cssSelector("[href$=tab-prices]"));
  }
}
