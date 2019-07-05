package factoryWithRegistration;

public class CargoShip extends Ship {

    public Ship createShip() {
        return new CargoShip();
    }
}
