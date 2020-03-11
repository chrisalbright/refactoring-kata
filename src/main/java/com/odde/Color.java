package com.odde;

public interface Color<T> {
  static <T> String color(T t, Color<T> color) {
    return color.color(t);
  }

  static Color<Product> forProduct() {
    return product -> {
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
    };
  }

  String color(T t);
}
