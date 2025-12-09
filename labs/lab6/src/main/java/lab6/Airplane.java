package lab6;

public class Airplane implements CarbonFootprint {
    private final String name;
    private final double distanceKm;
    private final double emissionFactorPerKm;
    private final int passengers;

    public Airplane(String name, double distanceKm, double emissionFactorPerKm, int passengers) {
        this.name = name;
        this.distanceKm = distanceKm;
        this.emissionFactorPerKm = emissionFactorPerKm;
        this.passengers = passengers;
    }

    @Override public double getCarbonFootprint() {
        return (emissionFactorPerKm * distanceKm) / Math.max(passengers,1);
    }

    @Override public String info() { return "Airplane: " + name; }
}
