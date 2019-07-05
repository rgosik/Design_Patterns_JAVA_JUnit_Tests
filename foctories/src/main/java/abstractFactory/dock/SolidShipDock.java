package abstractFactory.dock;

import abstractFactory.elementsFactory.SolidShipElementsFactory;
import abstractFactory.elementsFactory.ShipElementsFactory;
import abstractFactory.model.*;

public class SolidShipDock extends ShipDock {

    protected Ship createShip(String item) {
        Ship ship = null;
        ShipElementsFactory shipFactory = new SolidShipElementsFactory();

        if (item.equals("aircraft")) {
            ship = new AircraftCarrierShip(shipFactory);
            ship.setName("Solid Aircraft Carrier Ship");

        } else if (item.equals("cargo")) {
            ship = new CargoShip(shipFactory);
            ship.setName("Solid Cargo Ship");

        } else if (item.equals("fishing")) {
            ship = new FishingShip(shipFactory);
            ship.setName("Solid Fishing Ship");

        } else if (item.equals("passenger")) {
            ship = new PassengerShip(shipFactory);
            ship.setName("Solid Passenger Ship");

        }
        return ship;
    }
}
