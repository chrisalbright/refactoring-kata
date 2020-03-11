package com.odde;

import com.odde.serialize.OrderJsonSerializer;

import java.util.stream.Collectors;

public class OrdersWriter {
    private final OrderJsonSerializer orderSerializer;
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
        this.orderSerializer = new OrderJsonSerializer();
    }

    public String getContents() {
        StringBuilder sb = new StringBuilder("{\"orders\": [");

        String serializedOrders = orders
            .getOrders()
            .stream()
            .map(orderSerializer::serialize)
            .collect(Collectors.joining(", "));
        sb.append(serializedOrders);

        return sb.append("]}").toString();
    }

}