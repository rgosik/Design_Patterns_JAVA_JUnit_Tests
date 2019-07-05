package abstractFactory.elementsFactory;

import abstractFactory.dock.LighterShipDock;
import abstractFactory.elements.bay.Bay;
import abstractFactory.elements.bay.MediumBay;
import abstractFactory.elements.cabin.Cabin;
import abstractFactory.elements.cabin.CozyCabin;
import abstractFactory.elements.cockpit.Cockpit;
import abstractFactory.elements.cockpit.WealthyCockpit;
import abstractFactory.elements.deck.Deck;
import abstractFactory.elements.deck.OneDeck;
import abstractFactory.elements.hull.AluminiumHull;
import abstractFactory.elements.hull.Hull;

public class LighterShipElementsFactory implements ShipElementsFactory {

    private static LighterShipElementsFactory lighterShipElementsFactory;

    public static LighterShipElementsFactory getInstance() {
        if (lighterShipElementsFactory == null) {
            synchronized (LighterShipElementsFactory.class) {
                if (lighterShipElementsFactory == null) {
                    lighterShipElementsFactory = new LighterShipElementsFactory();
                }
            }
        }
        return lighterShipElementsFactory;
    }

    public Bay createBay() {
        return new MediumBay();
    }

    public Cabin createCabin() {
        return new CozyCabin();
    }

    public Cockpit createCockpit() {
        return new WealthyCockpit();
    }

    public Deck createDeck() {
        return new OneDeck();
    }

    public Hull createHull() {
        return new AluminiumHull();
    }
}
