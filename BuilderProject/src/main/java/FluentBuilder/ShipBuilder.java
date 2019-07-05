package FluentBuilder;

import Model.Ship;
import lombok.Data;

@Data
public class ShipBuilder {

    private String bay;
    private String hull;
    private String deck;

    public ShipBuilder bay(String bay){
        this.setBay(bay);
        return this;
    }

    public ShipBuilder hull(String hull){
        this.setHull(hull);
        return this;
    }

    public ShipBuilder deck(String deck){
        this.setDeck(deck);
        return this;
    }

    public Ship buildShip() {
        Ship ship = new Ship();
        ship.setBay(bay);
        ship.setHull(hull);
        ship.setDeck(deck);
        return ship;
    }
}
