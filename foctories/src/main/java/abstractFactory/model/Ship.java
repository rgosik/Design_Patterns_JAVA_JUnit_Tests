package abstractFactory.model;

import abstractFactory.elements.bay.Bay;
import abstractFactory.elements.cabin.Cabin;
import abstractFactory.elements.cockpit.Cockpit;
import abstractFactory.elements.deck.Deck;
import abstractFactory.elements.hull.Hull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class Ship {
    String name;

    Hull hull;
    Bay bay;
    Deck deck;
    Cabin cabin;
    Cockpit cockpit;

    public abstract void prepare();

    public void swim(String destination) {
        System.out.println("Sailing to: " + destination);
    }
    public void overtake(){
        System.out.println("All your base are belong to us!");
    }

}
