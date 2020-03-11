package com.odde;

import java.util.stream.Collectors;

import static com.odde.Color.color;
import static com.odde.Size.forProduct;
import static com.odde.Size.size;

public interface Show<T> {
  static <T> String show(T t, Show<T> sh) {
    return sh.show(t);
  }

  static Show<Orders> ordersAsJson() {
    return orders -> {
      StringBuilder sb = new StringBuilder("{\"orders\": [");

      String serializedOrders = orders
          .getOrders()
          .stream()
          .map(order -> show(order, orderAsJson()))
          .collect(Collectors.joining(", "));
      sb.append(serializedOrders);

      return sb.append("]}").toString();
    };
  }

  static Show<Order> orderAsJson() {
    return order -> {
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
              .map(product -> show(product, Show.productAsJson()))
              .collect(Collectors.joining(","));

      sb.append(serializedProducts);

      sb.append("]");
      sb.append("}");

      return sb.toString();
    };
  }

  static Show<Product> productAsJson() {

    return product -> {
      StringBuilder sb = new StringBuilder();

      sb.append("{");
      sb.append("\"code\": \"");
      sb.append(product.getCode());
      sb.append("\", ");
      sb.append("\"color\": \"");
      sb.append(color(product, Color.forProduct()));
      sb.append("\", ");

      if (product.getSize() != Product.SIZE_NOT_APPLICABLE) {
        sb.append("\"size\": \"");
        sb.append(size(product, forProduct()));
        sb.append("\", ");
      }

      sb.append("\"price\": ");
      sb.append(product.getPrice());
      sb.append(", ");
      sb.append("\"currency\": \"");
      sb.append(product.getCurrency());
      sb.append("\"}");

      return sb.toString();
    };

  }

  String show(T t);
}