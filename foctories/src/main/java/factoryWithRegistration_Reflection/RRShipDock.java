package factoryWithRegistration_Reflection;

import Model.Ship;

import java.lang.reflect.InvocationTargetException;

public class RRShipDock {
    private RRShipFactory rrShipFactory;

    public RRShipDock(RRShipFactory rrShipFactory) {
        this.rrShipFactory = rrShipFactory.getInstance();
    }

    public Ship orderShip(String shipType) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Ship ship = rrShipFactory.createShip(shipType);

        return ship;
    }
}
