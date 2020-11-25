package test.java.ru.ruslasib.litecart.tests.adminpanel;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GeoZonesTests extends TestBase {

  @BeforeClass
  public void prepare() {
  }

  @Test
  public void testGeoZonesArrangement() {
    litecartAdmin.homePage().geoZones();
    List<WebElement> allZonesRows = litecartAdmin.geoZones().allZonesRows();
    int count = 1;
    for (WebElement zone : allZonesRows) {
      litecartAdmin.homePage().geoZones();
      litecartAdmin.geoZones().editGeoZone(count);
      List<String> allZonesNames = litecartAdmin.editGeoZone().allZonesNames();
      List<String> allZonesNamesSorted = new ArrayList<>(allZonesNames);
      allZonesNamesSorted.sort(Comparator.naturalOrder());
      count = count + 1;
      assertThat(allZonesNames, equalTo(allZonesNamesSorted));
    }
  }
}
