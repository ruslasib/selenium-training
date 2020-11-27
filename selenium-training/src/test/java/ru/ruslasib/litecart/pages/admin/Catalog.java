package test.java.ru.ruslasib.litecart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.pages.Page;

public class Catalog extends Page {

  private WebDriver driver;

  public Catalog(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public void addNewProduct() {
    click(By.cssSelector("[href$=edit_product]"));
  }
}
