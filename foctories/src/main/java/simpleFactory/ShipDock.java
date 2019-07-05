package simpleFactory;

import simpleFactory.ship.Ship;

public class ShipDock {
    SimpleShipFactory factory;

    public ShipDock(SimpleShipFactory factory) {
        this.factory = factory;
    }

    public Ship orderShip(String type){
        Ship ship = factory.createShip(type);

        //model.swim("Bieszczady");

        return ship;
    }
}
