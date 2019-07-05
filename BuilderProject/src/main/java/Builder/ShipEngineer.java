package Builder;

import Model.Ship;

public class ShipEngineer {

    private ShipBuilder shipBuilder;

    public ShipEngineer(ShipBuilder shipBuilder){
        this.shipBuilder = shipBuilder;
    }

    public Ship getShip(){
        return this.shipBuilder.getShip();
    }

    public void makeShip(){
        shipBuilder.biuldShipDeck();
        shipBuilder.buildShipBay();
        shipBuilder.buildShipHull();
    }
}
