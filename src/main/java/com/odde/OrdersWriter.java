package com.odde;

public class OrdersWriter {
  private Orders orders;

  public OrdersWriter(Orders orders) {
    this.orders = orders;
  }

  public String getContents() {
    return Show.show(orders, Show.ordersAsJson());
  }

}