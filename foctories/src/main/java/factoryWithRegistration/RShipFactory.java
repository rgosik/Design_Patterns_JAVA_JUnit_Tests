package factoryWithRegistration;

import java.util.HashMap;

public class RShipFactory {

    private HashMap registeredShips = new HashMap();
    private static RShipFactory shipFactory;

    public static RShipFactory getInstance() {
        if (shipFactory == null) {
            synchronized (RShipFactory.class) {
                if (shipFactory == null) {
                    shipFactory = new RShipFactory();
                }
            }
        }
        return shipFactory;
    }

    public void registerShip(String shipType, Ship ship)    {
        registeredShips.put(shipType, ship);
    }

    public Ship createShip(String shipType){
        return ((Ship)registeredShips.get(shipType)).createShip();
    }
}
