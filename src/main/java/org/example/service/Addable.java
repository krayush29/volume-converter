package org.example.service;

import lombok.NonNull;
import org.example.enums.MetricUnit;
import org.example.service.implementation.Volume;

public interface Addable<T extends Metric<?>>{

    default T add(T addend){
        double value = addend.convert(T.unit);
        return new Addable<T,T.unit>(T.unit, value);
    };

    T subtract(@NonNull T subtrahend);
}
