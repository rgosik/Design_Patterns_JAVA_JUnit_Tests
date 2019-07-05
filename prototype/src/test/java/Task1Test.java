import org.junit.jupiter.api.Test;
import task1.ShipCatalogue;
import task1.ShipManager;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class Task1Test {

    @Test
    void testTask1(){
        ShipManager manager = new ShipManager();
        ShipCatalogue originalShips = manager.prepareShips();
        ShipCatalogue clonedShips = originalShips.clone();

        System.out.println(originalShips.ships);
        System.out.println(clonedShips.ships);

        assertNotSame(originalShips, clonedShips);

//        originalShips.ships.add("CHANGED");
//
//        System.out.println("\nAfter change: \n" + originalShips.ships);
//        System.out.println(clonedShips.ships + "\n");
    }
}
