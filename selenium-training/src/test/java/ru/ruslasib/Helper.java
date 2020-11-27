package test.java.ru.ruslasib;

public class Helper {

  public static String generateEmail() {
    return "ruslan"
            + (int)(Math.random() * 1000000)
            + "@sibgatullin.ru";
  }
}
