package Builder;
import Model.Ship;

public class LightShipBuilder implements ShipBuilder {

    private Ship ship;

    public LightShipBuilder(){
        this.ship = new Ship();
    }

    public void buildShipBay() {
        ship.setBay("Cozy");
    }

    public void buildShipHull() {
        ship.setHull("Wooden");
    }

    public void biuldShipDeck() {
        ship.setDeck("Two");
    }

    public Ship getShip() {
        return this.ship;
    }


}
