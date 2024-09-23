package org.example.service;

import lombok.NonNull;
import org.example.enums.MetricUnit;

public interface Addable<T extends Metric<T,?>>{
    T add(@NonNull T addend);

    T subtract(@NonNull T subtrahend);
}
