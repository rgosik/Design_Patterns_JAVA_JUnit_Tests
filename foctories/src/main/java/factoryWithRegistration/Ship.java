package factoryWithRegistration;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class Ship {

    public abstract Ship createShip();

    public void swim(String destination) {
        System.out.println("Sailing to: " + destination);
    }
    public void overtake(){
        System.out.println("All your base are belong to us!");
    }


}
