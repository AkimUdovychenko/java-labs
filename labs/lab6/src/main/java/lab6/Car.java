package lab6;

public class Car implements CarbonFootprint {
    private final String makeModel;
    private final double fuelUsedLitersPerYear;

    public Car(String makeModel, double fuelLiters) {
        this.makeModel = makeModel;
        this.fuelUsedLitersPerYear = fuelLiters;
    }

    @Override public double getCarbonFootprint() {
        return fuelUsedLitersPerYear * 2.31;
    }

    @Override public String info() { return "Car: " + makeModel; }
}
