package test.java.ru.ruslasib.litecart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.pages.Page;

public class EditProduct extends Page {

  private WebDriver driver;

  public EditProduct(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public String name() {
    return driver.findElement(By.cssSelector("[name^=name]")).getAttribute("value");
  }

  public String code() {
    return driver.findElement(By.name("code")).getAttribute("value");
  }
}
