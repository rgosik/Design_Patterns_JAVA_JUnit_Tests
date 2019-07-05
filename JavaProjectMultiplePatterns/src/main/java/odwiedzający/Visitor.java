package odwiedzający;

import model.Trip;

public interface Visitor {
    void visit(Trip trip);
}
