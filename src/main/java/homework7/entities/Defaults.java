package homework7.entities;

import java.util.Arrays;

public class Defaults {
    public static Substances DEFAULT_SUBSTANCES = new Substances().set(s -> {
        s.setColors("Red");
        s.setElements(Arrays.asList("Water", "Fire"));
        s.setMetals("Selen");
        s.setSummary(Arrays.asList(3, 8));
        s.setVegetables(Arrays.asList("Cucumber", "Tomato"));
    });
}
