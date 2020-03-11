package com.odde.serialize;

import com.odde.Product;
import com.odde.Serializer;

public class ProductJsonSerializer implements Serializer<Product, String> {

  private String getSizeFor(Product product) {
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
  }

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
  public String serialize(Product product) {
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
      sb.append(getSizeFor(product));
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
}
