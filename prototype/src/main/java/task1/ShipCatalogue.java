package task1;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ShipCatalogue implements Cloneable {
    public List<String> ships;

    public ShipCatalogue clone() {
        List clonedShips = new ArrayList();

        for (String item : ships) {
            clonedShips.add(item);
        }
        return new ShipCatalogue(clonedShips);
    }
}

