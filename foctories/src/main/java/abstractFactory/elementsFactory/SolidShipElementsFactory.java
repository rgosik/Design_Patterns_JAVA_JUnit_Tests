package abstractFactory.elementsFactory;

import abstractFactory.elements.bay.Bay;
import abstractFactory.elements.bay.SpaciousBay;
import abstractFactory.elements.cabin.Cabin;
import abstractFactory.elements.cabin.LargeCabin;
import abstractFactory.elements.cockpit.Cockpit;
import abstractFactory.elements.cockpit.WealthyCockpit;
import abstractFactory.elements.deck.Deck;
import abstractFactory.elements.deck.ThreeDecks;
import abstractFactory.elements.hull.Hull;
import abstractFactory.elements.hull.MetalHull;

public class SolidShipElementsFactory implements ShipElementsFactory {

    private static SolidShipElementsFactory solidShipElementsFactory;

    public static SolidShipElementsFactory getInstance() {
        if (solidShipElementsFactory == null) {
            synchronized (SolidShipElementsFactory.class) {
                if (solidShipElementsFactory == null) {
                    solidShipElementsFactory = new SolidShipElementsFactory();
                }
            }
        }
        return solidShipElementsFactory;
    }

    public Hull createHull() {
        return new MetalHull();
    }

    public Deck createDeck() {
        return new ThreeDecks();
    }

    public Cockpit createCockpit() {
        return new WealthyCockpit();
    }

    public Cabin createCabin() {
        return new LargeCabin();
    }

    public Bay createBay() {
        return new SpaciousBay();
    }
}
