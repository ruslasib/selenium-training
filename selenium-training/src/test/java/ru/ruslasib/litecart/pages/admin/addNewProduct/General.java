package test.java.ru.ruslasib.litecart.pages.admin.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import test.java.ru.ruslasib.litecart.pages.Page;

import java.util.List;

public class General extends Page {

  private WebDriver driver;

  public General(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public void name(String productName) {
    driver.findElement(By.cssSelector("[name^=name]")).clear();
    type(By.cssSelector("[name^=name]"), productName);
  }

  public void code(String productCode) {
    driver.findElement(By.cssSelector("[name=code]")).clear();
    type(By.cssSelector("[name=code]"), productCode);
  }

  public void checkStatusRadioButton(String radioButtonValue) {
    checkRadioButton(By.cssSelector("[type=radio]"), radioButtonValue, "value");
  }

  public void chooseDefaultCategory(String defaultCategory) {
    click(By.cssSelector("[name=default_category_id"));
    chooseElementFromDropbox(By.cssSelector("[name=default_category_id] option"), defaultCategory, "textContent");
  }

  public void chooseCategoryCheckbox(String folder) {
    chooseCheckbox(By.xpath("//strong[.='Categories']/../div//*[@type='checkbox']"), folder, "data-name");
  }

  public void chooseGender(String male) {
    /**
     * male has following values:
     * 1-2 - Female
     * 1-1 - Male
     * 1-3 - Unisex
     */
    chooseCheckbox(By.cssSelector("[name^=product_groups]"), male, "value");
  }

  public void inputQuantity(String quantity) {
    clear(By.cssSelector("[name=quantity]"));
    type(By.cssSelector("[name=quantity]"), quantity);
  }

  public void chooseQuantityUnit(String pieces) {
    click(By.cssSelector("[name=quantity_unit_id]"));
    chooseElementFromDropbox(By.cssSelector("[name=quantity_unit_id] option"), pieces, "textContent");
  }

  public void chooseDeliveryStatus(String deliveryStatus) {
    click(By.cssSelector("[name=delivery_status_id]"));
    chooseElementFromDropbox(By.cssSelector("[delivery_status_id] option"), deliveryStatus, "textContent");
  }

  public void chooseSoldOutStatus(String soldOutStatus) {
    click(By.cssSelector("[name=sold_out_status_id]"));
    chooseElementFromDropbox(By.cssSelector("[name=sold_out_status_id]"), soldOutStatus, "textContent");
  }

  public void uploadFiles(String pathToFile) {
    driver.findElement(By.cssSelector("[type=file]")).sendKeys(System.getProperty("user.dir") + pathToFile);
  }

  public void inputDateValidFrom(String dateFrom) {
    Actions action = new Actions(driver);
    action.moveToElement(driver.findElement(By.cssSelector("[name=date_valid_from]")))
            .moveByOffset(1, 1)
            .sendKeys(dateFrom.replaceAll("^0-9", ""))
            .perform();
//    click(By.cssSelector("[name=date_valid_from]"));
//    type(By.cssSelector("[name=date_valid_from]"), dateFrom.replaceAll("^0-9", ""));
  }

  public void inputDateValidTo(String dateTo) {
    type(By.cssSelector("[name=date_valid_to]"), dateTo.replaceAll("^0-9", ""));
  }
}
