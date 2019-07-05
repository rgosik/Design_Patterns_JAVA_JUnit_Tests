import model.Person;
import model.Trip;

public class TripFacade {

    public static boolean tripIsAvailable(Person person, Trip trip){

        if(!person.getStatus().containsAll(trip.getReduiredStatus())){
            return false;
        } else if(trip.getNumberOfAvailableSpots() == 0){
            return false;
        } else {
            return true;
        }
    }

    public static boolean tripIsAffordable(Person person, Trip trip){

        if(person.getMoney() < trip.getPrice()){
            return false;
        } else {
            return true;
        }
    }

    public static boolean tripAvailableAndAffordable(Person person, Trip trip){
        if(tripIsAvailable(person, trip)){
            if(tripIsAffordable(person, trip)){
                return true;
            }
        }
        return false;
    }
}
