package test.java.ru.ruslasib.litecart.tests;

import org.testng.annotations.DataProvider;
import test.java.ru.ruslasib.litecart.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static test.java.ru.ruslasib.Helper.generateCode;
import static test.java.ru.ruslasib.Helper.generateName;

public class StaticDataProvider {

  @DataProvider(name = "testNewProductAddition")
  public static Iterator<Object[]> productData() {
    List<Object[]> products = new ArrayList<>();
    products.add(new Product[]{new Product()
            .withName(generateName())
            .withCode(generateCode())
            .withStatus("enabled")
            .withCategory("Rubber Ducks")
            .withGender("male")
            .withQuantity(3)
            .withQuantityUnit("pcs")
            .withDeliveryStatus("3-5 days")
            .withSoldOutStatus("Temporary sold out")
            .withImageIn("\\selenium-training\\src\\test\\java\\ru\\ruslasib\\resource\\duck.jpg")
            .withDateValidFrom("01/11/2020")
            .withDateValidTo("31/10/2021")
            .withManufacturer("ACME Corp.")
            .withKeywords("keywords about super duck")
            .withShortDescription("short description of super duck")
            .withDescription("description of super duck")
            .withHeadTitle("head title of super duck")
            .withMetaDescription("meta description of super duck")
            .withPurchasePrice(12)
            .withCurrency("Euros")
            .withPriceUSD(17)
            .withPriceEUR(15)});
    return products.iterator();
  }

  @DataProvider(name = "quantityOfProducts")
  private Object[] productQuantity() {
    return new Object[] {new Integer(3)};
  }
}
