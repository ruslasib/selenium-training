package test.java.ru.ruslasib.litecart.model;

public class Product {

  private String name;
  private String code;
  private String status;
  private String category;
  private String gender;
  private int quantity;
  private String quantityUnit;
  private String deliveryStatus;
  private String soldOutStatus;
  private String image;
  private String dateValidFrom;
  private String dateValidTo;
  private String manufacturer;
  private String keywords;
  private String shortDescription;
  private String description;
  private String headTitle;
  private String metaDescription;
  private int purchasePrice;
  private String currency;
  private int priceUSD;
  private int priceEUR;


  public Product withName(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  /**
   * @param code can has two values: enabled, disabled
   */
  public Product withCode(String code) {
    this.code = code;
    return this;
  }

  public String getCode() {
    return code;
  }

  public Product withStatus(String status) {
    this.status = status;
    return this;
  }

  public String getStatus() {
    return status;
  }

  public Product withCategory(String category) {
    this.category = category;
    return this;
  }

  public String getCategory() {
    return category;
  }

  public Product withGender(String gender) {
    this.gender = gender;
    return this;
  }

  public String getGender() {
    return gender;
  }

  public Product withQuantity(int quantity) {
    this.quantity = quantity;
    return this;
  }

  public int getQuantity() {
    return quantity;
  }

  public Product withQuantityUnit(String quantityUnit) {
    this.quantityUnit = quantityUnit;
    return this;
  }

  public String getQuantityUnit() {
    return quantityUnit;
  }

  public Product withDeliveryStatus(String deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
    return this;
  }

  public String getDeliveryStatus() {
    return deliveryStatus;
  }

  public Product withSoldOutStatus(String soldOutStatus) {
    this.soldOutStatus = soldOutStatus;
    return this;
  }

  public String getSoldOutStatus() {
    return soldOutStatus;
  }

  public Product withImageIn(String image) {
    this.image = image;
    return this;
  }

  public String getImage() {
    return image;
  }

  public Product withDateValidFrom(String dateValidFrom) {
    this.dateValidFrom = dateValidFrom;
    return this;
  }

  public String getDateValidFrom() {
    return dateValidFrom;
  }

  public Product withDateValidTo(String dateValidTo) {
    this.dateValidTo = dateValidTo;
    return this;
  }

  public String getDateValidTo() {
    return dateValidTo;
  }

  public Product withManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
    return this;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public Product withKeywords(String keywords) {
    this.keywords = keywords;
    return this;
  }

  public String getKeywords() {
    return keywords;
  }

  public Product withShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
    return this;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public Product withDescription(String description) {
    this.description = description;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Product withHeadTitle(String headTitle) {
    this.headTitle = headTitle;
    return this;
  }

  public String getHeadTitle() {
    return headTitle;
  }

  public Product withMetaDescription(String metaDescription) {
    this.metaDescription = metaDescription;
    return this;
  }

  public String getMetaDescription() {
    return metaDescription;
  }

  public Product withPurchasePrice(int purchasePrice) {
    this.purchasePrice = purchasePrice;
    return this;
  }

  public int getPurchasePrice() {
    return purchasePrice;
  }

  public Product withCurrency(String currency) {
    this.currency = currency;
    return this;
  }

  public String getCurrency() {
    return currency;
  }

  public Product withPriceUSD(int priceUSD) {
    this.priceUSD = priceUSD;
    return this;
  }

  public int getPriceUSD() {
    return priceUSD;
  }

  public Product withPriceEUR(int priceEUR) {
    this.priceEUR = priceEUR;
    return this;
  }

  public int getPriceEUR() {
    return priceEUR;
  }
}