package test.java.ru.ruslasib.litecart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.ru.ruslasib.litecart.pages.Page;

import java.util.List;

public class Catalog extends Page {

  private WebDriver driver;

  public Catalog(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public void addNewProduct() {
    click(By.cssSelector("[href$=edit_product]"));
  }

  public void chooseCategory(String defaultCategory) {
    List<WebElement> categories = driver.findElements(By.cssSelector(".row td:nth-of-type(3) [href*=category_id]"));
    for (WebElement category : categories) {
      if (category.getAttribute("textContent").equals(defaultCategory)) {
        category.click();
      }
    }
  }

  public void chooseProduct(String productName) {
    List<WebElement> products = driver.findElements(By.cssSelector(".row td:nth-of-type(3) [href*=product_id]"));
    for (WebElement product : products) {
      if (product.getAttribute("textContent").equals(productName)) {
        product.click();
        return;
      }
    }
  }
}
