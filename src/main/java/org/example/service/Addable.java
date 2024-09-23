package org.example.service;

import lombok.NonNull;
import org.example.enums.MetricUnit;

public interface Addable<T extends Metric<T,U>, U extends MetricUnit> {
    T add(@NonNull T addend);

    T subtract(@NonNull T subtrahend);
}
