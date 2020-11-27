package test.java.ru.ruslasib.litecart.pages.admin.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.pages.Page;

public class AddNewProduct extends Page {

  private WebDriver driver;
  private General general;

  public AddNewProduct(WebDriver driver) {
    super(driver);
    this.driver = driver;
    general = new General(driver);
  }

  public General general() {
    return general;
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
