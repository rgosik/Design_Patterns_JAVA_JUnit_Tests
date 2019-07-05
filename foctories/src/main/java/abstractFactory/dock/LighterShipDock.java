package abstractFactory.dock;


import abstractFactory.elementsFactory.LighterShipElementsFactory;
import abstractFactory.elementsFactory.ShipElementsFactory;
import abstractFactory.model.*;

public class LighterShipDock extends ShipDock {

    protected Ship createShip(String item) {
        Ship ship = null;
        ShipElementsFactory shipFactory = LighterShipElementsFactory.getInstance();

        if (item.equals("aircraft")) {
            ship = new AircraftCarrierShip(shipFactory);
            ship.setName("Lighter Aircraft Carrier Ship");

        } else if (item.equals("cargo")) {
            ship = new CargoShip(shipFactory);
            ship.setName("Lighter Cargo Ship");

        } else if (item.equals("fishing")) {
            ship = new FishingShip(shipFactory);
            ship.setName("Lighter Fishing Ship");

        } else if (item.equals("passenger")) {
            ship = new PassengerShip(shipFactory);
            ship.setName("Lighter Passenger Ship");

        }
        return ship;
    }
}
