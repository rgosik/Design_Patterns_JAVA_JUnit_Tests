
import FluentBuilder.ShipBuilder;
import Model.Ship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFluentBuilder {

    Ship ship;
    
    @BeforeEach
    public void build_cheeseburger() {
        ShipBuilder shipBuilder;
        shipBuilder = new ShipBuilder();
        ship = shipBuilder
                .bay("Cozy")
                .hull("Wooden")
                .deck("Two")
                .buildShip();
    }

    @Test
    void shouldHaveCorrectValues(){
        assertAll("Checking values",
                () -> assertEquals(ship.getBay(), "Cozy"),
                () -> assertEquals(ship.getHull(), "Wooden"),
                () -> assertEquals(ship.getDeck(), "Two")
        );
    }
}
