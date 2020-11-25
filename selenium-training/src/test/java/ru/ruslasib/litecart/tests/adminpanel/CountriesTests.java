package test.java.ru.ruslasib.litecart.tests.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CountriesTests extends TestBase {

  @BeforeClass
  public void prepare() {
    litecartAdmin.leftMenu().countries();
  }

  @Test
  public void testCountriesArrangement() {
    List<WebElement> rows = litecartAdmin.countries().countriesRows();
    List<String> countriesNames = new ArrayList<>();
    for (WebElement row : rows) {
      countriesNames.add(row.findElement(By.cssSelector("td:nth-of-type(5)")).getAttribute("textContent"));
    }
    List<String> countriesNamesSorted = new ArrayList<>(countriesNames);
    countriesNamesSorted.sort(Comparator.naturalOrder());
    assertThat(countriesNamesSorted, equalTo(countriesNames));
  }

  @Test
  public void testZonesArrangement() {
    List<WebElement> rows = litecartAdmin.countries().countriesRows();
    List<WebElement> countriesWithZones = new ArrayList<>();
    List<Integer> rowNumbers = new ArrayList<>();
    int count = 1;
    for (WebElement row : rows) {
      if (Integer.parseInt(row.findElement(By.cssSelector("td:nth-of-type(6)")).getAttribute("textContent")) > 0) {
        countriesWithZones.add(rows.get(count));
        rowNumbers.add(count);
      }
      count = count + 1;
    }
    for (int rowNumber : rowNumbers) {
      litecartAdmin.leftMenu().countries();
      litecartAdmin.countries().editCountry(rowNumber);
      List<String> allZones = litecartAdmin.editCountry().allZones();
      List<String> allZonesSorted = new ArrayList<>(allZones);
      allZonesSorted.sort(Comparator.naturalOrder());
      assertThat(allZones, equalTo(allZonesSorted));
    }
  }
}
