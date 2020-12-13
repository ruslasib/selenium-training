package test.java.ru.ruslasib.litecart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.ru.ruslasib.litecart.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class LeftMenu extends Page {

  public LeftMenu(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "[href*=catalog]")
  private WebElement catalogBtn;

  public void appearance() {
    click(By.cssSelector("[href$=template]"));
  }

  public void catalog() {
    click(catalogBtn);
  }

  public void countries() {
    click(By.cssSelector("[href$=countries]"));
    wait.until(presenceOfElementLocated(By.tagName("h1")));

  }

  public void customers() {
    click(By.cssSelector("[href$=customers]"));
  }

  public void geoZones() {
    click(By.cssSelector("[href$=geo_zones]"));
  }

  public void languages() {
    click(By.cssSelector("#app- > [href$=languages]"));
  }

  public void modules() {
    click(By.cssSelector("#app- > [href$=jobs]"));
  }

  public void orders() {
    click(By.cssSelector("#app- > [href$=orders]"));
  }

  public void reports() {
    click(By.cssSelector("#app- > [href$=monthly_sales]"));
  }

  public void settings() {
    click(By.cssSelector("#app- > [href$=store_info]"));
  }

  public void tax() {
    click(By.cssSelector("#app- > [href$=tax_classes]"));
  }

  public void translations() {
    click(By.cssSelector("#app- > [href$=search]"));
  }

  public void vQmods() {
    click(By.cssSelector("#app- > [href$=vqmods]"));
  }
}
