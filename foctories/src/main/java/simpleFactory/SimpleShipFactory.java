package simpleFactory;

import simpleFactory.ship.*;
import simpleFactory.ship.AircraftCarrierShip;
import simpleFactory.ship.CargoShip;
import simpleFactory.ship.FishingShip;
import simpleFactory.ship.PassengerShip;

public class SimpleShipFactory {
    private static SimpleShipFactory simpleShipFactory;

    public static SimpleShipFactory getInstance() {
        if (simpleShipFactory == null) {
            synchronized (SimpleShipFactory.class) {
                if (simpleShipFactory == null) {
                    simpleShipFactory = new SimpleShipFactory();
                }
            }
        }
        return simpleShipFactory;
    }

    public Ship createShip(String type) {
        Ship Ship = null;

        if (type.equals("aircraft")) {
            Ship = new AircraftCarrierShip();
        } else if (type.equals("cargo")) {
            Ship = new CargoShip();
        } else if (type.equals("fishing")) {
            Ship = new FishingShip();
        } else if (type.equals("passenger")) {
            Ship = new PassengerShip();
        }
        return Ship;
    }
}
