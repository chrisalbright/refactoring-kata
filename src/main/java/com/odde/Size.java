package com.odde;

public interface Size<T> {
  String size(T t);

  static <T> String size(T t, Size<T> size) {
    return size.size(t);
  }

  static Size<Product> forProduct() {
    return product -> {
      switch (product.getSize()) {
        case 1:
          return "XS";
        case 2:
          return "S";
        case 3:
          return "M";
        case 4:
          return "L";
        case 5:
          return "XL";
        case 6:
          return "XXL";
        default:
          return "Invalid Size";
      }
    };
  }
}

