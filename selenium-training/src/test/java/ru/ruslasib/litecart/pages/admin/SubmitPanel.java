package test.java.ru.ruslasib.litecart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.pages.Page;

public class SubmitPanel extends Page {

  private WebDriver driver;

  public SubmitPanel(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public void save() {
    click(By.name("save"));
  }
}
