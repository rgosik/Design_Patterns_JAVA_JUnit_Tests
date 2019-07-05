import abstractFactory.dock.LighterShipDock;
import factoryWithRegistration.RShipDock;
import factoryWithRegistration.RShipFactory;
import factoryWithRegistration_Reflection.RRShipDock;
import junit.framework.*;
import methodFactory.factory.LighterShipFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import simpleFactory.ShipDock;
import simpleFactory.SimpleShipFactory;
import factoryWithRegistration_Reflection.RRShipFactory;
import simpleFactory.ship.CargoShip;
import simpleFactory.ship.Ship;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class FactoriesEfficencyTests extends TestCase{

    static long timeElapsedR;
    static long timeElapsedRR;

    @Test
    public void testReflection()  throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        RRShipFactory rrShipFactory = RRShipFactory.getInstance();
        RRShipDock rrShipDock = new RRShipDock(rrShipFactory);

        List<Model.Ship> ships = new ArrayList<>();
        for (int i = 0; i <= 1000000; i++) {
            rrShipFactory.registerShip("cargo", Model.CargoShip.class);
            ships.add(rrShipDock.orderShip("cargo"));
        }

        Assert.assertEquals(ships.get(1).getClass(), Model.CargoShip.class);
    }

    @Test
    public void testRegistration()  throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        RShipFactory rShipFactory = RShipFactory.getInstance();
        RShipDock rShipDock = new RShipDock(rShipFactory);

        List<factoryWithRegistration.Ship> ships = new ArrayList<>();
        for(int i = 0; i <= 1000000; i++) {
            rShipFactory.registerShip("cargo", new factoryWithRegistration.CargoShip());
            ships.add(rShipDock.orderShip("cargo"));
        }

        Assert.assertEquals(ships.get(1).getClass(), factoryWithRegistration.CargoShip.class);
    }

    @Test
    public void testAbstract(){
        LighterShipDock lighterShipDock = new LighterShipDock();

        List<abstractFactory.model.Ship> ships = new ArrayList<>();
        for(int i = 0; i <= 1000000; i++){
            ships.add(lighterShipDock.orderShip("cargo"));
        }

        Assert.assertEquals(ships.get(1).getClass(), abstractFactory.model.CargoShip.class);
    }

    @Test
    public void testSimple(){
        SimpleShipFactory simpleShipFactory = SimpleShipFactory.getInstance();
        ShipDock shipDock = new ShipDock(simpleShipFactory);

        List<Ship> ships = new ArrayList<>();
        for(int i = 0; i <= 1000000; i++) {
            ships.add(shipDock.orderShip("cargo"));
        }

        Assert.assertEquals(ships.get(1).getClass(), CargoShip.class);
    }

    @Test
    public void testMethod(){
        LighterShipFactory lighterShipFactory = LighterShipFactory.getInstance();

        List<methodFactory.model.Ship> ships = new ArrayList<>();
        for(int i = 0; i <= 1000000; i++) {
            ships.add(lighterShipFactory.orderShip("cargo"));
        }

        Assert.assertEquals(ships.get(1).getClass(), methodFactory.model.lighterShips.LighterCargoShip.class);
    }

}
