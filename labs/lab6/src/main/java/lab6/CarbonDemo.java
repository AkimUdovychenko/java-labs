package lab6;

import java.util.ArrayList;
import java.util.List;

public class CarbonDemo {
    public static void run() {
        List<CarbonFootprint> items = new ArrayList<>();
        items.add(new Building("Main St. 10", 12000, 800));
        items.add(new Car("VW Golf 1.4 TSI", 900));
        items.add(new Airplane("Boeing 737-800", 2500, 0.115, 150));

        System.out.println("CarbonFootprint полиморфизм:\n");
        for (CarbonFootprint cf : items) {
            System.out.printf("%-28s => %.4f кг CO2e%n", cf.info(), cf.getCarbonFootprint());
        }
    }
}
