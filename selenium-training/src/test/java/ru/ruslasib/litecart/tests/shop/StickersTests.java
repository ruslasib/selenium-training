package test.java.ru.ruslasib.litecart.tests.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StickersTests extends TestBase {

  @BeforeClass
  public void launch() {
    driver.get("http://localhost/litecart/");
  }

  @Test
  public void testMostPopularStickers() {
    // находим всех уточек в разделе Most Popular
    List<WebElement> mostPopularItems = driver.findElements(By.cssSelector("#box-most-popular li"));

    // проверяем, что у каждой уточки ровно по одному стикеру
    for (WebElement element : mostPopularItems) {
      assertThat(element.findElements(By.cssSelector("[class*=sticker]")).size(), equalTo(1));
    }
  }

  @Test
  public void testCampaignsStickers() {
    // находим всех уточек в разделе Most Popular
    List<WebElement> mostPopularItems = driver.findElements(By.cssSelector("#box-campaigns li"));

    // проверяем, что у каждой уточки ровно по одному стикеру
    for (WebElement element : mostPopularItems) {
      assertThat(element.findElements(By.cssSelector("[class*=sticker]")).size(), equalTo(1));
    }
  }

  @Test
  public void testLatestProductsStickers() {
    // находим всех уточек в разделе Most Popular
    List<WebElement> mostPopularItems = driver.findElements(By.cssSelector("#box-latest-products li"));

    // проверяем, что у каждой уточки ровно по одному стикеру
    for (WebElement element : mostPopularItems) {
      assertThat(element.findElements(By.cssSelector("[class*=sticker]")).size(), equalTo(1));
    }
  }
}
