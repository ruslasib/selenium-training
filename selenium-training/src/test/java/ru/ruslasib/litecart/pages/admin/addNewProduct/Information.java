package test.java.ru.ruslasib.litecart.pages.admin.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.pages.Page;

public class Information extends Page {

  private WebDriver driver;

  public Information(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public void selectManufacturer(String manufacturer) {
    click(By.cssSelector("[name=manufacturer_id]"));
    chooseElementFromDropbox(By.cssSelector("[name=manufacturer_id] option"), manufacturer, "textContent");
  }

  public void inputKeywords(String keywords) {
    type(By.cssSelector("[name=keywords]"), keywords);
  }

  public void inputShortDescription(String shortDescription) {
    type(By.cssSelector("[name^=short_description]"), shortDescription);
  }

  public void inputDescription(String description) {
    type(By.cssSelector(".trumbowyg-editor"), description);
  }

  public void inputHeadTitle(String headTitle) {
    type(By.cssSelector("[name^=head_title]"), headTitle);
  }

  public void inputMetaDescription(String metaDescription) {
    type(By.cssSelector("[name^=meta_description]"), metaDescription);
  }
}
