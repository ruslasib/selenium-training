package test.java.ru.ruslasib;

public class Helper {

  public static String generateEmail() {
    return "ruslan"
            + (int)(Math.random() * 1000000)
            + "@sibgatullin.ru";
  }

  public static String generateName() {
    return "Super Duck" + (int)(Math.random() * 1000000);
  }

  public static String generateCode() {
    return "V" + (int)(Math.random() * 1000000);
  }
}
