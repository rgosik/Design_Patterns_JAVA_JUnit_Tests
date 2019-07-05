package methodFactory.factory;

import methodFactory.model.solidShips.SolidAircraftCarrierShip;
import methodFactory.model.solidShips.SolidCargoShip;
import methodFactory.model.solidShips.SolidFishingShip;
import methodFactory.model.solidShips.SolidPassengerShip;
import methodFactory.model.Ship;

public class SolidShipFactory extends ShipFactory{
    private static SolidShipFactory SolidShipFactory;

    public static SolidShipFactory getInstance() {
        if (SolidShipFactory == null) {
            synchronized (SolidShipFactory.class) {
                if (SolidShipFactory == null) {
                    SolidShipFactory = new SolidShipFactory();
                }
            }
        }
        return SolidShipFactory;
    }

    Ship createShip(String item) {
        if (item.equals("aircraft")) {
            return new SolidAircraftCarrierShip();
        } else if (item.equals("cargo")) {
            return new SolidCargoShip();
        } else if (item.equals("fishing")) {
            return new SolidFishingShip();
        } else if (item.equals("passenger")) {
            return new SolidPassengerShip();
        } else return null;
    }
}
