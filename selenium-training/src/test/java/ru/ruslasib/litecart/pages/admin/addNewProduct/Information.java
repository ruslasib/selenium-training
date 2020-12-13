package test.java.ru.ruslasib.litecart.pages.admin.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.ru.ruslasib.litecart.pages.Page;

public class Information extends Page {

  private WebDriver driver;

  public Information(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(name = "manufacturer_id")
  private WebElement manufacturerDropdown;

  @FindBy(name = "keywords")
  private WebElement keywordsField;

  @FindBy(css = "[name^=short_description]")
  private WebElement shortDescriptionField;

  @FindBy(css = ".trumbowyg-editor")
  private WebElement descriptionField;

  @FindBy(css = "[name^=head_title]")
  private WebElement headTitleField;

  @FindBy(css = "[name^=meta_description]")
  private WebElement metaDescriptionField;

  public void selectManufacturer(String manufacturer) {
    select(manufacturerDropdown, manufacturer);
  }

  public void inputKeywords(String keywords) {
    typeIn(keywordsField, keywords);
  }

  public void inputShortDescription(String shortDescription) {
    typeIn(shortDescriptionField, shortDescription);
  }

  public void inputDescription(String description) {
    typeIn(descriptionField, description);
  }

  public void inputHeadTitle(String headTitle) {
    typeIn(headTitleField, headTitle);
  }

  public void inputMetaDescription(String metaDescription) {
    typeIn(metaDescriptionField, metaDescription);
  }
}
