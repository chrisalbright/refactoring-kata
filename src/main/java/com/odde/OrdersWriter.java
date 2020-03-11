package com.odde;

import static com.odde.Show.showOrdersAsJson;

public class OrdersWriter {
  private Orders orders;

  public OrdersWriter(Orders orders) {
    this.orders = orders;
  }

  public String getContents() {
    return showOrdersAsJson(orders);
  }

}