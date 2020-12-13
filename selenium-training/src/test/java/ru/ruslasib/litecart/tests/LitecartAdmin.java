package test.java.ru.ruslasib.litecart.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.ru.ruslasib.litecart.pages.admin.*;
import test.java.ru.ruslasib.litecart.pages.admin.addNewProduct.AddNewProduct;
import test.java.ru.ruslasib.litecart.pages.admin.LeftMenu;
import test.java.ru.ruslasib.litecart.pages.shop.HomePage;

public class LitecartAdmin {

  private WebDriver driver;
  private WebDriverWait wait;
  private LoginPage loginPage;
  private HomePage homePage;
  private LeftMenu leftMenu;
  private Countries countries;
  private EditCountry editCountry;
  private GeoZones geoZones;
  private EditGeoZone editGeoZone;
  private Catalog catalog;
  private AddNewProduct addNewProduct;
  private EditProduct editProduct;
  private SubmitPanel submitPanel;

  public LitecartAdmin(WebDriver driver) {
    this.driver = driver;
  }

  public void launch() {
    driver.get("http://localhost/litecart/admin/login.php/");
    wait = new WebDriverWait(driver, 5);
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    leftMenu = new LeftMenu(driver);
    countries = new Countries(driver);
    editCountry = new EditCountry(driver);
    geoZones = new GeoZones(driver);
    editGeoZone = new EditGeoZone(driver);
    catalog = new Catalog(driver);
    addNewProduct = new AddNewProduct(driver, wait);
    editProduct = new EditProduct(driver);
    submitPanel = new SubmitPanel(driver);
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

  public Catalog catalog() {
    return catalog;
  }

  public AddNewProduct addNewProduct() {
    return addNewProduct;
  }

  public EditProduct editProduct() {
    return editProduct;
  }

  public SubmitPanel submitPanel() {
    return submitPanel;
  }
}
