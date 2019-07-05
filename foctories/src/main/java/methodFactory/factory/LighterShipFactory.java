package methodFactory.factory;

import methodFactory.model.lighterShips.LighterAircraftCarrierShip;
import methodFactory.model.lighterShips.LighterCargoShip;
import methodFactory.model.lighterShips.LighterFishingShip;
import methodFactory.model.lighterShips.LighterPassengerShip;
import methodFactory.model.Ship;


public class LighterShipFactory extends ShipFactory{
    private static LighterShipFactory lighterShipFactory;

    public static LighterShipFactory getInstance() {
        if (lighterShipFactory == null) {
            synchronized (LighterShipFactory.class) {
                if (lighterShipFactory == null) {
                    lighterShipFactory = new LighterShipFactory();
                }
            }
        }
        return lighterShipFactory;
    }

    Ship createShip(String item) {
        if (item.equals("aircraft")) {
            return new LighterAircraftCarrierShip();
        } else if (item.equals("cargo")) {
            return new LighterCargoShip();
        } else if (item.equals("fishing")) {
            return new LighterFishingShip();
        } else if (item.equals("passenger")) {
            return new LighterPassengerShip();
        } else return null;
    }
}
