package abstractFactory.model;

import abstractFactory.elementsFactory.ShipElementsFactory;

public class CargoShip extends Ship {
    ShipElementsFactory shipFactory;

    public CargoShip(ShipElementsFactory shipFactory){
        this.shipFactory = shipFactory;
    }

    public void prepare(){
        //System.out.println(getName() + " In making");
        bay = shipFactory.createBay();
        cabin = shipFactory.createCabin();
        cockpit = shipFactory.createCockpit();
        deck = shipFactory.createDeck();
        hull = shipFactory.createHull();
    }
}
