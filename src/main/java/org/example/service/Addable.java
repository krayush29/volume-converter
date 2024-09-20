package org.example.service;

public interface Addable<T extends Metric<T>> {
    T add(T addend);

    T subtract(T subtrahend);
}
