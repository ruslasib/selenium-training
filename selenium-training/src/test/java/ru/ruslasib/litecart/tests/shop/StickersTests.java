package test.java.ru.ruslasib.litecart.tests.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StickersTests extends TestBase {

  @BeforeClass
  public void openShopPage() {
  }

  @Test
  public void testMostPopularStickers() {
    // находим всех уточек в разделе Most Popular
    List<WebElement> mostPopularItems = shop.homePage().mostPopularItems();
    List<String> stickersNames = new ArrayList<>();
    // находим стикеры у каждой из уточек и извлекаем названия стикеров
    mostPopularItems.forEach(item -> stickersNames.add(item.findElement(By.cssSelector("[class*=sticker]")).getText()));
    System.out.println("=================\nMost popular stickers:\n" + stickersNames + "\n=================");
    assertThat(stickersNames.size(), equalTo(mostPopularItems.size()));
  }

  @Test
  public void testCampaignsStickers() {
    // находим всех уточек в разделе Campaigns
    List<WebElement> campaignsItems = shop.homePage().campaignsItems();
    List<String> stickersNames = new ArrayList<>();
    // находим стикеры у каждой из уточек и извлекаем названия стикеров
    campaignsItems.forEach(item -> stickersNames.add(item.findElement(By.cssSelector("[class*=sticker]")).getText()));
    System.out.println("=================\nCampaigns stickers:\n" + stickersNames + "\n=================");
    assertThat(stickersNames.size(), equalTo(campaignsItems.size()));
  }

  @Test
  public void testLatestProductsStickers() {
    // находим всех уточек в разделе Latest Products
    List<WebElement> latestProductsItems = shop.homePage().latestProductsItems();
    List<String> stickersNames = new ArrayList<>();
    // находим стикеры у каждой из уточек и извлекаем названия стикеров
    latestProductsItems.forEach(item -> stickersNames.add(item.findElement(By.cssSelector("[class*=sticker]")).getText()));
    System.out.println("=================\nLatest products stickers:\n" + stickersNames + "\n=================");
    assertThat(stickersNames.size(), equalTo(latestProductsItems.size()));
  }
}
