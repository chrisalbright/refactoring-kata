package com.odde;

public interface Serializer<I, O> {
  O serialize(I i);
}
