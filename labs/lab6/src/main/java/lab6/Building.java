package lab6;

public class Building implements CarbonFootprint {
    private final String nameOrAddress;
    private final double electricityUsedKWhPerYear;
    private final double gasUsedM3PerYear;

    public Building(String nameOrAddress, double electricityKWh, double gasM3) {
        this.nameOrAddress = nameOrAddress;
        this.electricityUsedKWhPerYear = electricityKWh;
        this.gasUsedM3PerYear = gasM3;
    }

    @Override
    public double getCarbonFootprint() {
        return electricityUsedKWhPerYear * 0.000233 + gasUsedM3PerYear * 2.0;
    }

    @Override public String info() {
        return "Building: " + nameOrAddress;
    }
}
