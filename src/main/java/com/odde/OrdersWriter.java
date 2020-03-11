package com.odde;

import java.util.stream.Collectors;

import static com.odde.Show.orderAsJson;
import static com.odde.Show.show;

public class OrdersWriter {
  private Orders orders;

  public OrdersWriter(Orders orders) {
    this.orders = orders;
  }

  public String getContents() {
    StringBuilder sb = new StringBuilder("{\"orders\": [");

    String serializedOrders = orders
        .getOrders()
        .stream()
        .map(order -> show(order, orderAsJson()))
        .collect(Collectors.joining(", "));
    sb.append(serializedOrders);

    return sb.append("]}").toString();
  }

}