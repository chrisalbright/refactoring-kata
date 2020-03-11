package com.odde;

import java.util.stream.Collectors;

import static com.odde.Size.forProduct;
import static com.odde.Size.size;

public interface Show<T> {
  String show(T t);

  static <T> String show(T t, Show<T> sh) {
    return sh.show(t);
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

    return new Show<Product>() {

      private String getColorFor(Product product) {
        switch (product.getColor()) {
          case 1:
            return "blue";
          case 2:
            return "red";
          case 3:
            return "yellow";
          default:
            return "no color";
        }
      }

      @Override
      public String show(Product product) {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        sb.append("\"code\": \"");
        sb.append(product.getCode());
        sb.append("\", ");
        sb.append("\"color\": \"");
        sb.append(getColorFor(product));
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
      }

      ;

    };

  }
}