package task2;

public class ShipManager {
    public Ship createShip() {
        Hull hull = new Hull(Nails.Short, Material.Aluminum);
        return new Ship("Small", hull, "Two");
    }
}
