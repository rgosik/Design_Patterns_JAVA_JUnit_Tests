package Builder;

import Model.Ship;

public interface ShipBuilder {

    void buildShipBay();
    void buildShipHull();
    void biuldShipDeck();
    Ship getShip();
}
