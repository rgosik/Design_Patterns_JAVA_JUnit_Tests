package task1;

import java.util.ArrayList;
import java.util.List;

public class ShipManager {
    public ShipCatalogue prepareShips() {
        List<String> ships = new ArrayList();
        ships.add("Small");
        ships.add("Small-medium");
        ships.add("Medium");
        ships.add("Big");
        return new ShipCatalogue(ships);
    }
}