package test.java.ru.ruslasib.litecart.tests;

import org.openqa.selenium.WebDriver;
import test.java.ru.ruslasib.litecart.pages.admin.Countries;
import test.java.ru.ruslasib.litecart.pages.admin.EditCountry;
import test.java.ru.ruslasib.litecart.pages.admin.LoginPage;
import test.java.ru.ruslasib.litecart.pages.admin.main.EditGeoZone;
import test.java.ru.ruslasib.litecart.pages.admin.main.GeoZones;
import test.java.ru.ruslasib.litecart.pages.admin.main.LeftMenu;
import test.java.ru.ruslasib.litecart.pages.shop.HomePage;

public class LitecartAdmin {

  private WebDriver driver;
  private LoginPage loginPage;
  private HomePage homePage;
  private LeftMenu leftMenu;
  private Countries countries;
  private EditCountry editCountry;
  private GeoZones geoZones;
  private EditGeoZone editGeoZone;

  public LitecartAdmin(WebDriver driver) {
    this.driver = driver;
  }

  public void launch() {
    driver.get("http://localhost/litecart/admin/login.php/");
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    leftMenu = new LeftMenu(driver);
    countries = new Countries(driver);
    editCountry = new EditCountry(driver);
    geoZones = new GeoZones(driver);
    editGeoZone = new EditGeoZone(driver);
  }

  public LoginPage loginPage() {
    return loginPage;
  }

  public HomePage homePage() {
    return homePage;
  }

  public LeftMenu leftMenu() {
    return leftMenu;
  }

  public Countries countries() {
    return countries;
  }

  public EditCountry editCountry() {
    return editCountry;
  }

  public GeoZones geoZones() {
    return geoZones;
  }

  public EditGeoZone editGeoZone() {
    return editGeoZone;
  }
}
