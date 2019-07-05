package odwiedzający;

import model.Status;
import model.Trip;

public class TripVisitor implements Visitor {

    @Override
    public void visit(Trip trip) {

        if(trip.getPrice() > 5000){
            trip.addReduiredStatus(Status.Employed);
            trip.addReduiredStatus(Status.WellBred);
        } else if(trip.getPrice() > 3000){
            trip.addReduiredStatus(Status.Employed);
        }

        if(trip.getCapacity() %2 == 0){
            trip.addReduiredStatus(Status.Married);
        } else {
            trip.addReduiredStatus(Status.Single);
        }
    }
}
