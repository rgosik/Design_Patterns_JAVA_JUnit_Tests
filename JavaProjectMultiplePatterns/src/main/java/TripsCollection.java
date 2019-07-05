import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Season;
import model.TravelAgency;
import model.Trip;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripsCollection implements Cloneable{

    private List<Trip> trips = new ArrayList<>();
    private Season season;
    private TravelAgency travelAgency;

    public void addTrip(Trip trip){
        trips.add(trip);
    }

    public TripsCollection clone(){
        List clonedTrips = new ArrayList();

        for (Trip item : trips) {
            clonedTrips.add(item.clone());
        }

        return new TripsCollection(clonedTrips, this.season, this.travelAgency);
    }
}
