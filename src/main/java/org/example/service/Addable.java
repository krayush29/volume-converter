package org.example.service;

import lombok.NonNull;

public interface Addable<T extends Metric<T>> {
    T add(@NonNull T addend);

    T subtract(@NonNull T subtrahend);
}
