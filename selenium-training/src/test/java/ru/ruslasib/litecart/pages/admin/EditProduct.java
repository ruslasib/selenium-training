package test.java.ru.ruslasib.litecart.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.ru.ruslasib.litecart.pages.Page;

public class EditProduct extends Page {

  private WebDriver driver;

  public EditProduct(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "[name^=name]")
  private WebElement nameField;

  @FindBy(name = "code")
  private WebElement codeField;

  public String nameFieldValue() {
    return nameField.getAttribute("value");
  }

  public String codeFieldValue() {
    return codeField.getAttribute("value");
  }
}
