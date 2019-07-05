package abstractFactory.dock;

import abstractFactory.model.Ship;

public abstract class ShipDock {

    protected abstract Ship createShip(String item);

    public Ship orderShip(String type) {
        Ship ship = createShip(type);

        ship.prepare();
        return ship;
    }
}
