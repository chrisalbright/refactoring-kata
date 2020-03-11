package com.odde;

import com.odde.serialize.ProductJsonSerializer;

import java.util.stream.Collectors;

public class OrdersWriter {
    private final ProductJsonSerializer productSerializer;
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
        this.productSerializer = new ProductJsonSerializer();
    }

    public String getContents() {
        StringBuilder sb = new StringBuilder("{\"orders\": [");

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            Order order = orders.getOrder(i);
            sb.append("{");
            sb.append("\"id\": ");
            sb.append(order.getOrderId());
            sb.append(", ");
            sb.append("\"products\": [");


            String serializedProducts = order.getProducts().stream().map(productSerializer::serialize).collect(Collectors.joining(","));

            sb.append(serializedProducts);

            sb.append("]");
            sb.append("}, ");
        }

        if (orders.getOrdersCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }

}