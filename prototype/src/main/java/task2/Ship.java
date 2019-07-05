package task2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class Ship implements Cloneable {

    private String bay;
    private Hull hull;
    private String deck;

    public Ship(String bay, Hull hull, String deck){
        this.bay = bay;
        this.hull= hull;
        this.deck =  deck;
    }

    public Ship clone(){
        return new Ship(this.bay, this.hull.clone(), this.deck);
    }
}
