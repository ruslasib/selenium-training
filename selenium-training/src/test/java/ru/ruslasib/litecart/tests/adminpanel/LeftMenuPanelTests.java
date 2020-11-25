package test.java.ru.ruslasib.litecart.tests.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LeftMenuPanelTests extends TestBase {

  @BeforeClass
  public void prepare() {
    litecartAdmin.launch();
    litecartAdmin.loginPage().login("admin", "admin");
  }

  @Test
  public void testAppearance() {
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=template]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Template"));
  }

  @Test
  public void testAppearanceTemplate() {
    litecartAdmin.leftMenu().appearance();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-template > [href$=template]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Template"));
  }

  @Test
  public void testAppearanceLogotype() {
    litecartAdmin.leftMenu().appearance();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=logotype]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Logotype"));
  }

  @Test
  public void testCatalog() {
    litecartAdmin.leftMenu().click(By.cssSelector("#app- > [href$=catalog]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Catalog"));
  }

  @Test
  public void testCatalogCatalog() {
    litecartAdmin.leftMenu().catalog();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-catalog > [href$=catalog]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Catalog"));
  }


  @Test
  public void testCatalogProductGroups() {
    litecartAdmin.leftMenu().catalog();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=product_groups]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Product Groups"));
  }

  @Test
  public void testCatalogOptionGroups() {
    litecartAdmin.leftMenu().catalog();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=option_groups]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Option Groups"));
  }

  @Test
  public void testCatalogManufacturers() {
    litecartAdmin.leftMenu().catalog();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=manufacturers]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Manufacturers"));
  }

  @Test
  public void testCatalogSuppliers() {
    litecartAdmin.leftMenu().catalog();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=suppliers]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Suppliers"));
  }

  @Test
  public void testCatalogDeliveryStatuses() {
    litecartAdmin.leftMenu().catalog();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=delivery_statuses]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Delivery Statuses"));
  }

  @Test
  public void testCatalogSoldOutStatuses() {
    litecartAdmin.leftMenu().catalog();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=sold_out_statuses]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Sold Out Statuses"));
  }

  @Test
  public void testCatalogQuantityUnits() {
    litecartAdmin.leftMenu().catalog();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=quantity_units]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Quantity Units"));
  }

  @Test
  public void testCatalogCSVImportExport() {
    litecartAdmin.leftMenu().catalog();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-csv > [href$=csv]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("CSV Import/Export"));
  }

  @Test
  public void testCountries() {
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=countries]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Countries"));
  }

  @Test
  public void testCurrencies() {
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=currencies]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Currencies"));
  }

  @Test
  public void testCustomers() {
    litecartAdmin.leftMenu().click(By.cssSelector("#app- > [href$=customers]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Customers"));
  }

  @Test
  public void testCustomersCustomers() {
    litecartAdmin.leftMenu().customers();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-customers > [href$=customers]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Customers"));
  }

  @Test
  public void testCustomersCSVImportExport() {
    litecartAdmin.leftMenu().customers();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-csv > [href$=csv]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("CSV Import/Export"));
  }

  @Test
  public void testCustomersNewsletter() {
    litecartAdmin.leftMenu().customers();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=newsletter]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Newsletter"));
  }

  @Test
  public void testGeoZones() {
    litecartAdmin.leftMenu().click(By.cssSelector("#app- > [href$=geo_zones]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Geo Zones"));
  }

  @Test
  public void testLanguages() {
    litecartAdmin.leftMenu().click(By.cssSelector("#app- > [href$=languages]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Languages"));
  }

  @Test
  public void testLanguagesLanguages() {
    litecartAdmin.leftMenu().languages();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-languages > [href$=languages]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Languages"));
  }

  @Test
  public void testLanguagesStorageEncoding() {
    litecartAdmin.leftMenu().languages();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-storage_encoding > [href$=storage_encoding]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Storage Encoding"));
  }

  @Test
  public void testModules() {
    litecartAdmin.leftMenu().click(By.cssSelector("#app- > [href$=jobs]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Job Modules"));
  }

  @Test
  public void testModulesBackgroundJobs() {
    litecartAdmin.leftMenu().modules();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-jobs > [href$=jobs"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Job Modules"));
  }

  @Test
  public void testModulesCustomerModules() {
    litecartAdmin.leftMenu().modules();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-customer > [href$=customer]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Customer Modules"));
  }

  @Test
  public void testModulesShippingModules() {
    litecartAdmin.leftMenu().modules();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-shipping > [href$=shipping]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Shipping Modules"));
  }

  @Test
  public void testModulesPaymentModules() {
    litecartAdmin.leftMenu().modules();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-payment > [href$=payment]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Payment Modules"));
  }

  @Test
  public void testModulesOrderTotalModules() {
    litecartAdmin.leftMenu().modules();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=order_total]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Order Total Modules"));
  }

  @Test
  public void testModulesOrderSuccessModules() {
    litecartAdmin.leftMenu().modules();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=order_success]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Order Success Modules"));
  }

  @Test
  public void testModulesOrderActionModules() {
    litecartAdmin.leftMenu().modules();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=order_action]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Order Action Modules"));
  }

  @Test
  public void testOrders() {
    litecartAdmin.leftMenu().click(By.cssSelector("#app- > [href$=orders]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Orders"));
  }

  @Test
  public void testOrdersOrders() {
    litecartAdmin.leftMenu().orders();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-orders > [href$=orders]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Orders"));
  }

  @Test
  public void testPages() {
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=pages]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Pages"));
  }

  @Test
  public void testReports() {
    litecartAdmin.leftMenu().click(By.cssSelector("#app- > [href$=monthly_sales]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Monthly Sales"));
  }

  @Test
  public void testReportsMonthlySales() {
    litecartAdmin.leftMenu().reports();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-monthly_sales > [href$=monthly_sales]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Monthly Sales"));
  }

  @Test
  public void testReportsMostSoldProducts() {
    litecartAdmin.leftMenu().reports();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=most_sold_products]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Most Sold Products"));
  }

  @Test
  public void testReportsMostShoppingCustomers() {
    litecartAdmin.leftMenu().reports();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-most_shopping_customers > [href$=most_shopping_customers]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Most Shopping Customers"));
  }

  @Test
  public void testSettings() {
    litecartAdmin.leftMenu().click(By.cssSelector("#app- > [href$=store_info]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Settings"));
  }

  @Test
  public void testSettingsStoreInfo() {
    litecartAdmin.leftMenu().settings();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-store_info > [href$=store_info]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Settings"));
  }

  @Test
  public void testSettingsDefaults() {
    litecartAdmin.leftMenu().settings();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=defaults]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Settings"));
  }

  @Test
  public void testSettingsGeneral() {
    litecartAdmin.leftMenu().settings();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=general]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Settings"));
  }

  @Test
  public void testSettingsListings() {
    litecartAdmin.leftMenu().settings();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=listings]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Settings"));
  }

  @Test
  public void testSettingsImages() {
    litecartAdmin.leftMenu().settings();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=images]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Settings"));
  }

  @Test
  public void testSettingsCheckout() {
    litecartAdmin.leftMenu().settings();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=checkout]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Settings"));
  }

  @Test
  public void testSettingsAdvanced() {
    litecartAdmin.leftMenu().settings();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=advanced]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Settings"));
  }

  @Test
  public void testSettingsSecurity() {
    litecartAdmin.leftMenu().settings();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=security]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Settings"));
  }

  @Test
  public void testSlides() {
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=slides]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Slides"));
  }

  @Test
  public void testTax() {
    litecartAdmin.leftMenu().click(By.cssSelector("#app- > [href$=tax_classes]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Tax Classes"));
  }

  @Test
  public void testTaxTaxClasses() {
    litecartAdmin.leftMenu().tax();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-tax_classes > [href$=tax_classes]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Tax Classes"));
  }

  @Test
  public void testTaxTaxRates() {
    litecartAdmin.leftMenu().tax();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=tax_rates]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Tax Rates"));
  }

  @Test
  public void testTranslations() {
    litecartAdmin.leftMenu().click(By.cssSelector("#app- > [href$=search]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Search Translations"));
  }

  @Test
  public void testTranslationsSearchTranslations () {
    litecartAdmin.leftMenu().translations();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-search > [href$=search]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Search Translations"));
  }

  @Test
  public void testTranslationsScanFilesForTranslations () {
    litecartAdmin.leftMenu().translations();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-scan > [href$=scan]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Scan Files For Translations"));
  }

  @Test
  public void testTranslationsCSVImportExport () {
    litecartAdmin.leftMenu().translations();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-csv > [href$=csv]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("CSV Import/Export"));
  }

  @Test
  public void testUsers() {
    litecartAdmin.leftMenu().click(By.cssSelector("[href$=users]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("Users"));
  }

  @Test
  public void testVQmods() {
    litecartAdmin.leftMenu().click(By.cssSelector("#app- > [href$=vqmods]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("vQmods"));
  }

  @Test
  public void testVQmodsVQmods () {
    litecartAdmin.leftMenu().vQmods();
    wait.until(presenceOfElementLocated(By.tagName("h1")));
    litecartAdmin.leftMenu().click(By.cssSelector("#doc-vqmods > [href$=vqmods]"));
    WebElement header = wait.until(presenceOfElementLocated(By.tagName("h1")));
    assertThat(header.getText(), equalTo("vQmods"));
  }
}
