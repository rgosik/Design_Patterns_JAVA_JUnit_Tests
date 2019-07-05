package factoryWithRegistration;

import java.lang.reflect.InvocationTargetException;

public class RShipDock {
    private RShipFactory rShipFactory;

    public RShipDock(RShipFactory rShipFactory) {
        this.rShipFactory = rShipFactory.getInstance();
    }

    public Ship orderShip(String shipType) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Ship ship = rShipFactory.createShip(shipType);

        return ship;
    }
}
