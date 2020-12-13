package test.java.ru.ruslasib.litecart.model;

public class Product {

  private String name;
  private String code;

  public Product withName(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public Product withCode(String code) {
    this.code = code;
    return this;
  }

  public String getCode() {
    return code;
  }
}
