package abstractFactory.elementsFactory;

import abstractFactory.elements.bay.Bay;
import abstractFactory.elements.cabin.Cabin;
import abstractFactory.elements.cockpit.Cockpit;
import abstractFactory.elements.deck.Deck;
import abstractFactory.elements.hull.Hull;

public interface ShipElementsFactory {
    Bay createBay();
    Cabin createCabin();
    Cockpit createCockpit();
    Deck createDeck();
    Hull createHull();
}
