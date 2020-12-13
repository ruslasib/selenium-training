package test.java.ru.ruslasib.litecart.pages.admin.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.ru.ruslasib.litecart.pages.Page;

import java.util.List;

public class General extends Page {

  private WebDriver driver;
  private WebDriverWait wait;

  public General(WebDriver driver) {
    super(driver);
    this.driver = driver;
    this.wait = wait;
  }

  public void inputName(String productName) {
    driver.findElement(By.cssSelector("[name^=name]")).clear();
    type(By.cssSelector("[name^=name]"), productName);
  }

  public void inputCode(String productCode) {
    driver.findElement(By.cssSelector("[name=code]")).clear();
    type(By.cssSelector("[name=code]"), productCode);
  }

  public void checkStatusRadioButton(String status) {
    String value = "";
    switch(status) {
      case "enabled":
        value = "1";
        break;
      case "disabled":
        value = "0";
        break;
    }
    checkRadioButton(By.cssSelector("[type=radio]"), value, "value");
  }

  public void selectDefaultCategory(String defaultCategory) {
    select(By.cssSelector("[name=default_category_id"), defaultCategory);
  }

  public void chooseCategoryCheckbox(String folder) {
    chooseCheckbox(By.xpath("//strong[.='Categories']/../div//*[@type='checkbox']"), folder, "data-name");
  }

  public void chooseGender(String gender) {
    /**
     * male has following values:
     * 1-2 - female
     * 1-1 - male
     * 1-3 - unisex
     */
    String genderCode = "";
    switch (gender) {
      case "female":
        genderCode = "1-2";
        break;
      case "male":
        genderCode = "1-1";
        break;
      case "unisex":
        genderCode = "1-3";
        break;
    }
    chooseCheckbox(By.cssSelector("[name^=product_groups]"), genderCode, "value");
  }

  public void inputQuantity(int quantity) {
    clear(By.cssSelector("[name=quantity]"));
    type(By.cssSelector("[name=quantity]"), Integer.toString(quantity));
  }

  public void selectQuantityUnit(String pieces) {
    select(By.cssSelector("[name=quantity_unit_id]"), pieces);
  }

  public void selectDeliveryStatus(String deliveryStatus) {
    select(By.cssSelector("[name=delivery_status_id]"), deliveryStatus);
  }

  public void selectSoldOutStatus(String soldOutStatus) {
    select(By.cssSelector("[name=sold_out_status_id]"), soldOutStatus);
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
