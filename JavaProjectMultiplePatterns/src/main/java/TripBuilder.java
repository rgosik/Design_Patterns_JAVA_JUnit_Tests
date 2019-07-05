import lombok.Data;
import model.Person;
import model.Status;
import model.Trip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class TripBuilder {

    private String name;
    private double price;
    private int capacity;
    private Set<Status> reduiredStatus = new HashSet<>();
    private Set<Person> participants = new HashSet<>();

    public TripBuilder name(String name){
        this.setName(name);
        return this;
    }

    public TripBuilder price(double price){
        this.setPrice(price);
        return this;
    }

    public TripBuilder capacity(int capacity){
        this.setCapacity(capacity);
        return this;
    }

    public TripBuilder reduiredStatus(Set<Status>  reduiredStatus){
        this.setReduiredStatus(reduiredStatus);
        return this;
    }

    public TripBuilder participants(Set<Person> participants){
        this.setParticipants(participants);
        return this;
    }

    public Trip buildTrip() {
        Trip trip = new Trip();
        trip.setName(name);
        trip.setPrice(price);
        trip.setCapacity(capacity);
        trip.setReduiredStatus(reduiredStatus);
        this.setParticipants(participants);
        return trip;
    }
}
