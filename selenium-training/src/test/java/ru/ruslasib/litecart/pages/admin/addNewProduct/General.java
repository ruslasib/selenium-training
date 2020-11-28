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

  public void inputName(String productName) {
    driver.findElement(By.cssSelector("[name^=name]")).clear();
    type(By.cssSelector("[name^=name]"), productName);
  }

  public void inputCode(String productCode) {
    driver.findElement(By.cssSelector("[name=code]")).clear();
    type(By.cssSelector("[name=code]"), productCode);
  }

  public void checkStatusRadioButton(String radioButtonValue) {
    checkRadioButton(By.cssSelector("[type=radio]"), radioButtonValue, "value");
  }

  public void selectDefaultCategory(String defaultCategory) {
    click(By.cssSelector("[name=default_category_id"));
    chooseElementFromDropbox(By.cssSelector("[inputName=default_category_id] option"), defaultCategory, "textContent");
  }

  public void chooseCategoryCheckbox(String folder) {
    chooseCheckbox(By.xpath("//strong[.='Categories']/../div//*[@type='checkbox']"), folder, "data-name");
  }

  public void chooseGender(String genderCode) {
    /**
     * male has following values:
     * 1-2 - Female
     * 1-1 - Male
     * 1-3 - Unisex
     */
    chooseCheckbox(By.cssSelector("[name^=product_groups]"), genderCode, "value");
  }

  public void inputQuantity(String quantity) {
    clear(By.cssSelector("[name=quantity]"));
    type(By.cssSelector("[name=quantity]"), quantity);
  }

  public void selectQuantityUnit(String pieces) {
    click(By.cssSelector("[name=quantity_unit_id]"));
    chooseElementFromDropbox(By.cssSelector("[name=quantity_unit_id] option"), pieces, "textContent");
  }

  public void selectDeliveryStatus(String deliveryStatus) {
    click(By.cssSelector("[name=delivery_status_id]"));
    chooseElementFromDropbox(By.cssSelector("[delivery_status_id] option"), deliveryStatus, "textContent");
  }

  public void selectSoldOutStatus(String soldOutStatus) {
    click(By.cssSelector("[name=sold_out_status_id]"));
    chooseElementFromDropbox(By.cssSelector("[name=sold_out_status_id]"), soldOutStatus, "textContent");
  }

  public void uploadFiles(String pathToFile) {
    driver.findElement(By.cssSelector("[type=file]")).sendKeys(System.getProperty("user.dir") + pathToFile);
  }

  public void inputDateValidFrom(String dateFrom) {
    inputDate(By.cssSelector("[name=date_valid_from]"), dateFrom);
  }

  public void inputDateValidTo(String dateTo) {
    inputDate(By.cssSelector("[name=date_valid_to]"), dateTo);
  }
}
