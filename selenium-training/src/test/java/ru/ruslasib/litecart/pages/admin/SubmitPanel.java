package test.java.ru.ruslasib.litecart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.ru.ruslasib.litecart.pages.Page;

public class SubmitPanel extends Page {

  private WebDriver driver;

  public SubmitPanel(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(name = "save")
  private WebElement saveBtn;

  public void save() {
    click(saveBtn);
  }
}
