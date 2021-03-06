package com.odde;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
  private List<Product> products = new ArrayList<>();
  private int id;

  public Order(int id) {
    this.id = id;
  }

  public int getOrderId() {
    return id;
  }

  public int getProductsCount() {
    return products.size();
  }

  public Product getProduct(int j) {
    return products.get(j);
  }

  public void AddProduct(Product product) {
    products.add(product);
  }

  public List<Product> getProducts() {
    return Collections.unmodifiableList(products);
  }
}
