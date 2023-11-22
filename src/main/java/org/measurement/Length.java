package org.measurement;

public class Length extends Measurement {

    public static Length centimeter(double value) {
        return new Length(value, LengthUnit.CENTIMETER);
    }

    public static Length meter(double value) {
        return new Length(value, LengthUnit.METER);
    }

    public static Length kilometer(double value) {
        return new Length(value, LengthUnit.KILOMETER);
    }

    private enum LengthUnit implements Unit {
        METER(100),
        KILOMETER(100000),
        CENTIMETER(1);

        private int conversionFactor;

        LengthUnit(int conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double toBaseUnit(double value) {
            return value * this.conversionFactor;
        }

        public double fromBaseUnit(double value) {
            return value / this.conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        super(value, unit);
    }

    @Override
    public Measurement add(Measurement length) {
        return new Length(super.addValue(length), (LengthUnit) this.unit);
    }

}
