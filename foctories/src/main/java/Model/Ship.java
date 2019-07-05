package Model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class Ship {
    protected String bay;
    protected String hull;
    protected String deck;
    protected String cabin;
    protected String cockpit;

    public void swim(String destination) {
        System.out.println("Sailing to: " + destination);
    }
    public void overtake(){
        System.out.println("All your base are belong to us!");
    }

}
