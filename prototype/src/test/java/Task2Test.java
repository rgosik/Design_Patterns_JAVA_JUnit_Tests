import org.junit.jupiter.api.Test;
import task2.Ship;
import task2.ShipManager;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class Task2Test {

    @Test
    public void testTask2(){
        ShipManager shipManager = new ShipManager();
        Ship originalShip = shipManager.createShip();

        Ship clonedShip = originalShip.clone();

        System.out.println(originalShip);
        System.out.println(clonedShip);

        assertNotSame(originalShip, clonedShip);

//        originalShip.setBay("CHANGED");
//
//        System.out.println("\nAfter change: \n" + originalShip);
//        System.out.println(clonedShip);

    }
}

