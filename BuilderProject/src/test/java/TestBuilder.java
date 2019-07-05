import Builder.LightShipBuilder;
import Builder.ShipBuilder;
import Builder.ShipEngineer;
import Model.Ship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestBuilder {

    Ship smolShip;

    @BeforeEach
    public void createSmolShip(){

        ShipBuilder lightShip = new LightShipBuilder();
        ShipEngineer shipEngineer = new ShipEngineer(lightShip);
        shipEngineer.makeShip();
        smolShip = shipEngineer.getShip();
    }

    @Test
    void shouldHaveCorrectValues(){
        assertAll("Checking values",
        () -> assertEquals(smolShip.getBay(), "Cozy"),
        () -> assertEquals(smolShip.getHull(), "Wooden"),
        () -> assertEquals(smolShip.getDeck(), "Two")
        );
    }
}
