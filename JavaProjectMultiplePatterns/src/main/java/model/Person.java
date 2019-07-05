package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Cloneable{

    private String firstName;
    private String lastName;
    private Set<Status> status = new HashSet<>();
    private int age;
    private double money;

    public void payForTrip(Trip trip){
        this.money -= trip.getPrice();
    }

    public Person clone(){
        Set clonedStatus = new HashSet();

        for (Status item : status) {
            clonedStatus.add(item);
        }

        return new Person(this.firstName, this.lastName, clonedStatus, this.age, this.money);
    }
}
