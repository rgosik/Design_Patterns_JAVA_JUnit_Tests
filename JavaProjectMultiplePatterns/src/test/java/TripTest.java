import iterator.ListIterator;
import model.Person;
import model.Status;
import model.Trip;
import odwiedzający.TripVisitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TripTest {

    private Trip londonTrip;
    private Trip parisTrip;
    private Trip viennaTrip;
    private Person p1;
    private Person p2;
    private Person p3;
    private Set<Status> status1;
    private Set<Status> status2;
    private Set<Status> status3;
    static private TripsCollection collectedTrips;

    @BeforeEach
    public void setUpTripsBuilder() {
        collectedTrips = new TripsCollection();
        TripBuilder tripBuilder = new TripBuilder();
        londonTrip = tripBuilder
                .name("London")
                .price(6000)
                .capacity(10)
                .participants(new HashSet<Person>())
                .reduiredStatus(new HashSet<Status>())
                .buildTrip();

        parisTrip = tripBuilder
                .name("Paris")
                .price(4000)
                .capacity(11)
                .participants(new HashSet<Person>())
                .reduiredStatus(new HashSet<Status>())
                .buildTrip();

        viennaTrip = tripBuilder
                .name("Vienna")
                .price(10000)
                .capacity(8)
                .participants(new HashSet<Person>())
                .reduiredStatus(new HashSet<Status>())
                .buildTrip();

        collectedTrips.addTrip(londonTrip);
        collectedTrips.addTrip(parisTrip);
        collectedTrips.addTrip(viennaTrip);
        p1 = new Person("Jhon", "Bred", null, 22, 6100.0);
        p2 = new Person("Mike", "Tree", null, 28, 4100.0);
        p3 = new Person("Tom", "Smith", null, 33, 6100.0);

        status1 = new HashSet<>();
        status2 = new HashSet<>();
        status3 = new HashSet<>();
    }

    @Test
    void testTripVisitor() {
        TripVisitor visitor = new TripVisitor();

        londonTrip.accept(visitor);

        HashSet<Status> expectedStatus = new HashSet<>();
        expectedStatus.add(Status.WellBred);
        expectedStatus.add(Status.Employed);
        expectedStatus.add(Status.Married);

        assertIterableEquals(londonTrip.getReduiredStatus(), expectedStatus);
    }

    @Test
    void testIterator() {
        List<Trip> trips = collectedTrips.getTrips();
        ListIterator tripsIterator = new ListIterator(trips);

        while (tripsIterator.hasNext()) {
            System.out.println(tripsIterator.next());
        }

        System.out.println("\n");

        while (tripsIterator.hasPrevious()) {
            System.out.println(tripsIterator.previous());
        }

        assertEquals(tripsIterator.current(), londonTrip);
    }

    @Test
    void testPrototype() {
        TripsCollection clonedTrips = collectedTrips.clone();
        clonedTrips.getTrips().get(0).setPrice(10000);

        assertAll("Not refering to the same object and not equal",
                () -> assertNotSame(clonedTrips, collectedTrips),
                () -> assertNotEquals(clonedTrips, collectedTrips)
        );
    }

    @Test
    void testFacade() {
        TripVisitor visitor = new TripVisitor();
        status1.add(Status.Employed);
        status1.add(Status.Married);
        status1.add(Status.WellBred);
        p1.setStatus(status1);

        status2.add(Status.Single);
        status2.add(Status.WellBred);
        status2.add(Status.Employed);
        p2.setStatus(status2);

        status3.add(Status.Divorced);
        status3.add(Status.Single);
        status3.add(Status.Employed);
        p3.setStatus(status3);

        List<Person> personsList = Arrays.asList(p1, p2, p3);

        londonTrip.accept(visitor);
        parisTrip.accept(visitor);
        viennaTrip.accept(visitor);
        List<Trip> tripList = Arrays.asList(londonTrip, parisTrip, viennaTrip);

        for (int i = 0; i < personsList.size(); i++) {
            for (int j = 0; j < tripList.size(); j++) {
                if(TripFacade.tripAvailableAndAffordable(personsList.get(i), tripList.get(j))){
                    personsList.get(i).payForTrip(tripList.get(j));
                    tripList.get(j).addParticipant(personsList.get(i));
                }
            }
        }

        List<Person> personsInLondonTrip = new ArrayList<>();
        personsInLondonTrip.addAll(tripList.get(0).getParticipants());
        List<Person> personsInParisTrip = new ArrayList<>();
        personsInParisTrip.addAll(tripList.get(1).getParticipants());
        List<Person> personsInViennaTrip = new ArrayList<>();
        personsInViennaTrip.addAll(tripList.get(2).getParticipants());


        assertAll("Not refering to the same object and not equal",
                () -> assertEquals(personsInLondonTrip, Stream.of(p1).collect(Collectors.toList())),
                () -> assertEquals(personsInParisTrip, Stream.of(p3,p2).collect(Collectors.toList())),
                () -> assertEquals(personsInViennaTrip, Stream.of().collect(Collectors.toList()))
        );
    }
}
