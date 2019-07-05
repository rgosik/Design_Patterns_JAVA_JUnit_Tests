package methodFactory.factory;

import methodFactory.model.Ship;

public abstract class ShipFactory {

    abstract Ship createShip(String type);

    public Ship orderShip(String type) {
        Ship ship = createShip(type);

        //model.swim("Hawaje");
        return ship;
    }
}
