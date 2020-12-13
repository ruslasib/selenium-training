package test.java.ru.ruslasib.litecart.pages.admin.addNewProduct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "[name^=name]")
  private WebElement nameField;

  @FindBy(css = "[name=code]")
  private WebElement codeField;

  @FindBy(css = "[type=radio][value='1']")
  private WebElement EnabledRadioBtn;

  @FindBy(css = "[type=radio][value='0']")
  private WebElement DisabledRadioBtn;

  @FindBy(xpath = "//strong[.='Categories']/../div//*[@type='checkbox']")
  private List<WebElement> categoriesCheckBoxes;

  @FindBy(css = "[name=default_category_id")
  private WebElement defaultCategoryDropdown;

  @FindBy(css = "[name^=product_groups]")
  private List<WebElement> genderCheckboxes;

  @FindBy(css = "[name^=product_groups][value='1-2']")
  private WebElement femaleCheckbox;

  @FindBy(css = "[name^=product_groups][value='1-1']")
  private WebElement maleCheckbox;

  @FindBy(css = "[name^=product_groups][value='1-3']")
  private WebElement unisexCheckbox;

  @FindBy(name = "quantity")
  private WebElement quantityField;

  @FindBy(css = "[name=quantity_unit_id]")
  private WebElement quantityUnitDropdown;

  @FindBy(css = "[name=delivery_status_id]")
  private WebElement deliveryStatusDropdown;

  @FindBy(css = "[name=sold_out_status_id]")
  private WebElement soldOutStatusDropdown;

  @FindBy(css = "[type=file]")
  private WebElement uploadFilesField;

  @FindBy(name = "date_valid_from")
  private WebElement dateValidFromField;

  @FindBy(name = "date_valid_to")
  private WebElement dateValidToField;

  public void inputName(String productName) {
    nameField.sendKeys(productName);
  }

  public void inputCode(String productCode) {
    codeField.sendKeys(productCode);
  }

  public void checkStatusRadioButton(String status) {
    WebElement radioBtn = null;
    switch(status) {
      case "enabled":
        radioBtn = EnabledRadioBtn;
        break;
      case "disabled":
        radioBtn = DisabledRadioBtn;
        break;
    }
    radioBtn.click();
  }

  public void selectDefaultCategory(String category) {
    select(defaultCategoryDropdown, category);
  }

  public void chooseCategoryCheckbox(String folder) {
    chooseCheckbox(categoriesCheckBoxes, folder, "data-name");
  }

  public void chooseGender(String gender) {
    WebElement genderCheckbox = null;
    switch (gender) {
      case "female":
        genderCheckbox = femaleCheckbox;
        break;
      case "male":
        genderCheckbox = maleCheckbox;
        break;
      case "unisex":
        genderCheckbox = unisexCheckbox;
        break;
    }
    genderCheckbox.click();
  }

  public void inputQuantity(int quantity) {
    typeIn(quantityField, quantity);
  }

  public void selectQuantityUnit(String pieces) {
    select(quantityUnitDropdown, pieces);
  }

  public void selectDeliveryStatus(String deliveryStatus) {
    select(deliveryStatusDropdown, deliveryStatus);
  }

  public void selectSoldOutStatus(String soldOutStatus) {
    select(soldOutStatusDropdown, soldOutStatus);
  }

  public void uploadFiles(String pathToFile) {
    uploadFilesField.sendKeys(System.getProperty("user.dir") + pathToFile);
  }

  public void inputDateValidFrom(String dateFrom) {
    inputDate(dateValidFromField, dateFrom);
  }

  public void inputDateValidTo(String dateTo) {
    inputDate(dateValidToField, dateTo);
  }
}
