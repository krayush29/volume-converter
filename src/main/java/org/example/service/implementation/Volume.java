package org.example.service.implementation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.example.enums.VolumeUnits;
import org.example.service.Addable;
import org.example.service.Metric;

@Data
@EqualsAndHashCode
public class Volume implements Metric<VolumeUnits>, Addable<Volume> {
    private final VolumeUnits unit;
    private final double value;

    public Volume convert(VolumeUnits toUnit) {
        double value = toUnit.fromBase(this.unit.toBase(this.value));
        return new Volume(toUnit, value);
    }

    public Volume add(Volume addend) {
        double value = addend.convert(this.unit).value;
        return new Volume(this.getUnit(), value + this.value);
    }

    public Volume subtract(Volume subtrahend) {
        double value = subtrahend.convert(this.unit).value;
        return new Volume(this.getUnit(), this.value - value);
    }

    public Integer compare(Volume comparedVolume) {
        // TODO: Override equals and hashcode
        Double value1 = this.value;
        Double value2 = comparedVolume.convert(this.unit).value;
        return value1.compareTo(value2);
    }
}
