package test.java.ru.ruslasib.litecart.tests.pages.admin.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.tests.pages.Page;


public class LeftMenu extends Page {

  public LeftMenu(WebDriver driver) {
    super(driver);
  }

  public void appearance() {
    click(By.cssSelector("[href$=template]"));
  }

  public void catalog() {
    click(By.cssSelector("[href*=catalog]"));
  }

  public void customers() {
    click(By.cssSelector("[href$=customers]"));
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
