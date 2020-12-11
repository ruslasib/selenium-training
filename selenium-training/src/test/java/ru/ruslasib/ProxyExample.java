package test.java.ru.ruslasib;

import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import test.java.ru.ruslasib.litecart.tests.TestBase;

import java.util.concurrent.TimeUnit;

public class ProxyExample extends TestBase {

  @Test
  public void myFirstTest() {
    proxy.newHar();
    driver.get("http://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    Har har = proxy.endHar();
    har.getLog().getEntries().forEach(h -> System.out.println(h.getTime(TimeUnit.SECONDS) + ": "
            + h.getResponse().getStatus() + " " + h.getRequest().getMethod() + " " + h.getRequest().getUrl()));
  }
}
