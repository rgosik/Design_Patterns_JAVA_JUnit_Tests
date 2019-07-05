package factoryWithRegistration_Reflection;

import Model.Ship;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class RRShipFactory {

    private HashMap registeredShips = new HashMap();
    private static RRShipFactory shipFactory;

    public static RRShipFactory getInstance() {
        if (shipFactory == null) {
            synchronized (RRShipFactory.class) {
                if (shipFactory == null) {
                    shipFactory = new RRShipFactory();
                }
            }
        }
        return shipFactory;
    }

    public void registerShip(String shipType, Class shipClass)
    {
        registeredShips.put(shipType, shipClass);
    }

    public Ship createShip(String shipType) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        Class productClass = (Class) registeredShips.get(shipType);
        Constructor shipConstructor = productClass.getDeclaredConstructor(new Class[] { });
        return (Ship) shipConstructor.newInstance(new Object[] { });
    }
}
