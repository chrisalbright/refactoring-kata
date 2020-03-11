package com.odde.serialize;

import com.odde.Order;
import com.odde.Product;
import com.odde.Serializer;

import java.util.stream.Collectors;

public class OrderJsonSerializer implements Serializer<Order, String> {
  @Override
  public String serialize(Order order) {
    Serializer<Product, String> productSerializer = new ProductJsonSerializer();
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    sb.append("\"id\": ");
    sb.append(order.getOrderId());
    sb.append(", ");
    sb.append("\"products\": [");


    String serializedProducts =
        order
            .getProducts()
            .stream()
            .map(productSerializer::serialize)
            .collect(Collectors.joining(","));

    sb.append(serializedProducts);

    sb.append("]");
    sb.append("}");
    return sb.toString();
  }
}
