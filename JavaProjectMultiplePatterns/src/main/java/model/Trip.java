package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import odwiedzający.Visitor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip implements Cloneable{

    private String name;
    private double price;
    private int capacity;
    private Set<Status> reduiredStatus = new HashSet<>();
    private Set<Person> participants = new HashSet<>();

    public void addParticipant(Person person){
        participants.add(person);
    }

    public void addReduiredStatus(Status status){
        reduiredStatus.add(status);
    }

    public int getNumberOfAvailableSpots(){
        return capacity - participants.size();
    }

    public Trip clone(){
        Set clonedStatus = new HashSet();

        for (Status item : reduiredStatus) {
            clonedStatus.add(item);
        }

        Set clonedParticipants = new HashSet();

        for (Person item : participants) {
            clonedParticipants.add(item.clone());
        }

        return new Trip(this.name, this.price, this.capacity, clonedStatus, clonedParticipants);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
